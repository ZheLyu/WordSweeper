package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class ResetGameResponseController extends ControllerChain{

	public Application app;
	public GameRoom model;
	
	public ResetGameResponseController(Application a, GameRoom m) {
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
