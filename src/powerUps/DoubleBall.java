package powerUps;

import blockBreakerCode.Ball;
import blockBreakerCode.Block;
import blockBreakerCode.Main;

public class DoubleBall extends PowerUps{
	

	
	public DoubleBall(Block block){
		good=true;
		posX=block.getBounding().getCenterX();
		posY=block.getBounding().getCenterY();
	}
	
	
	
	public void collect(){
		existing= false;
		
		int n= Main.balls.size();
		Main.balls.add(new Ball((int)Main.p1.getBounding().getCenterX(), (int)Main.p1.getBounding().getCenterY()- (int)Main.p1.getHeight()-8));
		Main.balls.get(n).setVelX(0);
		
	}


	
}
