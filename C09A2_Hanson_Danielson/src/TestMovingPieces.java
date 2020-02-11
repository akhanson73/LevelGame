import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Chair;
import levelPieces.Dragon;
import levelPieces.Guard;
import levelPieces.Prize;

public class TestMovingPieces {
	
	/*
	 * Authors: Amanda Hanson, Lexi Danielson
	 */

	@Test
	public void testDragonRandomMovement() {
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 1, leaves 0 open
		for (int i=1;i<=5; i++)
			gameBoard[i] = new Chair();
		// Leave 6 open
		for (int i=7; i<=11; i++)
			gameBoard[i] = new Chair();
		// Leave 12, 13 and 20 open, assume player in 13
		for (int i=14; i<20; i++)
			gameBoard[i] = new Chair();
		// Place Dragon in an open space - 6
		// Note that Dragon location will be updated via move method, 
		// so occasionally location 6 will be open and may be chosen
		Dragon drag = new Dragon(6);
		gameBoard[6] = drag;
		int count0 = 0;
		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		for (int i=0; i<200; i++) {
			drag.move(gameBoard, 13);
			int loc = drag.getLocation();
			// there are no invalid spaces for the dragon
			// counters to ensure every valid option is chosen
			if (loc == 0) count0++;
			if (loc == 6) count6++;
			if (loc == 12) count12++;
			if (loc == 20) count20++;
		}
		// Ensure each option is randomly chosen some number of times. 
		assert(count0 > 1);
		assert(count6 > 1);
		assert(count12 > 1);
		assert(count20 > 1);
	}
	
	@Test
	public void testPrizeMovevement() {
		//Prize should always move +1, -1, or 0 spaces
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Prize prize = new Prize(10);
		gameBoard[10] = prize;
		int prevLoc = prize.getLocation();
		//assuming player is on location 4
		for (int i=0; i<200; i++) {
			prize.move(gameBoard, 4);
			int loc = prize.getLocation();
			// there are no invalid spaces for the prize
			int direction = loc - prevLoc;
			//each movement must be valid
			assertEquals(0,direction,1);
			assert(loc <= GameEngine.BOARD_SIZE && loc >= 0);
			prevLoc = loc; //update
		}
	}
	
	@Test
	public void testGuardMovevement() {
		//Guard should always move +1, -1, or 0 spaces
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Guard guard = new Guard(15);
		gameBoard[15] = guard;
		int prevLoc = guard.getLocation();
		//assuming player is on location 10
		for (int i=0; i<200; i++) {
			guard.move(gameBoard, 10);
			int loc = guard.getLocation();
			// there are no invalid spaces for the guard
			int direction = loc - prevLoc;
			//each movement must be valid (+/-1)
			assert(direction == 1 || direction == -1);
			assert(loc <= GameEngine.BOARD_SIZE && loc >= 0);
			prevLoc = loc; //update
		}
	}

}
