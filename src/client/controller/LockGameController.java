package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class LockGameController {
	Application app;
	GameRoom model;

	public LockGameController(Application app , GameRoom model) {

		this.app = app;

		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to lock the game.
		String xmlString = Message.requestHeader() + "<lockGameRequest gameId='sample'/></request>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
				app.getServerAccess().sendRequest(m);
	}
}
