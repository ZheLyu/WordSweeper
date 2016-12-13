package client.controller;

import java.awt.Point;
import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.Board;
import client.model.DrawBoardModel;
import client.model.GameRoom;
import client.model.Player;
import client.model.Position;
import client.view.Application;
import junit.framework.TestCase;

/**
 * This test case is needed when the job of a controller is to send find word request to the server.
 * <P>
 * To make this work we need to create a "mock" Server whose only purpose is to wait for requests to come
 * from the client being pressed into server here in this test case.
 * @author QI WANG
 *
 */
public class FindWordControllerRequestTest extends TestCase {

	
	// Mock server object that extends (and overrides) ServerAccess for its purposes
	MockServerAccess mockServer;
	
	// client to connect
	Application client;
	
	// model being maintained by client.
	GameRoom model;
	
	//Player player = new Player("george", "QuWERTYUIOPLKJHGF", "1,1",0, true);
	
	protected void setUp() throws Exception {
		super.setUp();
		if (!Message.configure("wordsweeper.xsd")){
			fail("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		//model = new GameRoom("123");
		 model = new GameRoom("somePlace");
		
		client = new Application (model);
		client.setVisible(true);
		
		mockServer = new MockServerAccess("localhost");
		
		client.setServerAccess(mockServer);
	}
	
	protected void tearDown() throws Exception {
		//super.tearDown();
		
	}
	
	/**
	 * Sends exit game request and validates that the server gets the right message.
	 */
	public void testProcess() {
		//fail("Not yet implemented");
		
		String[] names1 = {"george"};
		String[] positions1 = {"1,1"};
		String[] board1 = {"QuWERTYUIOPLKJHGF"};
		long[] scores1 = {0};
		String bonus = "4,3";
		
		model.setCurrentPlayerName("george");
		model.boardResponseHandler("george", bonus, names1, positions1, board1, scores1);
		
		String boardContents = "YWERTQuUIOPLKJHGF";
		DrawBoardModel drawBoardModel = new DrawBoardModel();
		Board board = new Board(boardContents);
		drawBoardModel.setBoard(board);
	
		
		Point p1 = new Point(150,250);
		drawBoardModel.addDragCellList(p1);
		model.setDrawBoardModel(drawBoardModel);
		
		Point p2 = new Point(155,255);

		
		
		drawBoardModel.addDragCellList(p2);
		
		model.setDrawBoardModel(drawBoardModel);
		
		
		new FindWordRequestController(client, model).process();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);

		
		

		}
		

		
		
		
		
		
		
		
	}

//}
