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
		
		for (int j = 0; j < SIZE; j++) {
			for (int k = 0; k < SIZE; k++) {
				
				Position position = new Position(j, k);
				Cell cell = null;
							
				int alphbetIndex = r.nextInt(26);
				cell = new Cell(position, ALPHABET[alphbetIndex]);
				
				board.put(position, cell);
			}
		}
	}
	
	public Board(String boardContents) {
		
		board = new HashMap<>();
		
		int count = 0; // count should be 16 after the for loop finishes executing.
		
		for (int i = 0; i < boardContents.length(); i++) {
			
			while(boardContents.charAt(i) < 'A' || boardContents.charAt(i) > 'Z') i++;
			
			String contents = boardContents.charAt(i) + "";
			
			if (Character.toLowerCase(boardContents.charAt(i)) == 'q') { 
				i++;
				if (i == boardContents.length() || Character.toLowerCase(boardContents.charAt(i)) != 'u') { // make sure that letter u follows letter q
					throw new IllegalArgumentException("u should follow q");
				}
				contents += boardContents.charAt(i);  // contents = "qu", charAt(i) = 'u'
			}
		
			int col = count % 4;
			int row = count / 4;
			Position position = new Position(row, col);
			Cell cell = new Cell(position, contents);
			board.put(position, cell);
			count++;
		}
		
	}
	
	// Return a map including key: positions and value: cells.
	public Map<Position, Cell> getBoard() {
		
		return board; 
	}
	
	// Returns a letter 
	public String getPositionLetter(int row, int column) {
		
		Position position = new Position(row, column);
		
		return board.get(position).getLetter();
	}
	
	public String toString() {
		
		//String boardContent = "";
		for (Position p: board.keySet()) {
			
			System.out.println(p + " " + board.get(p));
		}
		
		return "true";
		
	}
}
