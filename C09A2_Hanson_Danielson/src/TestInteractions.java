import static org.junit.Assert.*;

import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Dragon;
import levelPieces.Food;
import levelPieces.Guard;
import levelPieces.Prize;
import levelPieces.Sniper;
import levelPieces.Trap;

public class TestInteractions {
	
	/*
	 * Authors: Amanda Hanson, Lexi Danielson
	 * 
	 * each test has at least two sub-tests:
	 * 	one where nothing happens (the player isn't in the right place)
	 * 	and one where some interaction should happen
	 */

	@Test
	public void testDragonHit() {
		//Dragon hits if player is within two spaces
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Dragon dragon = new Dragon(10);
		gameBoard[10] = dragon;
		//assuming player is on location 4
		InteractionResult ir = dragon.interact(gameBoard, 4);
		//should do nothing
		assertEquals(InteractionResult.NONE,ir);
		//assuming player is on location 12
		ir = dragon.interact(gameBoard, 12);
		//should hit (within 2 spaces)
		assertEquals(InteractionResult.HIT,ir);
		//assuming player is on location 9
		ir = dragon.interact(gameBoard, 9);
		//should hit (within 2 spaces)
		assertEquals(InteractionResult.HIT,ir);
	}
	
	@Test
	public void testFoodAdvance() {
		//Food makes the player advance on the same space
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Food food = new Food(10);
		gameBoard[10] = food;
		//assuming player is on location 4
		InteractionResult ir = food.interact(gameBoard, 4);
		//should do nothing
		assertEquals(InteractionResult.NONE,ir);
		//assuming player is also on location 10
		ir = food.interact(gameBoard, 10);
		//should advance (same space)
		assertEquals(InteractionResult.ADVANCE,ir);
	}
	
	@Test
	public void testGuardHit() {
		//The guard hits the player within one space
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Guard guard = new Guard(10);
		gameBoard[10] = guard;
		//assuming player is on location 4
		InteractionResult ir = guard.interact(gameBoard, 4);
		//should do nothing
		assertEquals(InteractionResult.NONE,ir);
		//assuming player is on location 11
		ir = guard.interact(gameBoard, 11);
		//should hit (within 1 space)
		assertEquals(InteractionResult.HIT,ir);
		//assuming player is also on location 10
		ir = guard.interact(gameBoard, 10);
		//should hit (within 1 space)
		assertEquals(InteractionResult.HIT,ir);
	}
	
	@Test
	public void testPrizePoint() {
		//The prize gives the player a point on the same space
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Prize prize = new Prize(10);
		gameBoard[10] = prize;
		//assuming player is on location 4
		InteractionResult ir = prize.interact(gameBoard, 4);
		//should do nothing
		assertEquals(InteractionResult.NONE,ir);
		//assuming player is also on location 10
		ir = prize.interact(gameBoard, 10);
		//should give point (same space)
		assertEquals(InteractionResult.GET_POINT,ir);
	}
	
	@Test
	public void testSniperKill() {
		//Sniper shoots a target location and kills the player if at that spot
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Sniper sniper = new Sniper(10,20);
		gameBoard[10] = sniper;
		//assuming player is on location 4
		InteractionResult ir = sniper.interact(gameBoard, 4);
		//should do nothing
		assertEquals(InteractionResult.NONE,ir);
		//assuming player is on location 20
		ir = sniper.interact(gameBoard, 20);
		//should kill (player on target space)
		assertEquals(InteractionResult.KILL,ir);
	}
	
	@Test
	public void testTrapHit() {
		//Trap hits the player at the same place
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Trap trap = new Trap(10);
		gameBoard[10] = trap;
		//assuming player is on location 4
		InteractionResult ir = trap.interact(gameBoard, 4);
		//should do nothing
		assertEquals(InteractionResult.NONE,ir);
		//assuming player is also on location 10
		ir = trap.interact(gameBoard, 10);
		//should hit (within 2 spaces)
		assertEquals(InteractionResult.HIT,ir);
	}

}
