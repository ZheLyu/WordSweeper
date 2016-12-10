package client.view;

import client.model.Board;
import client.model.DrawBoardModel;
import client.model.GameRoom;
import junit.framework.TestCase;

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

	public void testBoardDisplay() {
		model = new GameRoom("somePlace");
		//fail("Not yet implemented");
		//String boardContents = "QuWERTYUIOPLKJHGF";
		//Board board = new Board(boardContents);
 
		//new DrawBoardModel(board);
		//model.setDrawBoardModel(new DrawBoardModel(board));
		new BoardDisplay(client, model);
	}

	public void testActionPerformed() {
		//fail("Not yet implemented");
	}

}
