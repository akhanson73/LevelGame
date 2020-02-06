package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Trap extends GamePiece implements Drawable {
	//doesn't move
	//hits player on same place

	public Trap(char symbol, int location) {
		super(symbol, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		// TODO Auto-generated method stub
		if (super.getLocation() == playerLocation) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
