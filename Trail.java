package main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/*This class is for creating a trail to make the visual of the game
 * more appealing to the viewer 
 */
public class Trail extends GameObject{

	//declaring the variables 
	private float alpha = 1;
	private Handler handler;
	private Color color;
	private int width;
	private int height;
	//declaring the variable for life which will vary between 0.001 and 0.1
	private float life;
	//overloading the constructor
	public Trail(float x, float y, ID id, Color color, int width, int height, float life, Handler handler) {
		//calling the parent class 
		super(x, y, id);
		//setting the color 
		this.color=color;
		//setting the handler  
		this.handler=handler;
		//setting the width  
		this.width=width;
		//setting the height 
		this.height=height;
		//setting the life 
		this.life=life;
		
		
		
	}

	public static void main(String[] args) {
	

	}

	//the smaller the number the longer the life of the trail 
	public void tick() {
		if (alpha > life){
			alpha -= (life - 0.0001f);
			
		}else handler.removeObject(this);
		
	}


	public void render(Graphics g) {
		//Converting the graphics to 2d by using type casting 
		Graphics2D g2d = (Graphics2D) g;
		//making alpha transparent 
		g2d.setComposite(makeTransparent(alpha));
		//drawing out the trail
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
		g2d.setComposite(makeTransparent(1));
		
	}
	//the method that will allow us to make the trail somewhat transparent for a more appealing application 
	private AlphaComposite makeTransparent(float alpha){
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type, alpha));
		
	}
	public Rectangle getBounds() {
		
		return null;
	}

}
