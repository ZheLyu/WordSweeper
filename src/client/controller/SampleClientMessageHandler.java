/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

SampleClientMessageHandler.java : implementation file
This is a controller class template for message handler.              

History:
1 Oct, 2016	--- George Heineman @1
- Created.

*****************************************************************/

package client.controller;
import xml.Message;
import client.IMessageHandler;
import client.view.Application;

/**
 * Sample implementation of a protocol handler to respond to messages received from the server.
 * You should follow this template when designing YOUR message handler.
 * 
 * Note: This one does nothing more than dump the XML message into the client window. Nothing that special.
 */
public class SampleClientMessageHandler implements IMessageHandler {

	Application app;
	
	// by default is the empty handler...
	ControllerChain chain = new EmptyHandler();
	
	/**
	 * Register new controller chain as occuring before existing chain.
	 */
	public void registerHandler(ControllerChain handler) {
		handler.next = chain;
		chain = handler;
	}
	
	public SampleClientMessageHandler(Application app) {
		this.app = app;
	}
	
	
	@Override
	public void process(Message response) {
		
		chain.process(response);
	}

}

