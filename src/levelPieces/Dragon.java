package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.Random;

public class Dragon extends GamePiece implements Moveable {
	//randomly moves
	//hits within a two-unit radius

	public Dragon(char symbol, int location) {
		super(symbol, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		// TODO Auto-generated method stub
		if (Math.abs(super.getLocation()-playerLocation)<2) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int loc = rand.nextInt(GameEngine.BOARD_SIZE);

		//set board position piece to null
		gameBoard[super.getLocation()] = null;
		//update position
		super.setLocation(loc);
		//push location to board
		gameBoard[super.getLocation()] = this;
		
	}
	
}
