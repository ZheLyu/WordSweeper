package client.model;

import java.awt.Point;

import junit.framework.TestCase;

public class DrawBoardModelTest extends TestCase {
	
	DrawBoardModel drawBoardModel = new DrawBoardModel();

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	

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
