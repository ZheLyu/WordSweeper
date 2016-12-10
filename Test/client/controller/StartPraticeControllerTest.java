package client.controller;

import client.model.DrawBoardModel;
import client.model.GameRoom;
import client.view.Application;
import junit.framework.TestCase;
import client.model.*;

public class StartPraticeControllerTest extends TestCase {
	// client to connect
	Application client;
	
	Application app;
	GameRoom model;
	
	String managingUser = "george";
	String bonus = "4,3";
	String[] names = {"george","somePlayer", "nextOne"};
	String[] positions = {"1,1","1,1","3,3"};
	String[] board = {"QuWERTYUIOPLKJHGF", "QuWERTYUIOPLKJHGF","MLPOKNJIUHBVGYTF"};
	long[] scores = {0,30,0};
	String password = "123456";

	protected void setUp() throws Exception {
		super.setUp();
		client = new Application (model);
		client.setVisible(true);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testProcess() {
		//fail("Not yet implemented");
		model = new GameRoom("somePlace");
		model.getDrawModel().setBoard(new Board());
		new StartPraticeController(app, model).process();
		
		
	}

}
