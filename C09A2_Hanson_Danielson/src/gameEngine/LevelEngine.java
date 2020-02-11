package gameEngine;

import java.util.ArrayList;
import java.util.Random;

import levelPieces.Chair;
import levelPieces.Dragon;
import levelPieces.Food;
import levelPieces.GamePiece;
import levelPieces.Guard;
import levelPieces.Prize;
import levelPieces.Sniper;
import levelPieces.Trap;

public class LevelEngine {

	public void createLevel(int levelNum) {
		ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
		ArrayList<Moveable> moves = new ArrayList<Moveable>();
		GamePiece temp;
		//add dragon to game 2
		if (levelNum == 2) {
			temp = new Dragon(12);
			pieces.add(temp);
			moves.add((Moveable) temp);
		}
		//add food to both games, in different places
		if (levelNum == 1) {
			temp = new Food(15);
			pieces.add(temp);
		}
		if (levelNum == 2) {
			temp = new Food(5);
			pieces.add(temp);
		}
		//add guard to game 1
		if (levelNum == 1) {
			temp = new Guard(5);
			pieces.add(temp);
			moves.add((Moveable) temp);
		}
		//add prize to both games
		temp = new Prize(9);
		pieces.add(temp);
		moves.add((Moveable) temp);
		//add sniper to both games
		temp = new Sniper(19,14);
		pieces.add(temp);
		//add a trap to both games, in different places
		if (levelNum == 1) {
			temp = new Trap(2);
			pieces.add(temp);
		}
		if (levelNum == 2) {
			temp = new Trap(15);
			pieces.add(temp);
		}
		this.interactingPieces = pieces;
		this.moveablePieces = moves;
	}

	public Drawable[] getBoard() {
		Drawable[] board = new Drawable[GameEngine.BOARD_SIZE];
		for (int i = 0; i < this.interactingPieces.size(); i++) {
			int location = this.interactingPieces.get(i).getLocation();
			board[location] = this.interactingPieces.get(i);
		}
		board[1] = new Chair(); //because I want a chair
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		return this.moveablePieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		return this.interactingPieces;
	}

	public int getPlayerStartLoc() {
		Random rand = new Random();
		return rand.nextInt(GameEngine.BOARD_SIZE);
		//random start location
	}

	private ArrayList<GamePiece> interactingPieces;
	private ArrayList<Moveable> moveablePieces;

}
