package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	//creating an instance of the handler 
	private Handler handler;
	//overloading the constructer 
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		//values from the parent class 
		super(x, y, id);
		//setting horizontal and verticle speed 
		velX = 5;
		velY = 5;
		//setting handler using this keyword 
		this.handler=handler;
	}

	@Override
	public void tick() {
	x += velX;
	y += velY;
	
	if(y <=0 || y>= Game.HEIGHT - 32) velY *= -1;
	if(x <=0 || x>= Game.WIDTH -16) velX *= -1;
	
	handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.red, 16, 16,  0.02f ,handler));
		
	}
	//creating a bound for the enemy 
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int) x, (int)y, 16, 16);
		
	}

}
