package client.model;

import junit.framework.TestCase;

public class PositionTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testHashCode() {
		//fail("Not yet implemented");
		Position test2=new Position(2,0);
		Position test3=new Position(3,0);
		assertEquals("should be 22",22,test2.hashCode());
		assertEquals("should be 33",33,test3.hashCode());
	}

	public void testPosition() {
		Position test1=new Position(0,0);
		
		assertEquals("should be 0",0,test1.getRow());
		assertEquals("should be 0",0,test1.getColumn());
		
		//fail("Not yet implemented");
	}

}
