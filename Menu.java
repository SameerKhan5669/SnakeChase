package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import main.Game.STATE;
/*This is the public class that uses mouse input in order to have a main menu setup  
 * this will allow the user to start and stop the game as well as exit
 */
public class Menu extends MouseAdapter{
	//creating instances of all the other classes 
	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;
	//the overloaded constructor for the menu 
	public Menu(Game game, Handler handler, HUD hud){
		this.game=game;
		this.hud = hud;
		this.handler=handler;
		
	}
	//method for controlling mouse input
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		//state check for menu 
	if (game.gameState == STATE.Menu){
		//play button
		
		if (mouseOver(mx, my, 210, 130, 200, 64)){
			game.gameState=STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
		}
		
		//quit button
		if (mouseOver(mx, my, 210, 330, 210, 64)){
			System.exit(1);
		}
		//help button
		if (mouseOver(mx, my, 210, 230, 210, 64)){
			game.gameState = STATE.Help;
		}
	}
		//back button for help 
		if (game.gameState == STATE.Help)
		{
				if (mouseOver(mx, my, 210, 350, 210, 64)){
					game.gameState = STATE.Menu;
					return;
				}
		}
		//back button for help 
				if (game.gameState == STATE.End)
				{
						if (mouseOver(mx, my, 210, 350, 210, 64)){
							game.gameState = STATE.Game;
							handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
							handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
							return;
						}
				}
	}
	//the mouse release
	public void mouseReleased(MouseEvent e){
		
	}
	//the method for checking if mouse is over the chosen box
	private boolean mouseOver(int mx, int my, int x, int y,int width, int height){
		if(mx > x && mx< x +width){
			if(my> y&& my< y + height){
				return true;
			}
			else return false;	
		}else return false;	
	}
	
	//method for outputting all the boxes and fonts
	public void render(Graphics g)
	
	{
		//checking if game state is menu 
		if(game.gameState == STATE.Menu){
			//customizing the different fonts
		Font fnt = new Font("arial", 1, 60);
		Font fnt2 = new Font("arial", 1, 30);
			
			//outputting the first box and text 
			g.setFont(fnt);
			g.setColor(Color.WHITE);
			g.drawRect(170, 15, 268, 75);
			g.drawString("DODGE", 199, 75);
			
			//outputting the second box and text 
			g.setFont(fnt2);
			g.setColor(Color.WHITE);
			g.drawRect(210, 130, 200, 64);
			g.drawString("Play Game", 237, 170);
			
			//outputting the third box and text 
			g.setColor(Color.WHITE);
			g.drawRect(210, 230, 200, 64);
			g.drawString("Help", 280, 270);
			
			//outputting the fourth box and text 
			g.setColor(Color.WHITE);
			g.drawRect(210, 330, 200, 64);
			g.drawString("Quit", 280, 370);
		}
		//Checking if game state is set to help 
		else if(game.gameState == STATE.Help){
			//customizing the new fonts 
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 20);
			Font fnt3 = new Font("arial", 1, 30);
			//setting the chosen font
				g.setFont(fnt);
				//setting the color
				g.setColor(Color.WHITE);
				//srawing the string on the game window 
				g.drawString("Help", 254, 70);
				g.setFont(fnt2);
				//outputting the help seciton details 
				g.drawString("Use WASD or Arrow keys to move player and dodge enemies", 28, 154);
				g.drawString("Created by: Sameer Khan", 210, 210);
				g.drawString("Thanks for playing", 222, 266);
				g.setFont(fnt3);
				//setting the color
				g.setColor(Color.WHITE);
				g.drawRect(210, 330, 200, 64);
				g.drawString("Back", 280, 370);
			
		}
		else if(game.gameState == STATE.End){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 20);
			Font fnt3 = new Font("arial", 1, 30);
				g.setFont(fnt);
				//setting the color
				g.setColor(Color.WHITE);
				g.drawString("Game Over", 180, 85);
				g.setFont(fnt2);
				//setting the color
				g.setColor(Color.WHITE);
				//outputting the details for game ending 
				g.drawString("You lost with a score of: "+ hud.getScore() , 178, 154);
				g.drawString("Created by: Sameer Khan", 190, 210);
				g.drawString("Thanks for playing", 222, 266);
				
				g.setFont(fnt3);
				//setting the color
				g.setColor(Color.WHITE);
				g.drawRect(210, 330, 200, 64);
				g.drawString("Try Again", 246, 370);
			
		}
	}
	//the tick method
	public void tick(){
		
	}
}
