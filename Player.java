package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

		Random r = new Random();
		//creating an instance of the handler class 
		Handler handler;
		//creating a constructor for the player class 
		public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler=handler;
	
	
	}

	
	public void tick() {
		
		//making the horizontal location of player increase as its vel x is increased 
		x+= velX;
		//making the vertical location of player increase as its vel y is increased 
		y+= velY;
		//limiting the x variable to the game size 
		x = Game.clamp((int)x, 0, Game.WIDTH - 38);
		//limiting the y variable to the game size 
		y = Game.clamp((int)y, 0, Game.HEIGHT - 61);
		//calling the collision method
		collision();
		//adding the trial
		handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white, 32, 32,  0.05f ,handler));
	}

	//Method for the collision testing of the player and the enemy 
	private void collision() {
		//running thorugh all the different objects 
	for (int i = 0; i< handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			//temp object is now the basic enemy
			if(tempObject.getID() == ID.BasicEnemy || tempObject.getID() == ID.FastEnemy|| tempObject.getID() == ID.SmartEnemy)
			{
				//code for the collision of the player and the enemy 
				//checking of the player and the enemnt are intersecting 
				if(getBounds().intersects(tempObject.getBounds()))
				{
					//if this true then the health decreases 
					HUD.HEALTH -=2;
				}
			}
		}
		
	}

	//method for rendering the graphics 
	public void render(Graphics g) {
		
		
		// TODO Auto-generated method stub
		//setting the color and location of the player 
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	}


	//creating a bound for the enemy 
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int) y, 32, 32);
	}
	
	

}
