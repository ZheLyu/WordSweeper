package client.controller;
import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;


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
		model = new GameRoom("123", "password");
		client = new Application (model);
		client.setVisible(true);
		
		mockServer = new MockServerAccess("localhost");
		client.setServerAccess(mockServer);
	}
	
	protected void tearDown() throws Exception {
		//super.tearDown();
		
	}
	
	public void testLeftProcess() {
		//fail("Not yet implemented");
		
		new RepositionBoardRequestController(client, model).leftProcess();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("repositionBoardRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println("left" + r.toString());
//		<repositionBoardRequest gameId='somePlace' name='nextOne' rowChange='-1' /></request>";
		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("nextOne", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("-1", r.contents.getFirstChild().getAttributes().getNamedItem("rowChange").getNodeValue());
	
	}
	
	public void testRightProcess() {
		//fail("Not yet implemented");
		
		new RepositionBoardRequestController(client, model).rightProcess();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("repositionBoardRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println("right" + r.toString());
//		<repositionBoardRequest gameId='somePlace' name='nextOne' rowChange='-1' /></request>";
		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("nextOne", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("1", r.contents.getFirstChild().getAttributes().getNamedItem("rowChange").getNodeValue());

	}
	
	public void testUpProcess() {
		//fail("Not yet implemented");
		
		new RepositionBoardRequestController(client, model).upProcess();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("repositionBoardRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println("up" + r.toString());
//		<repositionBoardRequest gameId='somePlace' name='nextOne' rowChange='-1' /></request>";
		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("nextOne", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("1", r.contents.getFirstChild().getAttributes().getNamedItem("colChange").getNodeValue());
	//	assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
	}
	
	public void testDownProcess() {
		//fail("Not yet implemented");
		
		new RepositionBoardRequestController(client, model).downProcess();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("repositionBoardRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println("down" + r.toString());
//		<repositionBoardRequest gameId='somePlace' name='nextOne' rowChange='-1' /></request>";
		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("nextOne", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("-1", r.contents.getFirstChild().getAttributes().getNamedItem("colChange").getNodeValue());
	//	assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
	}
}
