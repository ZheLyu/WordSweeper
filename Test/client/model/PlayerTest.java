package client.model;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	
	Player player =	new Player("george", "QWERTASDFGZXCVBN", "1,1", 10, true);

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPlayer() {
		//fail("Not yet implemented");
		
	Player player =	new Player("george", "QWERTASDFGZXCVBN", "1,1", 10, true);
	
	//String position = player.getGlobalPosition().toString();
	
	//assertEquals( "[1,  1]", position);
	
	}
	
	public void testgetGlobalPosition() {
		
		String position = player.getGlobalPosition().toString();
		
		assertEquals( "[1,  1]", position);
		
		String name = player.getName();
		
		assertEquals("george", name);
		
		
	}
	
	
	public void testsetGlobalPosition() {
		
		String position = "7,7";
		player.setGlobalPosition(position);
		String result = player.getGlobalPosition().toString();
		
		assertEquals( "[7,  7]", result);
		
		
	}
	
	public void testupdateTotalScore() {
		
		long score = 20;
		
		long result = player.updateTotalScore(score);
		
		assertEquals(30, result);
		
		player.setScore(score);
		
		
		
	}
	
	

}
