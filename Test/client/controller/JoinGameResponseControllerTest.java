package client.controller;

import client.MockServerAccess;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;
import xml.Message;

/**
 * This test case is needed when the job of a controller is to receive the join game response from the server.
 * <P>
 * To make this work we need to create a "mock" Server and  fabricate a join game response message from server so that 
 * the client can receive and parse the message.
 * 
 * @author QI WANG
 *
 */
public class JoinGameResponseControllerTest extends TestCase {

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
	 * Validates the controller can receive and parses the fabricated message correctly.  
	 */
	public void testProcess() {
		//fail("Not yet implemented");
		
		String xmlString = Message.responseHeader("someMessageID") + "<joinGameResponse gameId='somePlace'></joinGameResponse></response>";
		
		Message response = new Message(xmlString);
		
		boolean result = new JoinGameResponseController(client, model).process(response);
		
		assertTrue("Should be true", result);
		
		System.out.println(response.toString());
		
	}

}
