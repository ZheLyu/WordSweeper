package client.model;

import java.util.*;

// This class creates word based on the user's choice

public class Word {
	
	private String word; 
//	private List<Cell> cellList;
	
	// Creates a word based on the letter in the given cell 
	public Word(List<Cell> cellList) {
		
		word = "";
	//	this.cellList = new ArrayList<Cell>();
		for (int i = 0; i < cellList.size(); i++) {
			
			Cell cell = cellList.get(i);
		//	this.cellList.add(cell);
			word += cell.getLetter();
		}
	}
	
	// Returns the word 
	public String getWord() {
		
		return word;
	}
	
	// Checks if the given word is vaild
	public boolean checkVaild() {
		
		return true;
	}
}
