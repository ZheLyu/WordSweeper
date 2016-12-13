package client.controller;

import java.util.ArrayList;

import xml.Message;
import client.model.GameRoom;
import client.model.Player;
import client.view.Application;
import client.MockServerAccess;
import junit.framework.TestCase;
/**
 * This test case is needed when the job of a controller is to send a create game request to the server. 
 * <P>
 * To make this work we need to create a "mock" Server whose only purpose is to wait for requests to come
 * from the client being pressed into server here in this test case.
 * 
 * @author QI WANG
 *
 */
public class CreateGameControllerTest extends TestCase {
	
	MockServerAccess mockServer;
	
	// client to connect
	Application client;
	
	// model being maintained by client.
	GameRoom model;
	

	protected void setUp() throws Exception {
		
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		model = new GameRoom("somePlace");
		client = new Application (model);
		client.setVisible(true);
		
		// Create mockServer to simulate server, and install 'obvious' handler
		// that simply dumps to the screen the responses.
		mockServer = new MockServerAccess("localhost");
		
		// as far as the client is concerned, it gets a real object with which
		// to communicate.
		client.setServerAccess(mockServer);
		
	}

	protected void tearDown() throws Exception {
	//	super.tearDown();
	}

	/**
	 * Sends create game request and validates that the server gets the right message.
	 */
	public void testProcess() {

		String[] names1 = {"george"};
		String[] positions1 = {"1,1"};
		String[] board1 = {"QuWERTYUIOPLKJHGF"};
		long[] scores1 = {0};
		String bonus = "4,3";
		
		model.setCurrentPlayerName("george");
		model.setPassword("12345");
		model.boardResponseHandler("george", bonus, names1, positions1, board1, scores1);
		
		new CreateGameRequestController(client, model).process();

		// validate from mockServer

		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);

		// a lock request is sent out.
		assertEquals("createGameRequest", r.contents.getFirstChild()
				.getLocalName());

		assertEquals("george", r.contents.getFirstChild().getAttributes()
				.getNamedItem("name").getNodeValue());
		System.out.println(r.toString());
		
	}

}
