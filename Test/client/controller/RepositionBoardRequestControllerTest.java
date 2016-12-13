package client.controller;
import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;

/**
 * 
 * @author QI WANG
 *
 */
public class RepositionBoardRequestControllerTest extends TestCase {

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
		model = new GameRoom("somePlace");
		client = new Application (model);
		client.setVisible(true);
		
		mockServer = new MockServerAccess("localhost");
	
		client.setServerAccess(mockServer);
		
		String[] names1 = {"george"};
		String[] positions1 = {"1,1"};
		String[] board1 = {"QuWERTYUIOPLKJHGF"};
		long[] scores1 = {0};
		String bonus = "4,3";
		
		model.setCurrentPlayerName("george");
		model.boardResponseHandler("george", bonus, names1, positions1, board1, scores1);
		
	}
	
	protected void tearDown() throws Exception {
		//super.tearDown();
		
	}
	
	public void testLeftProcess() {
		//fail("Not yet implemented");
		
		model.setGameId("somePlace");
		
		new RepositionBoardRequestController(client, model).leftProcess();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("repositionBoardRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println("left" + r.toString());

		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("george", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("0", r.contents.getFirstChild().getAttributes().getNamedItem("rowChange").getNodeValue());
	
	}
	
	public void testRightProcess() {
		//fail("Not yet implemented");
		
		new RepositionBoardRequestController(client, model).rightProcess();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("repositionBoardRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println("right" + r.toString());

		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("george", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("0", r.contents.getFirstChild().getAttributes().getNamedItem("rowChange").getNodeValue());

	}
	
	public void testUpProcess() {
		//fail("Not yet implemented");
		
		new RepositionBoardRequestController(client, model).upProcess();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("repositionBoardRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println("up" + r.toString());

		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("george", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("0", r.contents.getFirstChild().getAttributes().getNamedItem("colChange").getNodeValue());
	
	}
	
	public void testDownProcess() {
		//fail("Not yet implemented");
		
		new RepositionBoardRequestController(client, model).downProcess();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("repositionBoardRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println("down" + r.toString());

		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("george", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("0", r.contents.getFirstChild().getAttributes().getNamedItem("colChange").getNodeValue());
	
	}
}
