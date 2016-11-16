package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.model.GameRoom;
import client.view.Application;
import xml.Message;

public class JoinGameResponseController extends ControllerChain {

	public Application app;
	public GameRoom model;
	
	public JoinGameResponseController(Application a, GameRoom m) {
		super();
		this.app = a;
		this.model = m;
	}
	
	@Override
	public boolean process(Message response) {
		// TODO Auto-generated method stub
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("joinGameResponse")) {
			return next.process(response);
		}
		Node joinGameResponse = response.contents.getFirstChild();
		NamedNodeMap map = joinGameResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();

		return true;
	}

}
