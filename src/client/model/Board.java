package client.model;

import java.util.*;

// This class include info of a board.
public class Board {

	private static final int SIZE = 4;
	
	private static final char[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
                                            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 
                                            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	private Map<Position, Cell> board;  // stores info in a board
	
	// Creates 4 by 4 board randomly and stores them in a map.
	public Board() {
		
		Random r = new Random();
		
		board = new HashMap<Position, Cell>();
		
		for (int j = 1; j <= SIZE; j++) {
			for (int k = 1; k <= SIZE; k++) {
				
				int alphbetIndex = r.nextInt(26);
				Position position = new Position(j, k);
				Cell cell = new Cell(position, ALPHABET[alphbetIndex]);
				board.put(position, cell);
			}
		}
	}
	
	// Return a map including key: positions and value: cells.
	public Map<Position, Cell> getBoard() {
		
		return board; 
	}
	
	public char getPositionLetter(int column, int row) {
		
		Position position = new Position(column + 1, row + 1);
		
		return board.get(position).getLetter();
	}
	
	// Resets the board
	public void reset() {
		
		// TODO: 
	}
}
