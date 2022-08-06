package blockBreakerCode;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import powerUps.PowerUps;

public class Main {
	public static final int WIDTH=700,HEIGHT=500;
	public static Paddle p1 = new Paddle(250,460,80,20);
	public static List<Ball> balls = new ArrayList<Ball>();


	
	public static void main(String[] args) {
		Block.addBlocks(5,5);
		
		Gui gui= new Gui(WIDTH,HEIGHT);
		gui.makeStrat();
		balls.add(new Ball(100,250));
		
		while(true)
		{
			if(Keyboard.isKeyDown(KeyEvent.VK_ESCAPE))System.exit(0);;
			
			
			p1.move();
			PowerUps.updatePowerUps();
			
			Ball.moveBalls(balls);
			Block.update();
			gui.repaintScreen();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
