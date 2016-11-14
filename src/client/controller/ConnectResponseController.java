package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class ConnectResponseController extends ControllerChain {
	
	public Application app;
//	public Model model;
	public GameRoom m;
	
	public ConnectResponseController(Application a, GameRoom m) {
		super();
		this.app = a;
		this.m = m;
	}
	
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("connectResponse")) {
			return next.process(response);
		}
		
		//app.getResponseArea().append(response.toString() + "\n");
		return true;
	}
}
