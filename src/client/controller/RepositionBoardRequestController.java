package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class RepositionBoardRequestController {
	
	Application app;
	GameRoom model;
	
	public RepositionBoardRequestController (Application app , GameRoom model) {

		this.app = app;

		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void leftProcess() {
		
		String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' rowChange='-1' /></request>";
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	
	}

    public void rightProcess() {
		
    	String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' rowChange='1' /></request>";
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	
	}
    public void upProcess() {
		
		String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' colChange='1'/></request>";
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	
	}
    public void downProcess() {
		
		String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' colChange='-1' /></request>";
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	
	}
}
