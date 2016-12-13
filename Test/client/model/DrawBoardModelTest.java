package client.model;

import java.awt.Point;

import junit.framework.TestCase;
/**
 * This test case is needed when the user uses mouse to select word in the game board.
 * <P>
 * To make this we should pretend that a user has selected some letters.
 * @author QI WANG
 *
 */
public class DrawBoardModelTest extends TestCase {
	
	DrawBoardModel drawBoardModel = new DrawBoardModel();

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	/**
	 * Validates that the letters that users were selected are stored in instance of the model object.
	 */
	public void testAddDragCellList() {
		//fail("Not yet implemented");
		
		Point p = new Point();
		p.x = 150;
		p.y = 250;
		
		Board board = new Board();
		
		drawBoardModel.setBoard(board);
		drawBoardModel.addDragCellList(p);
		drawBoardModel.addDragCellList(p);
	}

	

}
