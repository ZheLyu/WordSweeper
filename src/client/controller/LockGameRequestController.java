package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class LockGameRequestController {
	Application app;
	GameRoom model;

	public LockGameRequestController(Application app , GameRoom model) {

		this.app = app;

		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to lock the game.
		//tring xmlString = Message.requestHeader() + "<lockGameRequest gameId='sample'/></request>";
		Message m = new Message (toString());

		// Request the lock (this might not succeed).
		app.getServerAccess().sendRequest(m);
	}
	public String toString() {
		String s=model.getGameId();
		return new XmlStringBuilder("lockGameRequest").add("gameId",s).finish()
				.toString();
	}
}
