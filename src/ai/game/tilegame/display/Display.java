package ai.game.tilegame.display;

import javax.swing.JFrame;

public class Display {
	//jframe object
	private JFrame frame;
	
	private String title;
	private int width, height;
	
	// initilize variables for function createDisplay
	public Display(String title, int width, int height){
		this.title = title; 
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	//initilize jframe
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		//display will close properly
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//users cannot resize window
		frame.setResizable(false);
		//center of screen on creation
		frame.setLocationRelativeTo(null);
		//is invisable by default
		frame.setVisible(true);
		//frame.something
	}
}
