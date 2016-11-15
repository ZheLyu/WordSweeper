package client.controller;

import xml.Message;

public class FindWordResponseController extends ControllerChain {
	public  String gameId;
	public  String name;
	public  long score;

	public FindWordResponseController(String gameId, String name, long score) {
		this.gameId = gameId;
		this.name = name;
		this.score = score;
	}

	@Override
	public boolean process(Message response) {
		// TODO Auto-generated method stub
		return false;
	}

}
