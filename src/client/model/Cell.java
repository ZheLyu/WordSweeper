package client.model;

// This class stores info of one cell in a board

public class Cell {

	private Position position;
	private String letter;
	private int bonus;
	
	// Constructs a cell using position and letter
	public Cell(Position position, String letter) {
		
		this(position, letter, 0);
	}
	
	// Constructs a cell using position, leter and bonus
	public Cell(Position position, String letter, int bonus) {
		
		this.position = position;
		this.letter = letter;
		this.bonus = bonus;
	}
	
	// Returns position of the cell 
	public Position getPosition() {
		
		return position;
	}
	
	// Returns the letter in the cell
	public String getLetter() {
		
		return letter;
	}
	
	// Used to test only
	public String toString() {
		
		return "position: " + position + ", letter: " + letter + ", bonus: " + bonus;
	}
}
