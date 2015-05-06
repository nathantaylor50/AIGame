package ai.game.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import ai.game.tilegame.display.Display;
import ai.game.tilegame.gfx.Assets;
import ai.game.tilegame.input.KeyManager;
import ai.game.tilegame.states.GameState;
import ai.game.tilegame.states.MenuState;
import ai.game.tilegame.states.State;

//runs on a thread
public class Game implements Runnable {
	//thread
	private Thread thread;
	private boolean running = false;
	
	//graphics
	private BufferStrategy bs;
	private Graphics g;
	
	//states
	private State gameState;
	private State menuState;
	
	//input
	private KeyManager keyManager;
	
	private Display display;
	
	public int width, height;
	public String title;
	
	private void init(){
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		//call init method and load images from assets class
		Assets.init();
		
		//init declaration
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
		
	}
	

	private void tick(){
		keyManager.tick();
		//if we dont have a state
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		//if canvas doesnt have a buffer strategy, create one
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, height);
		//draw to screen
		
		//if there is no state render
		if(State.getState() != null)
			State.getState().render(g);
		
		
		
		//end draw
		bs.show();
		g.dispose();
	}
	
	//contructor
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	

	
	//needs this method for 'implements runnable' to work
	public void run(){
		init();
		//frames per second, 60 times per seond
		int fps = 60;
		//9 billion nano seconds(1 second) / fps
		double timePerUpdate = 1000000000 / fps;
		double delta = 0;
		long now;
		//returns amount of time in nano seconds player's computer is running at
		long lastTime = System.nanoTime();
		//fps counter
		long timer = 0;
		int updates = 0;
		
		//game loop
		while(running){
			//now = current time of computer in nano secs
			now = System.nanoTime();
			// delta += amount of time pasted / max amout of time to call update and render
			delta += (now - lastTime) / timePerUpdate;
			timer += now - lastTime;
			//update last time
			lastTime = now;	
			if(delta >= 1){
				tick();
				render();
				updates++;
				delta--;
			}
			if(timer >= 1000000000){
				System.out.println("FPS: " + updates);
				updates = 0;
				timer = 0;
			}
		}
		//stops thread
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
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
