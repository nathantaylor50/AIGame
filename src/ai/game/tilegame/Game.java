package ai.game.tilegame;

import ai.game.tilegame.display.Display;
//runs on a thread
public class Game implements Runnable {
	
	private Thread thread;
	private boolean running = false;
	
	private Display display;
	public int width, height;
	public String title;
	
	private void init(){
		display = new Display(title, width, height);
	}
	
	private void update(){
		
	}
	
	private void render(){
		
	}
	//contructor
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	

	
	//needs this method for 'implements runnable' to work
	public void run(){
		init();
		
		//game loop
		while(running){
			update();
			render();
		}
		//stops thread
		stop();
	}
	
	//thread method
	public synchronized void start(){
		//check is game is already running
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start(); //calls run method
	}
	//thread method
	public synchronized void stop(){
		//check is game is not running
		if(!running)
			return;
		running = false;
		try {
			thread.join(); //close down thread
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
