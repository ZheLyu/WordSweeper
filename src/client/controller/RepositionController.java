package client.controller;

import xml.Message;
import client.model.Model;
import client.view.Application;

public class RepositionController {
	
	Application app;
	Model model;
	
	public RepositionController (Application app , Model model) {

		this.app = app;

		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		
		String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne'/></request>";
		Message m = new Message (xmlString);
		
	
	}


}
