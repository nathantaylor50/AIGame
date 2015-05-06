package ai.game.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {
	//jframe object
	private JFrame frame;
	//canvas object
	private Canvas canvas;
	
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
		
		//initilize canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		
		//add canvas to the frame
		frame.add(canvas);
		//resize window to show canvas
		frame.pack();
		
	}
	//get canvas
	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}
}
