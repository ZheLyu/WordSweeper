package client.model;

import java.util.*;

import client.model.Cell;
import client.model.Position;
import client.model.Word;

public class TestWord {

	private static final String[] ALPHABET = {"A", "B", "C", "D", "E", "F", "G", "H", "I", 
		                                      "J", "K", "L", "M", "N", "O", "P", "Qu", "R", 
		                                      "S", "T", "U", "V", "W", "X", "Y", "Z"};
 
	public static void main(String[] args) {
		
		// Changes the parameter in the createCellList, produce the length of word you define
		List<Cell> cellList = createCellList(66); 
		
		String word = testConstructWord(cellList);
		System.out.println(word);
		
		
	}
	
	// Constructs word using letters in cells.
	public static String testConstructWord(List<Cell> cellList) {
		
		Word word = new Word(cellList);
		return word.getWord();
	}
	
	
	/* produceCell, getPosition, createCellList are COPIED from TestCell file */
	
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
	
	/* produceCell, getPosition, createCellList are COPIED from TestCell file */
}
