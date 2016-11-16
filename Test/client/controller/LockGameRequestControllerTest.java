package client.controller;

import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;

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
		model = new GameRoom("123", "password");
		client = new Application (model);
		client.setVisible(true);
		
		mockServer = new MockServerAccess("localhost");
		client.setServerAccess(mockServer);
	}

	public void testProcess() {
		
		new LockGameRequestController(client, model).process();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("lockGameRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println(r.toString());
		assertEquals("sample", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
	}

}
