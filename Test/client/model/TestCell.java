package client.model;

import client.model.Cell;
import client.model.Position;

import java.util.*;

public class TestCell {
	
	
	private static final String[] ALPHABET = {"A", "B", "C", "D", "E", "F", "G", "H", "I", 
		                                      "J", "K", "L", "M", "N", "O", "P", "Qu", "R", 
		                                      "S", "T", "U", "V", "W", "X", "Y", "Z"};
			                    
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
