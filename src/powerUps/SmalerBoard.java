package powerUps;

import blockBreakerCode.Block;
import blockBreakerCode.Main;

public class SmalerBoard extends PowerUps{
	
	private final int MINBOARDWIDTH= (int) (Main.p1.getWidth()/2);
	
	public SmalerBoard(Block block){
		good=false;
		posX=block.getBounding().getCenterX();
		posY=block.getBounding().getCenterY();
	}

	/*
	 * The Effekt of the SmalerBoard:
	 * making the paddle smaler
	 */
	@Override
	public void collect() {
		existing=false;
		
		if(Main.p1.getWidth()>MINBOARDWIDTH)
			Main.p1.setWidth((int)Main.p1.getWidth()-10);
		
	}
}
