/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

JoinGameController.java : implementation file
This is a controller class for sending request to server. 
If the client requests to join a game the system will connect to server and get response.

History:

*****************************************************************/


package client.controller;


import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class JoinGameRequestController {

	Application app;
	GameRoom model;

	public JoinGameRequestController(Application app, GameRoom model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		String xmlString = Message.requestHeader() + "<joinGameRequest gameId='somePlace' name='nextOne' password = '12345'/></request>";
		Message m = new Message (xmlString);
		
		// Request the lock (this might not succeed).
		app.getServerAccess().sendRequest(m);
	}
}
