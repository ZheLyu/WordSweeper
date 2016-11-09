package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class RepositionController {
	
	Application app;
	GameRoom model;
	
	public RepositionController (Application app , GameRoom model) {

		this.app = app;

		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void lprocess() {
		
		String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' rowChange='-1' /></request>";
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	
	}

    public void rprocess() {
		
		String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' rowChange='1' /></request>";
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	
	}
    public void uprocess() {
		
		String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' colChange='1'/></request>";
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	
	}
    public void dprocess() {
		
		String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' colChange='-1' /></request>";
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	
	}
}
