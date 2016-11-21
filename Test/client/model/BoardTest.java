package client.model;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

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

	public void testBoardString() {
		//fail("Not yet implemented");
		
		Board board = new Board(boardContents);
		
		//Board board1 = new Board(s);
		
	}

	public void testGetBoard() {
		//fail("Not yet implemented");
		
		Map<Position, Cell> board = new HashMap<Position, Cell>();
		
		board = new Board(boardContents).getBoard();
		
	}

	public void testGetPositionLetter() {
		//fail("Not yet implemented");
		
//		String l1 = board.getPositionLetter(0,0);
//		String l2 = board.getPositionLetter(0,1);
//		String l3 = board.getPositionLetter(0,2);
//		
//		
//		System.out.println(l1);
//		System.out.println(l2);
//		System.out.println(l3);
		
		for(int i = -1; i <= 2; i++) {
			for(int j = -1; j <= 2; j++) {
				System.out.println(board.getPositionLetter(i, j));
			}
		}
		
		
	}

}
