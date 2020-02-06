package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Guard extends GamePiece implements Moveable {
	//moves back and forth
	//hits player within one unit

	public Guard(char symbol, int location) {
		super(symbol, location);
		if (location < GameEngine.BOARD_SIZE-1) {
			this.direction = 1; //moving right
		}
		else {
			this.direction = -1; //moving left
		}
		// TODO Auto-generated constructor stub
	}
	
	public int direction;

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if ((super.getLocation() == 0) || (super.getLocation() == GameEngine.BOARD_SIZE-1)) {
			//change direction;
			direction = -1*direction;		
		}
		//set board position piece to null
		gameBoard[super.getLocation()] = null;
		//update position
		super.setLocation(super.getLocation()+direction);
		//push location to board
		gameBoard[super.getLocation()] = this;
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		// TODO Auto-generated method stub
		if (Math.abs(super.getLocation()-playerLocation)<1) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
