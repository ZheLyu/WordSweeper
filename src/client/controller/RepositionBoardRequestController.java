package client.controller;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

public class RepositionBoardRequestController {
	
	Application app;
	GameRoom model;
	
	public RepositionBoardRequestController (Application app , GameRoom model) {

		this.app = app;

		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void leftProcess() {

		//String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' rowChange='-1' /></request>";
		Message m = new Message (ltoString());
		
		app.getServerAccess().sendRequest(m);
	
	}

    public void rightProcess() {
		
    	//String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' rowChange='1' /></request>";
		Message m = new Message (rtoString());
		
		app.getServerAccess().sendRequest(m);
	
	}
    public void upProcess() {
		
		//String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace' name='nextOne' colChange='1'/></request>";
		Message m = new Message (utoString());
		
		app.getServerAccess().sendRequest(m);
	
	}
    public void downProcess() {
		
		//String xmlString = Message.requestHeader() + "<repositionBoardRequest gameId='somePlace'  name='nextOne' colChange='-1' /></request>";
		Message m = new Message (dtoString());
		
		app.getServerAccess().sendRequest(m);
	
	}
    public String ltoString() {
    	String s1=model.getGameId();
		String s=model.getPlayer().getName();
		return new XmlStringBuilder("repositionBoardRequest").add("gameId", s1).add("name",s).add("rowChange","-1").finish()
				.toString();
    }
    public String rtoString() {
    	String s1=model.getGameId();
		String s=model.getPlayer().getName();
		return new XmlStringBuilder("repositionBoardRequest").add("gameId", s1).add("name",s).add("rowChange","1").finish()
				.toString();
    }
    public String utoString() {
    	String s1=model.getGameId();
		String s=model.getPlayer().getName();
		return new XmlStringBuilder("repositionBoardRequest").add("gameId", s1).add("name",s).add("colChange","1").finish()
				.toString();
    }
    public String dtoString() {
    	String s1=model.getGameId();
		String s=model.getPlayer().getName();
		return new XmlStringBuilder("repositionBoardRequest").add("gameId", s1).add("name",s).add("colChange","-1").finish()
				.toString();
    }
}
