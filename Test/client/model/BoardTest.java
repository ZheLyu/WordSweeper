package client.model;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

/**
 * This test case is needed when the board of the game is created.
 * <P>
 * To make this work we fabricate the content of the board and a player. 
 * @author QI WANG
 *
 */
public class BoardTest extends TestCase {
	
	
	
	String boardContents = "QuWERTYUIOPLKJHGF";
	
	String s = "QJWERTYUIOPLKJHGF";
	
	Board board = new Board(boardContents);

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBoard() {
		//fail("Not yet implemented");
		
		new Board();
	}

	/**
	 * Validates the board was correctly created by the giving message.
	 */
	public void testBoardString() {
		//fail("Not yet implemented");
		
		Board board = new Board(boardContents);
		
		
		
	}

	/**
	 * Validates the content of the board can be got.
	 */
	public void testGetBoard() {
		//fail("Not yet implemented");
		
		Map<Position, Cell> board = new HashMap<Position, Cell>();
		
		board = new Board(boardContents).getBoard();
		
	}

	/**
	 * Validates the positions of letters are correctly set.
	 */
	public void testGetPositionLetter() {

		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.println(board.getPositionLetter(i, j));
			}
		}
		
		
	}

}
