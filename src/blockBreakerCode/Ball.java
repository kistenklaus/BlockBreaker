package blockBreakerCode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Ball {
	
	private double posX,posY;
	private final double MS=3,ACCEL=0.008,GRAVITI=0.995;
	private double velX=MS,velY=MS;
	private int width=20,height=20;
	private Paddle p1;
	private Rectangle bounding;
	private boolean alive=true;
	
	public Ball(int posX,int posY){
		this.posX=posX;
		this.posY=posY;
		p1=Main.p1;
		bounding = new Rectangle(posX,posY,width,height);
	}
	
	
	public static void moveBalls(List<Ball> balls){
		for(int i=0;i<balls.size();i++)
			balls.get(i).move();
	}
	
	public void move(){
		if(alive){
			if(posY<height/2)
				velY*=-1;
			
			else if(posY>Main.HEIGHT-height/2){
				alive=false;
			}
				
				
			if(posX<width/2||posX>Main.WIDTH-width/2)
				velX*=-1;
			
			
			if(posY>p1.getY()-p1.getHeight()
					&&posX>p1.getX()&&posX<p1.getX()+p1.getWidth())
			{
				velY*=-1;
				velX=(velX+p1.getVelX());
			}
			
			
			for(int i=0;i<Block.blocks.size();i++)		//Block Intersection
			{
				if(Block.blocks.get(i).Visible&&Block.blocks.get(i).getBounding().intersects(bounding))
				{
					Rectangle intersection = new Rectangle(Block.blocks.get(i).getBounding().intersection(bounding));
					if(intersection.getHeight()>intersection.getWidth())
					{
						velX*=-1;
					}else
					{
						velY*=-1;
					}
					
					Block.blocks.get(i).hit();
					
				}
			}
		}
		
		
		
		//handeling Speed form the Ball keeping it at MS speed;
		if(velX<MS&&velX>-MS)
			if(velX<0)
				velX-=ACCEL;
			else
				velX+=ACCEL;
		
		if(velY<MS&&velY>-MS)
			if(velY<0)
				velY-=ACCEL;
			else
				velY+=ACCEL;
		
		if(velX>MS||velX<-MS)
			velX*=GRAVITI;
		if(velY>MS||velY<-MS)
			velY*=GRAVITI;
		
		//Velositi rechnung
		posX+=velX;
		posY+=velY;
		bounding.setLocation((int)posX, (int)posY);
	}
	
	public static void drawBalls(Graphics g){
		for(int i=0;i<Main.balls.size();i++)
			Main.balls.get(i).draw(g);
	}
	
	public void draw(Graphics g){
		if(alive){
			g.setColor(Color.WHITE);
			g.fillOval((int)posX-width/2, (int)posY-height/2, width, height);
		}
	
	}
	

	
	public int getY(){
		return (int) posY;
	}
	public void setVelX(double vel){velX=vel;	}
}
