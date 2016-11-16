package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

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
		Node resetGameResponse = response.contents.getFirstChild();
		NamedNodeMap map = resetGameResponse.getAttributes();
		
		String gameId = map.getNamedItem("id").getNodeValue();
	
		//app.getResponseArea().append(response.toString() + "\n");
		return true;
	}
}

