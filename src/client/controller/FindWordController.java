package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class FindWordController {
	Application app;
	GameRoom model;

	public FindWordController(Application app , GameRoom model) {

		this.app = app;

		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to exit the game.
		String xmlString = Message.requestHeader() + "<findWordRequest name='nextOne' word = 'sample' gameId='somePlace' /></request>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
		app.getServerAccess().sendRequest(m);
		app.setVisible(false);
	}


}