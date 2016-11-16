package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

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
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("resetGameResponse")) {
			return next.process(response);
		}
		Node resetGameResponse = response.contents.getFirstChild();
		NamedNodeMap map = resetGameResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		model.setGameId(gameId);
		return true;
	}
	
}
