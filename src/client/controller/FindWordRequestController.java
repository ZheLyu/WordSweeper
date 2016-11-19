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

	//	String xmlString = Message.requestHeader() + "<findWordRequest name='nextOne' word = 'sample' gameId='somePlace' /></request>";
		/*String xmlString = Message.requestHeader() +
				"<findWordRequest gameId='somePlace' name='nextOne' word='sample'>" +
			      "<cell letter= 's' position='1,6'/>" +
			      "<cell letter= 'a' position='2,6'/>" +
			      "<cell letter= 'm' position='3,6'/>" +
			      "<cell letter= 'p' position='4,6'/>" +
			      "<cell letter= 'l' position='5,6'/>" +
			      "<cell letter= 'e' position='6,6'/>" +
			  "</findWordRequest>" +
			"</request>";*/
//		String xmlString = Message.responseHeader(request.id()) +
//				"<boardResponse gameId='hg12jhd' managingUser='" + pname + "' bonus='4,3' contents='ABCGBCJDH...HDJHJD'>" +
//			      "<player name='" + pname + "' score='392489038' position='4,6' board='AFERKSOEROIERPOR'/>" +
//			  "</boardResponse>" +
//			"</response>";
		Message m = new Message (toString());

		// Request the lock (this might not succeed).
		app.getServerAccess().sendRequest(m);
		app.setVisible(false);
	}
	public String toString() {
	 String word = model.getWord(model.getDrawModel().getSelCellList2());
		XmlStringBuilder builder = new XmlStringBuilder("findWordRequest").add("gameId", model.getGameId()).add("name", model.getPlayer().getName()).add("word", word).closeSegment();
		int i=0;
		while(i<word.length()){
			
			builder.add("cell").add("letter", model.getLetter(i, model.getDrawModel().getSelCellList2())).add("position", model.getPosition(i, model.getDrawModel().getSelCellList2())).closeElement().toString();
		}

		return builder.finishSegment().toString();
	}


}