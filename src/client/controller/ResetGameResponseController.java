package client.controller;

import client.model.GameRoom;
import client.view.Application;

public class ResetGameResponseController {
	public final String gameId;
	Application app;
	GameRoom model;

	public ResetGameResponseController(String gameId,Application app,GameRoom model) {
		this.gameId = gameId;
		this.app=app;
		this.model=model;
	}


}
