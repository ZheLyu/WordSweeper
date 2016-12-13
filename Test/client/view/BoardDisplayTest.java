package client.view;

import client.model.Board;
import client.model.DrawBoardModel;
import client.model.GameRoom;
import junit.framework.TestCase;
/**
 * Thid test case is needed when the user interface are shown.
 * <P>
 * To make this we need to create the player to play the game. 
 * @author QI WANG
 *
 */
public class BoardDisplayTest extends TestCase {
	
	// client to connect
	Application client;
		
	// model being maintained by client.
	GameRoom model;
	

		
		String managingUser = "george";
		String bonus = "4,3";
		String[] names = {"george","somePlayer", "nextOne"};
		String[] positions = {"1,1","1,1","3,3"};
		String[] board = {"QuWERTYUIOPLKJHGF", "QuWERTYUIOPLKJHGF","MLPOKNJIUHBVGYTF"};
		long[] scores = {0,30,0};
		String password = "123456";

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Validates the board are shown.
	 */
	public void testBoardDisplay() {
		model = new GameRoom("somePlace");
		//fail("Not yet implemented");
		
		new BoardDisplay(client, model);
	}

	

}
