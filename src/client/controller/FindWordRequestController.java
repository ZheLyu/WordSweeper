package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class FindWordRequestController {
	Application app;
	GameRoom model;

	public FindWordRequestController(Application app , GameRoom model) {

		this.app = app;

		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to exit the game.
	//	String xmlString = Message.requestHeader() + "<findWordRequest name='nextOne' word = 'sample' gameId='somePlace' /></request>";
		String xmlString = Message.requestHeader() +
				"<findWordRequest gameId='somePlace' name='nextOne' word='sample'>" +
			      "<cell letter= 's' position='1,6'/>" +
			      "<cell letter= 'a' position='2,6'/>" +
			      "<cell letter= 'm' position='3,6'/>" +
			      "<cell letter= 'p' position='4,6'/>" +
			      "<cell letter= 'l' position='5,6'/>" +
			      "<cell letter= 'e' position='6,6'/>" +
			  "</findWordRequest>" +
			"</request>";
//		String xmlString = Message.responseHeader(request.id()) +
//				"<boardResponse gameId='hg12jhd' managingUser='" + pname + "' bonus='4,3' contents='ABCGBCJDH...HDJHJD'>" +
//			      "<player name='" + pname + "' score='392489038' position='4,6' board='AFERKSOEROIERPOR'/>" +
//			  "</boardResponse>" +
//			"</response>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
		app.getServerAccess().sendRequest(m);
		app.setVisible(false);
	}


}