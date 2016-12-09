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

	
	// Constructs a cell using position and letter
	public Cell(Position position, String letter) {
		
	//	this(position, letter, false);
		this.position = position;
		this.letter = letter;
	}
	
	
	// Returns position of the cell 
	public Position getPosition() {
		
		return position;
	}
	
	// Returns the letter in the cell
	public String getLetter() {
		
		return letter.toLowerCase();
	}
	
	// Used for test only
	public String toString() {
		
		return "position: " + position + ", letter: " + letter;
	}
	
}
