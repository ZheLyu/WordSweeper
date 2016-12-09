package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import client.model.GameRoom;
import client.model.Player;
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
		
		System.out.println("find word response " + response.toString());
		Node findWordResponse = response.contents.getFirstChild();
		NamedNodeMap map = findWordResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		
		String pname = map.getNamedItem("name").getNodeValue();
	
		String score = map.getNamedItem("score").getNodeValue();
		long s = Long.valueOf(score);

		 if (gameId.equals(model.getGameId()) && model.getCurrentPlayerName().equals(pname)){
			 model.findWordResponseHandler(s);
			 
		 }
		 

     
		return true;
	
	}

}
