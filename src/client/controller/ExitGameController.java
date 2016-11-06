package client.controller;

import xml.Message;
import client.model.Model;
import client.view.Application;
public class ExitGameController {
	Application app;
	Model model;

	public ExitGameController(Application app , Model model) {

		this.app = app;

		this.app =app;

		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to exit the game.
		String xmlString = Message.requestHeader() + "<exitGameRequest gameId='somePlace' name='nextOne'/></request>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
				app.getServerAccess().sendRequest(m);
				app.setVisible(false);
	}


	}
