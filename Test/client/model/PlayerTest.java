package client.model;

import junit.framework.TestCase;
/**
 * This test case is needed when a player instance are created.
 * <P>
 * To make this we need to fabricate a player and its information and send the message to model.
 * @author QI WANG
 *
 */
public class PlayerTest extends TestCase {
	
	Player player =	new Player("george", "QuWERTASDFGZXCVBN", "1,1", 10, true);

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Validates the instance of the player is created.
	 */
	public void testPlayer() {
		//fail("Not yet implemented");
		
	Player player =	new Player("george", "QuWERTASDFGZXCVBN", "1,1", 10, true);
	
	
	
	}
	/**
	 * Validates the  information of the player are set correctly.
	 */
	public void testgetGlobalPosition() {
		
		String position = player.getGlobalPosition().toString();
		
		assertEquals( "1,1", position);
		
		String name = player.getName();
		
		assertEquals("george", name);
		
		
	}
	
	/**
	 * Validates the  information of the player are set correctly.
	 */
	
	public void testsetGlobalPosition() {
		
		String position = "7,7";
		player.setGlobalPosition(position);
		String result = player.getGlobalPosition().toString();
		
		assertEquals( "7,7", result);
		
		
	}
	

	
	

}
