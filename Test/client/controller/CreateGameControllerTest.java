package client.controller;

import java.util.ArrayList;

import xml.Message;
import client.view.Application;
import client.MockServerAccess;
import client.model.Model;
import junit.framework.TestCase;

public class CreateGameControllerTest extends TestCase {
	
	MockServerAccess mockServer;
	
	// client to connect
	Application client;
	
	// model being maintained by client.
	Model model;
	

	protected void setUp() throws Exception {
		
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
		
		// prepare client and connect to server.
		model = new Model();
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
		super.tearDown();
	}

	public void testProcess() {

		new CreateGameController(client, model).process();

		// validate from mockServer

		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);

		// a lock request is sent out.
		assertEquals("createGameRequest", r.contents.getFirstChild()
				.getLocalName());

		// make sure "grab" attribute is there, and true
		System.out.println(r.toString());
		assertEquals("samplePlayer", r.contents.getFirstChild().getAttributes()
				.getNamedItem("name").getNodeValue());
	}

}
