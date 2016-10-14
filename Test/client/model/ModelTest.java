package client.model;

import java.awt.Point;
import java.util.ArrayList;

import junit.framework.TestCase;

public class ModelTest extends TestCase {
	
	Model m=new Model();

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAddDragCellList() {
		//fail("Not yet implemented");
		Point p=new Point();
		Point p1=new Point();
		p1.setLocation(500, 500);
		p.setLocation(200, 200);		
		m.addDragCellList(p1);
		assertFalse("add failed",m.getSelCellList()==null);
		m.addDragCellList(p1);
		
		assertEquals("if branch failed",1,m.getSelCellListSize());
	}

}
