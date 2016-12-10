package client.controller;

import java.util.List;

import xml.Message;
import client.model.Cell;
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
		
		if (toString() != null) {
			
			Message m = new Message (toString());
			// Request the lock (this might not succeed).
			System.out.println(m);
			app.getServerAccess().sendRequest(m);
		}

		app.setVisible(false);
	}
	
	public String toString() {
		
		List<Cell> cellList = model.getDrawModel().getSelCellList2();
		String word = model.getDrawModel().getWord(cellList);
		XmlStringBuilder builder = new XmlStringBuilder("findWordRequest").add("gameId", model.getGameId()).add("name", model.getPlayer().getName()).add("word", word).closeSegment();
		
		for (int i = 0; i < word.length(); i++){
			
			builder.add("cell").add("letter", cellList.get(i).getLetter()).add("position", cellList.get(i)
		    .getPosition().localToGlobal(model.getPlayer().getGlobalPosition()).switchColRow().toString()).closeSegment().finishTep("cell");
		}
      
		return builder.finishSegment().toString();
	}


}