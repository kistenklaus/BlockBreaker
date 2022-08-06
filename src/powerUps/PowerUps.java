package powerUps;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import blockBreakerCode.Block;
import blockBreakerCode.Main;

public abstract class PowerUps {
	
	public static double chance = 0.16;	//in prozentage
	public static List<PowerUps> powerUps = new ArrayList<PowerUps>();
	
	protected double posY,posX;
	protected final int WIDTH=15,HEIGHT=15;
	protected final double VELY = 2;
	
	protected boolean existing = true;
	
	protected boolean good;
	
	/*
	 * 	adds the powerUps and with the right Type
	 * 
	 */
	public static void add(Block block){
		
		Random ran = new Random();
		byte type=(byte) ran.nextInt(3);
		
		switch(type){
		case 0:
			powerUps.add(new DoubleBall(block));
			break;
		case 1:
			powerUps.add(new SmalerBoard(block));
			break;
		case 2:
			powerUps.add(new LargerBoard(block));
			break;
		}
	}
	
	/*
	 *  updates all powerUps
	 */
	public static void updatePowerUps(){
		for(PowerUps pU:powerUps)
		{
			pU.update();
		}
	}
	public void update(){
		if(existing){
			posY+=VELY;
				
			if(posY>Main.p1.getY()-Main.p1.getHeight()
					&&posX>Main.p1.getX()&&posX<Main.p1.getX()+Main.p1.getWidth())
				collect();
			
			if(posY>Main.HEIGHT)
				existing=false;
		}
	}
	
	public static void drawPowerUps(Graphics g){
		for(PowerUps pU: powerUps)
			pU.draw(g);
	}
	public void draw(Graphics g) {
		if(existing){
			
			if(good){
				g.setColor(Color.GREEN);
			}else{
				g.setColor(Color.RED);
			}
			
			
			g.fillOval((int)posX, (int)posY, WIDTH, HEIGHT);
		}
	}
	
	public abstract void collect();
	
}









