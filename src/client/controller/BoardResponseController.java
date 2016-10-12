package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.Message;
import client.model.Model;
import client.view.Application;

/**
 * Tells the client whether the model is locked or not BY SOME OTHER CLIENT. This will never be returned to a client
 * to tell him that HE has the model locked (that is job of LockResponse).
 */
public class BoardResponseController {

	public Application app;
	public Model model;
	
	public BoardResponseController(Application a, Model m) {
		this.app = a;
		this.model = m;
	}
	
	
	public void process(Message response) {
		
	}
		

}
