package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
	//creating an instance of the handler 
	private Handler handler;
	private GameObject player;
	//overloading the constructor 
	public SmartEnemy(float x, float y, ID id, Handler handler) {
		//values from the parent class 
		super(x, y, id);
		//setting horizontal and vertical speed 
		
		//setting handler using this keyword 
		this.handler=handler;
		for(int i=0; i<handler.object.size(); i++)
		{
			if (handler.object.get(i).getID()==ID.Player) player =handler.object.get(i);
		}
		
		
		
		
	}
	//setting the bounds for the rectangle for intersection 
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	
	public void tick() {
	//these are the algorithms for getting the distance from the player
	float diffX = x - player.getX() - 16;
	float diffY = y - player.getY() - 16;
	//using the math. square root function
	float distance =  (float) Math.sqrt((x-player.getX())*(x-player.getX())+ (y-player.getY())*(y-player.getY()));
	
	//setting the velocity x for the smart enemy  
	velX= (float) ((-1/distance) * diffX); 
	//setting the velocity x for the smart enemy  
	velY= (float) ((-1/distance) * diffY); 
	//if(y <=0 || y>= Game.HEIGHT - 32) velY *= -1;
	//if(x <=0 || x>= Game.WIDTH -16) velX *= -1;
	x += velX;
	y += velY;
	
	
	handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16,  0.02f ,handler));
		
	}
	//creating a bound for the enemy 
	
	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
