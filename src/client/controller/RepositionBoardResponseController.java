package client.controller;

import client.model.GameRoom;
import client.view.Application;

public class RepositionBoardResponseController {
	public  String gameId;
	Application app;
	GameRoom model;

	public RepositionBoardResponseController(String gameId,Application app, GameRoom model) {
		this.gameId = gameId;
		this.app=app;
		this.model=model;
	}
}
