package client.controller;


import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

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
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("exitGameResponse")) {
			return next.process(response);
		}
		Node exitGameResponse = response.contents.getFirstChild();
		NamedNodeMap map = exitGameResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
	    System.out.println("Exit game:"+gameId);
	    
	    if (gameId==model.getGameId())
	    	System.exit(0);
		return true;
	}

}
