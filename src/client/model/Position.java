
package client.model;
 
/**
 * This is a model class. It records the column and row number, and 
	implements hashCode and equal method used for realizing hashMap
 * @author ZELING LEI
 *
 */
public class Position {
	
	private int row;
	private int column;
	
	/**
	 * Constructs Position using column and row
	 * @param row
	 * @param column
	 */
    public Position(int row, int column) {
    	
    	
    	this.row = row;
    	this.column = column;
    }
    /**
     *  Used to implement board in Board.java
     * 
     */
  
    public int hashCode() {
    	
    	return ((Integer)row).hashCode() * 11 + ((Integer)column).hashCode(); 
    }
    /**
     *  Used to implement board in Board.java
     * 
     */
   
    public boolean equals(Object o) {
    	
    	if (o instanceof Position) {
    		
    		Position other = (Position) o;
    		return column == other.column && row == other.row;
    		
    	} else {
    		
    		return false;
    	}
    }  
    
    /**
     *  Used for test only
     */
 
    public String toString() {
    	
    	return row + "," + column;
    	
    }
    /**
     * Gets the column of the position
     * @return
     */
	public int getColumn() {
		return column;
	}
	/**
	 * Sets the column to the given value
	 * @param column column
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	
	/**
	 * Gets the current row of the position
	 * @return row 
	 */
	public int getRow() {
		return row;
	}
	/**
	 * set the row of the position to given value
	 * @param row
	 * 		  row 
	 */
	public void setRow(int row) {
		this.row = row;
	}
    /**
     * Changes the global position to local position on the client side
     * @param globalPosition 
     * 		  the global position of the player on hte server side
     * @return new position
     */
	public Position globalToLocal(Position globalPosition) {
		
	
		return new Position(row - globalPosition.getRow(), 
							column - globalPosition.getColumn());
		
	}
	/**
	 * Changes the local position to global position on the server side
	 * @param globalPosition 
	 * 		  the global position of the player on the server side
	 * @return new position
	 */
	public Position localToGlobal(Position globalPosition) {
		
		return new Position(row + globalPosition.getRow(),
							column + globalPosition.getColumn());
		
	}
    /**
     * Switches the row and column of one position 
     * @return
     */
	public Position switchColRow() {
		
		return new Position(this.column, this.row);
		
	}
	
}
