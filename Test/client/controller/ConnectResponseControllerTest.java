package client.controller;

import server.Server; 
import client.MockServerAccess;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;
//import server.model.ServerModel;
import xml.Message;

public class ConnectResponseControllerTest extends TestCase {
	
		// Mock server object that extends (and overrides) ServerAccess for its purposes
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
		
		
		String xmlString = Message.responseHeader("someMessageID") + "<connectResponse id='hg12jhd'></connectResponse></response>";
		String xmlString1 = Message.responseHeader("someMessageID") + "<lockGameResponse id='hg12jhd'></lockGameResponse></response>";
		Message response = new Message(xmlString);
		
		boolean result = new ConnectResponseController(client, model).process(response);
		
		assertTrue("Should be true", result);
	
		System.out.println(response.toString());
		
		
		
	}

}
