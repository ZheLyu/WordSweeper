/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

Position.java : implementation file
This is a model class. It records the column and row number, and 
implements hashCode and equal method used for realizing hashMap

History:
7 Oct, 2016	--- Zeling Lei @1
- Created.

*****************************************************************/

package client.model;

// This class stores the position info in a board

public class Position {
	
	private int row;
	private int column;
	
	
	// Constructs Position using column and row
    public Position(int row, int column) {
    	
    	
    	this.row = row;
    	this.column = column;
    }
    
    // Used to implement Map<Position, Cell> in Board.java
    public int hashCode() {
    	
    	return ((Integer)row).hashCode() * 11 + ((Integer)column).hashCode(); 
    }
    
    // Used to implement Map<Position, Cell> in Board.java
    public boolean equals(Object o) {
    	
    	if (o instanceof Position) {
    		
    		Position other = (Position) o;
    		return column == other.column && row == other.row;
    		
    	} else {
    		
    		return false;
    	}
    }  
    
    // used for test only
    public String toString() {
    	
    	return row + "," + column;
    	
    }

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
    
	public Position globalToLocal(Position globalPosition) {
		
	//	Position globalPosition = player.getGlobalPosition();
		return new Position(row - globalPosition.getRow(), 
							column - globalPosition.getColumn());
		
	}
	
	public Position localToGlobal(Position globalPosition) {
		
		return new Position(row + globalPosition.getRow(),
							column + globalPosition.getColumn());
		
	}
    
	public Position switchColRow() {
		
		return new Position(this.column, this.row);
		
	}
	
}
