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

	public void testDrawBoardModel() {
		fail("Not yet implemented");
	}

	public void testGetSelCellList() {
		fail("Not yet implemented");
	}

	public void testClearSelCellList() {
		fail("Not yet implemented");
	}

	public void testGetSelCellListSize() {
		fail("Not yet implemented");
	}

	public void testGetSelCellList2() {
		fail("Not yet implemented");
	}

	public void testAddDragCellList() {
		//fail("Not yet implemented");
		
		Point p = new Point();
		p.x = 400;
		p.y = 100;
		
		drawBoardModel.addDragCellList(p);
		drawBoardModel.addDragCellList(p);
	}

	public void testGetHorizenLine() {
		fail("Not yet implemented");
	}

	public void testGetVerticalLine() {
		fail("Not yet implemented");
	}

	public void testGetCellLt() {
		fail("Not yet implemented");
	}

	public void testGetCellLetter() {
		fail("Not yet implemented");
	}

	public void testGetBoardSize() {
		fail("Not yet implemented");
	}

	public void testGetCellSize() {
		fail("Not yet implemented");
	}

}
