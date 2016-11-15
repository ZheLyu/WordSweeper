package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class LockGameResponseController {
	public  String gameId;
	Application app;
	GameRoom model;

	public LockGameResponseController(String gameId,Application app, GameRoom model) {
		this.gameId = gameId;
		this.app=app;
		this.model=model;
	}

}
