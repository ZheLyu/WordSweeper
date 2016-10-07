package client.model;

// This class stores the position info in a board

public class Position {
	
	
	private int column;
	private int row;
	
	// Constructs Position using column and row
    public Position(int column, int row){
    	
    	this.column = column;
    	this.row = row;
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
    
    // used to test only
    public String toString() {
    	
    	return "[" + column + ",  " + row + "]";
    	
    }
	
}
