package main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
/*The class that will handle and process each one of the objects 
 *this will also loop through all the objects in the game 
 * it will individually render and update each object in the game 
 */
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		//for loop to run through every object in the game 
		for (int i=0; i < object.size(); i++)
		{
			//function in the linked list, allowing us to get the id of what object we are at
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	public void render(Graphics g){
		for (int i=0; i < object.size(); i++)
		{
			//function in the linked list, allowing us to get the id of what object we are at
			GameObject tempObject = object.get(i);
			//this will render all the game objects 
			tempObject.render(g);
		}
	}
	
	
	//crating a method to add a object to the linked list 
	public void addObject(GameObject object){
		this.object.add(object);
		
		
	}
	//crating a method to remove a object from the linked list 
	public void removeObject(GameObject object){
			this.object.remove(object);
			
			
		
	}
}
