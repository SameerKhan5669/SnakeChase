package main;

import java.util.Random;

public class Spawn {
	//crating an instance of the handler 
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r=new Random();	
	//constructor for this class
	public Spawn(Handler handler, HUD hud){
		this.handler=handler;
		this.hud=hud;
	}
	//this method will control the spawning system of the game 
	public void tick(){
	//increasing the score keep variable  
		scoreKeep++;
		//making the game add a new object when score increases by 1000
		if(scoreKeep >= 500){
			//resetting the score keep holder 
			scoreKeep=0;
			//increasing the level display 
			hud.setLevel( (hud.getLevel()+1));
			//checking if the level is increased and if it is then adding a new enemy 
			if(hud.getLevel() == 2){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
		}
			//checking if the level is increased and if it is then adding two new enemies
			else if(hud.getLevel() == 3){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				
			}
			//checking if the level is increased and if it is then adding the fast enemy 
			else if(hud.getLevel() == 4){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				
			}
			//checking if the level is increased and if it is then adding the samrt enemy 
			else if(hud.getLevel() == 5){
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
				
			}
			
		}
	}
}
