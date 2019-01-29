package main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	
	//static variable for health of player 
	public static float HEALTH = 100;
	//new varibale for changing health bar color 
	private float greenValue =255;
	
	private int score=0;
	private int level = 1;
	public void tick()
	{
		
		//Limiting the health to the desired length 
		HEALTH = Game.clamp(HEALTH, 0, 100);
		//clamping the green value color 
		greenValue = Game.clamp(greenValue,  0,  255);
		score++;
		greenValue = HEALTH*2;
		
		
	}
	public void render(Graphics g)
	{
		//drawing the bar for displaying the health bar of the game 
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		//drawing the bar for displaying the health of the game 
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(15, 15, (int)(HEALTH *2), 32);
		//drawing the bar for displaying a white border around the health  
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
	}
	//set method for score 
	public void setScore(int score){
		this.score= score;
	}
	//getr method for score 
	public int getScore(){
		return score;
	}
		//set method for level 
		public void setLevel(int level){
			this.level= level;
		}
		//getr method for score 
		public int getLevel(){
			return level;
	}
	
}
