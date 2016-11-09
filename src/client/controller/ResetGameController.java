package client.controller;

import xml.Message;
import client.model.Model;
import client.view.Application;

public class ResetGameController {
	
	Application app;
	Model model;
	
	public ResetGameController(Application app, Model model){
		
		this.app = app;
		this.model = model;
	}
	
	public void process(){
		
		//String gameId = map.getNamedItem("gameId").getNodeValue();
		
		// send the request to reset the game.
		String xmlString = Message.requestHeader() + "<resetGameRequest gameId='somePlace' /></request>";
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
		
	}

}
