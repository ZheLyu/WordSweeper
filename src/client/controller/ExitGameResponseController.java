package client.controller;

import client.model.GameRoom;
import client.view.Application;
import xml.Message;

public class ExitGameResponseController extends ControllerChain {

	public Application app;
	public GameRoom model;
	
	public ExitGameResponseController(Application a, GameRoom m) {
		super();
		this.app = a;
		this.model = m;
	}
	
	@Override
	public boolean process(Message response) {
		// TODO Auto-generated method stub
		return false;
	}

}
