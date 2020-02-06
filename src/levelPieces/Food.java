package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Food extends GamePiece implements Drawable {
	//doesnt move
	//advances player if player is at the same place

	public Food(char symbol, int location) {
		super(symbol, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		// TODO Auto-generated method stub
		if (playerLocation == super.getLocation()) {
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}

}
