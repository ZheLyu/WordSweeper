package client.controller;

import xml.Message;
import client.MockServerAccess;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;
/**
 * This test case is needed when the job of a controller is to get the board response from the server.
 * <P>
 * To make this work we need to create a "mock" Server and fabricate a board response message from server so that 
 * the client can receive and parse the message.
 *  
 * @author QI WANG
 *
 */
public class BoardResponseControllerTest extends TestCase {
	
	// Mock server object that extends (and overrides) ServerAccess for its purposes
	MockServerAccess mockServer;
			
	// client to connect
	Application client;
			
	// model being maintained by client.
	GameRoom model;

	protected void setUp() throws Exception {
		
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
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
	 * Validates the controller can receive and parses the fabricated message correctly.  
	 */
	public void testProcess() {
		//fail("Not yet implemented");
		
		String xmlString = Message.responseHeader("someMessageID") + "<boardResponse gameId = 'somePlace' size = '0' managingUser = 'george' contents = 'ECDRFTGOUIGERPRT' bonus = '4,3'>"
				+"<player name = 'george' position = '1,1' board = 'QuWERTYUIOPASDFGH' score = '0'></player>"
				+"<player name = 'george1' position = '1,1' board = 'QuWERTYUIOPASDFGH' score = '0'></player>"
				+"<player name = 'george2' position = '1,1' board = 'QuWERTYUIOPASDFGH' score = '0'></player>"
	
				+ "</boardResponse></response>";
		Message response = new Message(xmlString);
		
		model.setCurrentPlayerName("george2");
		boolean result = new BoardResponseController(client, model).process(response);
		
		assertTrue("Should be true", result);
	}

}
