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
	
	// Return a map including key: positions and value: cells.
	public Map<Position, Cell> getBoard() {
		
		return board; 
	}
	
	// Return a letter 
	public String getPositionLetter(int column, int row) {
		
		Position position = new Position(column + 1, row + 1);
		
		return board.get(position).getLetter();
	}
	
	// Resets the board
	public void reset() {
		
		// TODO: 
	}
}
