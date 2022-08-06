package blockBreakerCode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import powerUps.PowerUps;

public class Block {
	
	private int posX,posY;
	public boolean Visible=true;
	public static int zwischenRaum =10;
	private static int width,height=40;
	private static final int MAXHEIGHT = 40;
	private static final int BLOCKAREA = 200;
	public boolean powerUp = false;
	
	private Rectangle bounding;
	
	public static List<Block> blocks= new ArrayList<Block>();
	
	public Block(int posX,int posY){
		this.posX=posX;
		this.posY=posY;
		bounding = new Rectangle(posX,posY,width,height);
		
		Random ran = new Random();
		if((ran.nextInt(10000)/100)<PowerUps.chance*100)
			powerUp=true;
		
	}
	public Block(){}
	
	public static void addBlocks(int nX, int nY){
		
		width=Main.WIDTH/nX-zwischenRaum-zwischenRaum/nX;
		
		height=BLOCKAREA/nY-zwischenRaum-zwischenRaum/nY;
		if(height>MAXHEIGHT)
			height=MAXHEIGHT;
		
		for(int y=0;y<nY;y++)
		{
			for(int x=0;x<nX;x++)
			{	//1x Layer
				blocks.add(new Block(zwischenRaum*(x+1)+width*x, zwischenRaum*(y+1)+height*y));
				
			}
		}
		
		
	}
	public static void update(){
		boolean allBlocksHit=true;
		for(int i=0;i<blocks.size();i++)
		{
			if(blocks.get(i).Visible)
			{
				allBlocksHit=false;
			}
		}
		for(int n=0;n<Main.balls.size();n++)
		{
			if(allBlocksHit&&Main.balls.get(n).getY()>BLOCKAREA)
			{
				for(int i=0;i<blocks.size();i++)
				{
					blocks.get(i).isVisible(true);
				}
			}
		}
	}
	
	
	
	public static void draw(Graphics g){
		
		for(int i=0;i<blocks.size();i++)
		{
			if(blocks.get(i).powerUp)
				g.setColor(Color.BLUE);
			else
				g.setColor(Color.WHITE);
			
			if(blocks.get(i).Visible)
				g.fillRect(blocks.get(i).getX(), blocks.get(i).getY(), width, height);
		}
		
	}
	
	public int getX(){return posX;	}
	public int getY(){return posY;	}
	public void setLocation(int x,int y){
		this.posX=x;
		this.posY=y;
	}
	public Rectangle getBounding(){return bounding;	}
	
	
	public void hit(){
		isVisible(false);
		if(powerUp){
			PowerUps.add(this);
		}
	}
	
	private void isVisible(boolean b){Visible=b;	}
}
