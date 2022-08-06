package blockBreakerCode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import powerUps.PowerUps;



@SuppressWarnings("serial")
public class Gui extends JFrame{
	
	private BufferStrategy strat;

	public Gui(int width,int height)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		addKeyListener(new Keyboard());
	}
	
	public void makeStrat(){
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}
	
	public void repaintScreen(){
		Graphics g = strat.getDrawGraphics();
		draw(g);
		g.dispose();
		strat.show();
	}
	
	private void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getWidth());
		PowerUps.drawPowerUps(g);
		Ball.drawBalls(g);
		Main.p1.draw(g);
		Block.draw(g);
	}
}
