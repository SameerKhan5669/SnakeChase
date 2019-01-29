package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	
	//creating an instance of the handler 
	private Handler handler;
	
	//creating the constructor 
	public KeyInput(Handler handler)
	{
		this.handler= handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i=0; i<handler.object.size(); i++)
		{
		GameObject tempObject = handler.object.get(i);
		
		if(tempObject.getID() == ID.Player){
			
			//key inputs for player 1 
			
			//making the player move up if w is pressed 
			if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) tempObject.setVelY(-5);
			//making the player move left if a is pressed 
			if(key == KeyEvent.VK_A|| key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
			//making the player move down if s is pressed 
			if(key == KeyEvent.VK_S|| key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
			//making the player move right if d is pressed 
			if(key == KeyEvent.VK_D|| key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
			
		}
		
		
		}
		
		if(key == KeyEvent.VK_P)
				{
				if(Game.paused) Game.paused = false;
				else Game.paused = true;
				}
		//exting the program once escape is pressed 
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	
	//method for stopping the velocity when keys are released
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i=0; i<handler.object.size(); i++)
		{
		GameObject tempObject = handler.object.get(i);
		
		if(tempObject.getID() == ID.Player){
			
			//stopping the players movements when the key is let go(released)
			if(key == KeyEvent.VK_W|| key == KeyEvent.VK_UP) tempObject.setVelY(0);
			if(key == KeyEvent.VK_A|| key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
			if(key == KeyEvent.VK_S|| key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
			if(key == KeyEvent.VK_D|| key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
			
		}
	}

}
}