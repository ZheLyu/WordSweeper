package client.controller;

import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;

/**
 *This test case is needed when the job of a controller is to send join game request to the server.
 * <P>
 * To make this work we need to create a "mock" Server whose only purpose is to wait for requests to come
 * from the client being pressed into server here in this test case.
 * 
 * @author QI WANG
 *
 */
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

		
		client = new Application (model);
		client.setVisible(true);
		
		mockServer = new MockServerAccess("localhost");
		
		client.setServerAccess(mockServer);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Sends join game request and validates that the server gets the right message.
	 */
	public void testProcess() {
		
		
		
		model.setCurrentPlayerName("nextOne");
		model.boardResponseHandler(managingUser, bonus, names, positions, board, scores);
		
		model.setPassword(password);
		
		new JoinGameRequestController(client, model).process();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("joinGameRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println(r.toString());
		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("nextOne", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("123456", r.contents.getFirstChild().getAttributes().getNamedItem("password").getNodeValue());
	}

}
