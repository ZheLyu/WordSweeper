package client.model;

import client.model.Cell;
import client.model.Position;
import java.util.*;

public class TestCell {
	
	
	public static final String[] ALPHABET = {"a", "b", "c", "d", "e", "f", "g", "h", "i", 
			                               "j", "k", "l", "m", "n", "o", "p", "q", "r", 
			                               "s", "t", "u", "v", "w", "x", "y", "z"};
			                    
	public static void main(String[] args) {
		

		List<Cell> cellList = createCellList(30);
		for (int i = 0; i < cellList.size(); i++) {
			
			Cell cell = cellList.get(i);
			System.out.println(cell.getPosition() + "   " + cell);
			
		}
	}
	
	// Produces one cell randomly using position, letter and bonus.
	public static Cell produceCell() {
		
		Random r = new Random();
		int random = r.nextInt(26);
		return new Cell(new Position(6, 4), ALPHABET[random], 0);
		
	}
	
	// Returns position of the cell.
	public static Position getPosition(Cell cell) {
		
		return cell.getPosition();
	}
	
	// Produces a list of cell whose length is the parameter of the method
	public static List<Cell> createCellList(int numCell) {
		
		List<Cell> cellList = new ArrayList<Cell>(); 
		for (int i = 0; i < numCell; i++) {
			
			Cell cell = produceCell();
			cellList.add(cell);
		
		}
		return cellList;
		
	}
}
