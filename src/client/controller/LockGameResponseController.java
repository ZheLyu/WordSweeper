package client.controller;

import client.model.GameRoom;
import client.view.Application;
import xml.Message;

public class LockGameResponseController extends ControllerChain {

	public Application app;
	public GameRoom model;
	
	public LockGameResponseController(Application a, GameRoom m) {
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
