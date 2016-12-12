
package client.model;

/**
 * This is a model class and stores info of a cell. private state 
position, letter, and bonus are included.
 * @author ZELING LEI
 *
 */
public class Cell {

	/**
	 * The position corresponding to the board
	 */
	private Position position;
	/**
	 *  The letter in the cell 
	 */
	private String letter;

	/**
	 * Constructs a cell using position and letter
	 * @param position 
	 * 		  the position in a board
	 * @param letter   
	 * 		  the letter in the cell
	 */

	public Cell(Position position, String letter) {
		
		this.position = position;
		this.letter = letter;
	}
	
	/**
	 * Returns position of the cell 
	 * @return the position in a board
	 */

	public Position getPosition() {
		
		return position;
	}
	
	/**
	 * Returns the letter in the cell
	 * @return
	 */
	public String getLetter() {
		
		return letter;
	}
	
	/**
	 * Used for test only
	 */

	public String toString() {
		
		return "position: " + position + ", letter: " + letter;
	}
	
}
