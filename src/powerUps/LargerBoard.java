package powerUps;

import blockBreakerCode.Block;
import blockBreakerCode.Main;

public class LargerBoard extends PowerUps{
	
	private final int MAXBOARDSIZE= (int) (Main.p1.getWidth()*2);
	
	public LargerBoard(Block block){
		good=true;
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
		
		if(Main.p1.getWidth()<MAXBOARDSIZE)
			Main.p1.setWidth((int)Main.p1.getWidth()+10);
		
		if(Main.p1.getX()+Main.p1.getWidth()>Main.WIDTH){
			Main.p1.setY(Main.WIDTH-Main.p1.getWidth()-10);
		}
		
	}
}