/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

Word.java : implementation file
This is a model class. It records the cell user selected and pass
those information to Player class. Not useful for task 2 
right now.  

History:
7 Oct, 2016	--- Zeling Lei @1
- Created.

*****************************************************************/

package client.model;

import java.util.*;

// This class creates word based on the user's choice

public class Word {
	
	private String word; 
	private long score;
//	private List<Cell> cellList;
	
	public static final Map<String, Integer> WEIGHT = createMap();

    private static Map<String, Integer> createMap() {
        Map<String, Integer> weight = new HashMap<>();
        weight.put("A", 2);
        weight.put("B", 4);
        weight.put("C", 3);
        weight.put("D", 3);
        weight.put("E", 1);
        weight.put("F", 4);
        weight.put("G", 4);
        weight.put("H", 2);
        weight.put("I", 2);
        weight.put("J", 7);
        weight.put("K", 5);
        weight.put("L", 3);
        weight.put("M", 3);
        weight.put("N", 2);
        weight.put("O", 2);
        weight.put("P", 4);
        weight.put("Qu", 11);
        weight.put("R", 2);
        weight.put("S", 2);
        weight.put("T", 1);
        weight.put("U", 3);
        weight.put("V", 5);
        weight.put("W", 3);
        weight.put("X", 7);
        weight.put("Y", 4);
        weight.put("Z", 8);
        return Collections.unmodifiableMap(weight);
    }
    
	// Creates a word based on the letter in the given string list
//	public Word(List<Cell> list) {
//		
//		word = "";
//		score = 0;
//	//	this.cellList = new ArrayList<Cell>();
//		for (int i = 0; i < list.size(); i++) {
//			
//			Cell cell = list.get(i);
//			word += cell.getLetter();
//			score += WEIGHT.get(cell.getLetter());
//		}
//		
//		if (word.length() >= 3) {
//			score *= (10 * Math.pow(2, word.length()));
//		}
//		
//		System.out.println(word);
//		System.out.println(score);
//	}
//	
	// Returns the word 
//	public String getWord() {
//		
//		return word;
//	}
//	
//	
//	// Checks if the given word is vaild
//	public boolean checkVaild() {
//		
//		return true;
//	}
}
