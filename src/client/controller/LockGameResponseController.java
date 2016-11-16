package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

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
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("lockGameResponse")) {
			return next.process(response);
		}
		Node lockGameResponse = response.contents.getFirstChild();
		NamedNodeMap map = lockGameResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
	    System.out.println(" Game:"+gameId+"is locked!");
	    if (gameId==model.getGameId())
		    model.setLocked(true);
	    return true;
	}
}
