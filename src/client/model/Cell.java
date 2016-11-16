/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

Cell.java : implementation file
This is a model class and stores info of a cell. private state 
position, letter, and bonus are included.

History:
7 Oct, 2016	--- Zeling Lei @1
- Created.

*****************************************************************/
package client.model;


public class Cell {

	private Position position;
	private String letter;
	private boolean bonus;
	
	// Constructs a cell using position and letter
	public Cell(Position position, String letter) {
		
		this(position, letter, false);
	}
	
	// Constructs a cell using position, leter and bonus
	public Cell(Position position, String letter, boolean bonus) {
		
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
	
	// Used for test only
	public String toString() {
		
		return "position: " + position + ", letter: " + letter + ", bonus: " + bonus;
	}
	
	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}
	
	public boolean isBonus() {
		
		return bonus; 
	}
}
