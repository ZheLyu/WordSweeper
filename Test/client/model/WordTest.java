package client.model;

import junit.framework.TestCase;
/**
 * This test is needed when calculating the score using letter frequency.
 * <P>
 * To make this we need to test the letters are assigned to the right coefficient.
 * @author QI WANG
 *
 */
public class WordTest extends TestCase {
/**
 * Validates the right weight for letters.
 */
public void testBoardWeight() {
		
		assertEquals((Integer) 1, Word.WEIGHT.get("E"));
		assertEquals((Integer) 1, Word.WEIGHT.get("T"));
		assertEquals((Integer) 2, Word.WEIGHT.get("A"));
		assertEquals((Integer) 2, Word.WEIGHT.get("O"));
		assertEquals((Integer) 2, Word.WEIGHT.get("I"));
		assertEquals((Integer) 2, Word.WEIGHT.get("N"));
		assertEquals((Integer) 2, Word.WEIGHT.get("S"));
		assertEquals((Integer) 2, Word.WEIGHT.get("H"));
		assertEquals((Integer) 2, Word.WEIGHT.get("R"));
		assertEquals((Integer) 3, Word.WEIGHT.get("D"));
		assertEquals((Integer) 3, Word.WEIGHT.get("L"));
		assertEquals((Integer) 3, Word.WEIGHT.get("C"));
		assertEquals((Integer) 3, Word.WEIGHT.get("U"));
		assertEquals((Integer) 3, Word.WEIGHT.get("M"));
		assertEquals((Integer) 3, Word.WEIGHT.get("W"));
		assertEquals((Integer) 4, Word.WEIGHT.get("F"));
		assertEquals((Integer) 4, Word.WEIGHT.get("G"));
		assertEquals((Integer) 4, Word.WEIGHT.get("Y"));
		assertEquals((Integer) 4, Word.WEIGHT.get("P"));
		assertEquals((Integer) 4, Word.WEIGHT.get("B"));
		assertEquals((Integer) 5, Word.WEIGHT.get("V"));
		assertEquals((Integer) 5, Word.WEIGHT.get("K"));
		assertEquals((Integer) 7, Word.WEIGHT.get("J"));
		assertEquals((Integer) 7, Word.WEIGHT.get("X"));
		assertEquals((Integer) 11, Word.WEIGHT.get("Qu"));
		assertEquals((Integer) 8, Word.WEIGHT.get("Z"));
		
	}
}
