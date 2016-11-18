/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

Board.java : implementation file
This is a model class, which stores all the information related to 
a board using HashMap. Position and cell are included.

History:
7 Oct, 2016	--- Zeling Lei @1
- Created.

*****************************************************************/
package client.model;

import java.util.*;

// This class include info of a board.
public class Board {

	private static final int SIZE = 4;
	
	private static final String[] ALPHABET = {"A", "B", "C", "D", "E", "F", "G", "H", "I", 
											  "J", "K", "L", "M", "N", "O", "P", "Qu", "R", 
											  "S", "T", "U", "V", "W", "X", "Y", "Z"};

	
	private Map<Position, Cell> board;  // stores info in a board
	
	// Creates 4 by 4 board randomly and stores them in a map.
	public Board() {
		
		Random r = new Random();
		board = new HashMap<Position, Cell>();
		
		for (int j = 1; j <= SIZE; j++) {
			for (int k = 1; k <= SIZE; k++) {
				
				Position position = new Position(j, k);
				Cell cell = null;
							
				int alphbetIndex = r.nextInt(26);
				cell = new Cell(position, ALPHABET[alphbetIndex]);
				
				board.put(position, cell);
			}
		}
	}
	
	public Board(String sixteenLetter) {
		
		if (sixteenLetter.length() != 16) {
			throw new IllegalArgumentException();
		}
		board = new HashMap<>();
		for (int i = 0; i < sixteenLetter.length(); i++) {
			int col = i % 4;
			int row = i / 4;
			Position position = new Position(row, col);
			Cell cell = new Cell(position, sixteenLetter.charAt(i) + "");
			board.put(position, cell);
		}
	}
	
	// Return a map including key: positions and value: cells.
	public Map<Position, Cell> getBoard() {
		
		return board; 
	}
	
	// Returns a letter 
	public String getPositionLetter(int column, int row) {
		
		Position position = new Position(column + 1, row + 1);
		
		return board.get(position).getLetter();
	}
	
}
