package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	
	private static final long serialVersionUID = 6691247796639148462L;
	
	//Setting the size for height and width and making aspect ration of 16:9
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	//entire game will run in this thread
	private Thread thread;
	private boolean running = false;
	public static boolean paused = false;
	
	
	//crating a instance of the randome functionj 
	private Random r;
	//crating a instance of the handler
	private Handler handler;
	//crating a instance of the hud
	private HUD hud;
	//crating a instance of the spawner 
	private Spawn spawner;
	//crating a instance of the menu 
	private Menu menu;
	//this is a mini enum used for the gaem states
	public enum STATE {
	Menu,
	Help,
	Game,
	End
	};
	public STATE gameState = STATE.Menu;
	
	public Game(){
		//initializing the handler 
		handler = new Handler();
		hud = new HUD();
		//initializing the main menu 
		menu = new Menu(this, handler, hud);
		//telling the game program that we will be using key input 
		this.addKeyListener(new KeyInput(handler));
		//telling the game program that we will be using mouse input 
		this.addMouseListener(menu);
		//initializing the window 
		new Window(WIDTH, HEIGHT, "Dodge", this);
		
		spawner = new Spawn(handler, hud);
		
		r=new Random();
		if (gameState == STATE.Game)
		{
			//spanning the player into the game window 
			handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			//spanning the enemy in to the game 
		}
		
		
	 
	
		}
	//method for starting the game 
	public synchronized void start(){
		//starting a new thread 
		thread =new Thread(this);
		thread.start();
		//varibale for deciding if the thread runs or not 
		running = true;
	}
	//method for ending the game
	
	public synchronized void stop(){
		try{
			//stopping the thread 
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*we need a loop that performs 2 things: it checks whether enough time 
	 * has passed (1/60 sec) to refresh the game, and checks whether enough 
	 * time has passed (1 sec) to refresh the FPS counter; while 'running' 
	 * it adds the time it took to go through one iteration of the loop it 
	 * self and adds it to delta (which is simplified to 1) so once it reaches 
	 * 1 delta it means enough time has passed to go forward one tick.
	 */
	public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                              //  System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    }
    //this is the tick method 
	private void tick(){
		//checking if the game is paused 
		if (gameState == STATE.Game)
		{
			//if not paused then starting the game up and keeping everything running 
			if (!paused)
			{
			hud.tick();
			spawner.tick();
			handler.tick();
			}
		if (HUD.HEALTH <= 0){
			HUD.HEALTH = 100;
			
			gameState = STATE.End;
			
			
			handler.object.clear();
		}
		}
		//rendering it appropriately based on  what state the game is in 
		else if (gameState == STATE.Menu || gameState == STATE.End)
		{
			menu.tick();
			handler.tick();
		}
		
    	
    }
    
    private void render(){
    	BufferStrategy bs=this.getBufferStrategy();
    	if(bs == null){
    		//the number of buffers that will be created 
    		this.createBufferStrategy(3);
    		return;
    	}
    	//creating the graphics variables
    	Graphics g = bs.getDrawGraphics();
    	//setting the color of the rectangle game background 
    g.setColor(Color.white);
    //making the color of the game fit the entire screen
    g.fillRect(0, 0, WIDTH, HEIGHT);
    //rendering the handler  	
    handler.render(g);
    g.setColor(Color.white);
   
   
    if(paused){
    	g.drawString("GAME PAUSED", 300, 50);
    }
    
    if (gameState == STATE.Game)
	{
    	hud.render(g);
	}
    else if (gameState == STATE.Menu||gameState == STATE.Help || gameState == STATE.End)
	{
		menu.render(g);
	}
   
    
    //rendering the hud (heads up display)	
    
    g.dispose();
    bs.show();
    
    }
    //method for limiting player movement into the game screen
    public static float clamp(float var, float min, int max){
    	//cheking if var is bigger then max 
		if(var >= max)
		{
    	return var = max;
		}
		//cheking if var is less then max 
    	else if (var <= min)
			{return var = min;}
		else 
			{return var;}
    }
		
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
		
	}

}
