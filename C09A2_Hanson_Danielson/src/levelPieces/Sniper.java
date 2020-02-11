package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Sniper extends GamePiece implements Drawable {
	//doesnt move
	//kills player if the player is ever at the target location
	//target doesnt move

	public Sniper(int location, int target) {
		super('s', location);
		// TODO Auto-generated constructor stub
		this.target = target;
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		// TODO Auto-generated method stub
		if (playerLocation == this.target) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
	
	public int target;

}
