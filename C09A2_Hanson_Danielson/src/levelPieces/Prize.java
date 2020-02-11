package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Prize extends GamePiece implements Moveable {
	//either moves left, right, or neither by one unit
	//and gives player a point if at same location

	public Prize(int location) {
		super('!', location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		// TODO Auto-generated method stub
		if (super.getLocation() == playerLocation) {
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int direction;
		if (super.getLocation() == 0) {
			//can't move left (-1)
			direction = rand.nextInt(1);			
		}
		if (super.getLocation() == GameEngine.BOARD_SIZE-1) {
			//can't move right (1)
			direction = rand.nextInt(1)-1;	
		}
		//move left (-1) / right (1) / neither (0)
		direction = rand.nextInt(2)-1;

		//set board position piece to null
		gameBoard[super.getLocation()] = null;
		//update position
		super.setLocation(super.getLocation()+direction);
		//push location to board
		gameBoard[super.getLocation()] = this;
		
	}

}
