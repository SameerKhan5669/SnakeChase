package main;
//import for the canvas
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	//the serial id for Window 
	private static final long serialVersionUID = -3592540922963019935L;

	public Window(int width, int height, String title, Game game)
	{
		//creating a jframe for the frame of the window
		JFrame frame=new JFrame(title);
		
		//setting the new dimension 
		frame.setPreferredSize(new Dimension(width, height));
		//setting the minumum size 
		frame.setMinimumSize(new Dimension(width, height));
		//setting the maximum size 
		frame.setMaximumSize(new Dimension(width, height));
		
		//telling the frame to close when X button is clicked 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//not allowing the window to be resized
		frame.setResizable(false);
		//making the window start at the middle of screen
		frame.setLocationRelativeTo(null);
		//adding the game class into the frame
		frame.add(game);
		//making the frame visible so we can see it 
		frame.setVisible(true);
		//starting the game method 
		game.start();
		//getting the screen to focus on the game as soon as it starts 
		game.requestFocus();
	}

}
