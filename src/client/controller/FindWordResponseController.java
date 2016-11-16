package client.controller;

import client.model.GameRoom;
import client.view.Application;
import xml.Message;

public class FindWordResponseController extends ControllerChain {
	
	public Application app;
	public GameRoom model;
	
	public FindWordResponseController(Application a, GameRoom m) {
		super();
		this.app = a;
		this.model = m;
	}
	
	@Override
	public boolean process(Message response) {
		
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("findWordResponse")) {
			return next.process(response);
		}
		
		
		return true;
	}

}
