package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;
public class ExitGameRequestController {
	Application app;
	GameRoom model;

	public ExitGameRequestController(Application app , GameRoom model) {

		this.app = app;

		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to exit the game.
		String xmlString = Message.requestHeader() + "<exitGameRequest gameId='somePlace' name='nextOne'/></request>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
				app.getServerAccess().sendRequest(m);
				
	}
	public String toString() {
		String s=model.getGameId();
		String s1=model.getPlayer().getName();
		return new XmlStringBuilder("exitGameRequest").add("gameId",s).add("name",s1).finish()
				.toString();
	}


}
