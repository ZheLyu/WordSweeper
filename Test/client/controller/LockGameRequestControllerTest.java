package client.controller;

import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;

/**
 * This test case is needed when the job of a controller is to send lock game request to the server.
 * <P>
 * To make this work we need to create a "mock" Server whose only purpose is to wait for requests to come
 * from the client being pressed into server here in this test case.
 * 
 * @author QI WANG
 *
 */
public class LockGameRequestControllerTest extends TestCase {

	MockServerAccess mockServer;
	
	Application client; 
	
	GameRoom model;
	
	protected void setUp() throws Exception {
		
		super.setUp();
		if (!Message.configure("wordsweeper.xsd")){
			fail("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		model = new GameRoom("somePlace");
		client = new Application (model);
		client.setVisible(true);
		
		mockServer = new MockServerAccess("localhost");
		
		client.setServerAccess(mockServer);
	}

	/**
	 * Sends lock game request and validates that the server gets the right message.
	 */
	public void testProcess() {
		
		model.setGameId("somePlace");
		new LockGameRequestController(client, model).process();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("lockGameRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println(r.toString());
		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
	}

}
