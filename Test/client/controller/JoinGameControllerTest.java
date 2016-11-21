package client.controller;

import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;

public class JoinGameControllerTest extends TestCase {

	// Mock server object that extends (and overrides) ServerAccess for its purposes
	MockServerAccess mockServer;
	
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
		if (!Message.configure("wordsweeper.xsd")){
			fail("unable to configure protocol");
		}
				
		model = new GameRoom("somePlace");
//		model.setCurrentPlayerName("nextOne");
//		
//		model.setPassword(password);
		
		client = new Application (model);
		client.setVisible(true);
		
		mockServer = new MockServerAccess("localhost");
		client.setServerAccess(mockServer);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testProcess() {
		
		
		//new GameRoom("somePlace").setGameId("somePlace");
		//new GameRoom("somePlace").boardResponseHandler("george", "4,3", names, positions, board, scores);
		model.setCurrentPlayerName("nextOne");
		model.boardResponseHandler(managingUser, bonus, names, positions, board, scores);
		//model.setGameId("somePlace");
		
		model.setPassword(password);
		
		new JoinGameRequestController(client, model).process();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("joinGameRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println(r.toString());
		//assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		//assertEquals("nextOne", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		//assertEquals("12345", r.contents.getFirstChild().getAttributes().getNamedItem("password").getNodeValue());
	}

}
