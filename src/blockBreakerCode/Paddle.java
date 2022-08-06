package blockBreakerCode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {

	private double posX,posY;
	private double velX;
	private int width,height;
	private final double MS=6,ACCEL=0.7,GRAVITI=0.95;
	private Rectangle bounding;
	
	public Paddle(int x,int y,int width,int height){
		
		this.posX=x;
		this.posY=y;
		this.width=width;
		this.height=height;
		bounding = new Rectangle(x,y,width,height);
		
	}
	
	public void move(){
		//bescheunigen
		if(Keyboard.isKeyDown(KeyEvent.VK_A))
			velX-=ACCEL;
		if(Keyboard.isKeyDown(KeyEvent.VK_D)){
			velX+=ACCEL;
		}
			
		
		if(velX>MS)	//MS Cap
			velX=MS;
		if(velX<-MS)
			velX=-MS;
		
		//auslaufen lassen
		if(!Keyboard.isKeyDown(KeyEvent.VK_A)
				&&!Keyboard.isKeyDown(KeyEvent.VK_D))
			velX*=GRAVITI;
			
		
		posX+=velX;
		if(posX>Main.WIDTH-width||posX<0)
			posX-=velX;
		bounding.setLocation((int)posX, (int)posY);
	}
	
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect((int)posX, (int)posY, width, height);
	}
	
	public Rectangle getBounding(){return bounding;	}
	public double getVelX(){return velX;	}
	public double getY(){return posY;	}
	public double getX(){return posX;	}
	public double getWidth(){return width;	}
	public double getHeight(){return height;	}
	
	public void setWidth(int w){width=w;	}
	public void setY(double y){posX=y;	}
	
}





















