package client.model;

import java.util.*;

public class GameRoom {
	
 // practice model or team model
	private boolean locked; 
	private List<Player> players; 
	private String password; 
	private Board board;
	
	public GameRoom(List<Player> players, String password) {
		
		this.password = password;
		this.players = new ArrayList<Player>();
		for (int i = 0; i < players.size(); i++) {
			this.players.add(players.get(i));
		}
	}
	
	public Player getManagingPlayer() {
		
		return null;
	}
	
	public int computeScore(Word word) {
		
		return 0;
	}
	
	public void updateBoard(Board board, List<Player> players) {
		
		
	}
}
