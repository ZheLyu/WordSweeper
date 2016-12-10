package client.view;

import client.model.GameRoom;
import junit.framework.TestCase;

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

	public void testEnterRoomDlg() {
		//fail("Not yet implemented");
		new EnterRoomDlg(app, model, 0);
	}

	
}
