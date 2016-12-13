package client.view;

import client.model.GameRoom;
import junit.framework.TestCase;
/**
 * This test case is needed when the player needs to enter the game name to enter a game.
 * <P>
 * To make this we need to fabricate a player.
 * @author QI WANG
 *
 */
public class EnterRoomDlgTest extends TestCase {
	
	// client to connect
		Application client;
		
		Application app;
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
		client = new Application (model);
		client.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Validates the enter user interface is shown.
	 */
	public void testEnterRoomDlg() {
		//fail("Not yet implemented");
		new EnterRoomDlg(app, model, 0);
	}

	
}
