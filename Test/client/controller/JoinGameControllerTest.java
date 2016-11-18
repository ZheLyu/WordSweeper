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
	
	protected void setUp() throws Exception {
		super.setUp();
		if (!Message.configure("wordsweeper.xsd")){
			fail("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		model = new GameRoom("123");
		client = new Application (model);
		client.setVisible(true);
		
		mockServer = new MockServerAccess("localhost");
		client.setServerAccess(mockServer);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testProcess() {
		
		new JoinGameRequestController(client, model).process();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("joinGameRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println(r.toString());
		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("nextOne", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("12345", r.contents.getFirstChild().getAttributes().getNamedItem("password").getNodeValue());
	}

}
