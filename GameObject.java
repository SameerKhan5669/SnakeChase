package main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	/*All the objects in the game will inherit from this abstract class 
	 *this class will initialize all the variables in the game 
	 */
	//the variable that will allow to set the width and height for each object in the game 
	protected float x, y;
	protected ID id;
	//creating variables to control the speed of each of the objects  
	protected float velX, velY;
	
	public GameObject(float x, float y, ID id)
	{
		this. x = x;
		this. y= y;
		this.id = id;
	}
	//creating all the abstract methods for this class 
	public abstract void tick();
	public abstract void render(Graphics g);
	//mehtods for the intersection of the player and the enemy in the game
	public abstract Rectangle getBounds();
	
	//creating the set method for x 
	public void setX(float x ){
		//this is used to refer to the created x above and not in this method 
		this.x =x;
	}
	//creating the set method for y
	public void setY(float y ){
		//this is used to refer to the created y above and not in this method 
		this.y =y;
	}
	//creating the get method for x 
	public float getX(){
		return x;
	}
	//creating the get method for y 
	public float getY(){
		return y;
	}
	//creating the get method for y 
	public void serId(ID id){
		this.id=id;
	}
	//creating the get method for y 
	public ID getID(){
		return id;
	}
	//creating the get method for y 
	public void setVelX(int velX){
		this.velX = velX;
	}
	//creating the get method for y 
	public void setVelY(int velY){
		this.velY = velY;
	}
	//creating the get method for y 
	public float getVelX()
	{
		return velX;
	}
	//creating the get method for y 
	public float getVelY()
	{
		return velY;
	}
	
	
	
	
	

	
	
	
}
