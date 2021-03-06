/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

LockGameResponseController.java : implementation file
This is a controller class for handling  response from server. 

7 	Nov, 2016 --- Zhe Lyu @1
-Created.

*****************************************************************/

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
	/**
	 * Analysis the XML Message:lockGameResponse.
	 */
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
	    
	    if (gameId==model.getGameId()) {
	    	System.out.println(" Game:"+gameId+"is locked!");
		    model.setLocked(true);
	    }
	    return true;
	}
}
