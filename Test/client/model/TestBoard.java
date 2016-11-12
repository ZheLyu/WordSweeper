package client.model;

import client.model.Board;
import client.model.Cell;
import client.model.Position;
import java.util.*;


public class TestBoard {

	public static void main(String[] args) {
		
		Board board = createBoard2("AFERKSOEROIERPOR");
		System.out.println("letter = " + board.getPositionLetter(0, 0));
	}
	
	// Produces the info in a board.
	public static Board createBoard() {
		
		Board board = new Board();
		Map<Position, Cell> boardMap = board.getBoard();
		for (Position pos: boardMap.keySet()) {
			
			Cell cell = boardMap.get(pos);
			System.out.println(cell);
		}
		return board;
	}
	
	public static Board createBoard2(String sixteenLetter) {
		
		Board board = new Board(sixteenLetter);
		Map<Position, Cell> boardMap = board.getBoard();
		for (Position pos: boardMap.keySet()) {
			
			Cell cell = boardMap.get(pos);
			System.out.println(cell);
		}
		return board;
	}
	
	
}
