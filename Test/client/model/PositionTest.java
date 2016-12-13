package client.model;

import junit.framework.TestCase;
/**
 * This test case is needed when the position of the letters are stored in the hash table.
 * <P>
 * To make this we need to fabricate the position of the letter and send it to hash function.
 * @author QI WANG
 *
 */
public class PositionTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	/**
	 * Validates the positions are calculated by the hash function.
	 */
	public void testHashCode() {
		//fail("Not yet implemented");
		Position test2=new Position(2,0);
		Position test3=new Position(3,0);
		assertEquals("should be 22",22,test2.hashCode());
		assertEquals("should be 33",33,test3.hashCode());
	}

	/**
	 * Validates the position are correctly stored.
	 */
	public void testPosition() {
		Position test1=new Position(0,0);
		
		assertEquals("should be 0",0,test1.getRow());
		assertEquals("should be 0",0,test1.getColumn());
		
		//fail("Not yet implemented");
	}

}
