package client.controller;


import java.util.*;
import client.MockServerAccess;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;
import xml.Message;

public class ExitGameRequestControllerTest extends TestCase {
	MockServerAccess mockServer;
	
	// client to connect
	Application client;
	
	// model being maintained by client.
	GameRoom model;

	protected void setUp() throws Exception {
		super.setUp();
		
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		model = new GameRoom("somePlace");
		client = new Application (model);
		client.setVisible(true);
		
		mockServer = new MockServerAccess("localhost");
		
		client.setServerAccess(mockServer);
	}

	protected void tearDown() throws Exception {
		//super.tearDown();
	}

	public void testProcess() {
		//fail("Not yet implemented");
		String[] names1 = {"george"};
		String[] positions1 = {"1,1"};
		String[] board1 = {"QuWERTYUIOPLKJHGF"};
		long[] scores1 = {0};
		String bonus = "4,3";
		
		String[] names2 = {"george","somePlayer", "nextOne"};
		String[] positions2 = {"1,1","1,1","3,3"};
		String[] board2 = {"QuWERTYUIOPLKJHGF", "MLPOKNJIUHBVGYTF","MLPOKNJIUHBVGYTF"};
		long[] scores2 = {0,30,0};
		
		//model.setCurrentPlayerName("geroge");
		model.setCurrentPlayerName("nextOne");
		model.boardResponseHandler("george", bonus, names2, positions2, board2, scores2);
		
		new ExitGameRequestController(client, model).process();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("exitGameRequest", r.contents.getFirstChild()
				.getLocalName());
		
		
		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		
		assertEquals("nextOne", r.contents.getFirstChild().getAttributes()
				.getNamedItem("name").getNodeValue());
		System.out.println(r.toString());
	}

}
