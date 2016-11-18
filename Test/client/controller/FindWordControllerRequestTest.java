package client.controller;

import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.GameRoom;
import client.model.Position;
import client.view.Application;
import junit.framework.TestCase;

public class FindWordControllerRequestTest extends TestCase {

	
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
		//super.tearDown();
		
	}
	
	public void testProcess() {
		//fail("Not yet implemented");
		
		new FindWordRequestController(client, model).process();
		
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		
		assertEquals("findWordRequest", r.contents.getFirstChild().getLocalName());
		
		System.out.println(r.toString());
		assertEquals("somePlace", r.contents.getFirstChild().getAttributes().getNamedItem("gameId").getNodeValue());
		assertEquals("nextOne", r.contents.getFirstChild().getAttributes().getNamedItem("name").getNodeValue());
		assertEquals("sample", r.contents.getFirstChild().getAttributes().getNamedItem("word").getNodeValue());
		
		assertEquals("cell", r.contents.getFirstChild().getFirstChild().getLocalName());
		
		
		String s = "";
		String[] list = new String[r.contents.getChildNodes().item(0).getChildNodes().getLength()];
 		for (int i = 0; i < r.contents.getChildNodes().item(0).getChildNodes().getLength(); i++) {
			
				s += r.contents.getChildNodes().item(0).getChildNodes().item(i).getAttributes().getNamedItem("letter").getNodeValue();
			//	System.out.println(r.contents.getChildNodes().item(0).getChildNodes().item(i).getAttributes().getNamedItem("position").getNodeValue());
				list[i] = r.contents.getChildNodes().item(0).getChildNodes().item(i).getAttributes().getNamedItem("position").getNodeValue();
		}
		
		assertEquals("sample", s);
		assertEquals("1,6", list[0]);
		assertEquals("2,6", list[1]);
		assertEquals("3,6", list[2]);
		assertEquals("4,6", list[3]);
		assertEquals("5,6", list[4]);
		assertEquals("6,6", list[5]);
		
		
		
		
		
		
		
	}

}
