/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

Player.java : implementation file
This is a model class for store player message and get the player's 
position from server.

History:
5 Oct, 2016	--- Zhe Lyu @1
- Created.

*****************************************************************/


package client.model;

import java.util.*;

public class Player {
	
	private boolean isManager;
	private long totalScore;
	private Position globalPosition;
//	private List<String> words;
	private Board board;
	private String name; 
 
	public Player(String name, String boardContents, String globalPosition, long totalScore, boolean isManager) {
		
		
		this.name = name; 
		this.board = new Board(boardContents);
		this.globalPosition = new Position (Integer.parseInt("" + globalPosition.charAt(2)),
											Integer.parseInt("" + globalPosition.charAt(0)));
				                       
		this.isManager = isManager; 
	//	words = new ArrayList<>();
		this.totalScore = totalScore;
		
	}
	
	
	/** Get the player's position from server*/
	public Position getGlobalPosition() {
		
		return globalPosition; 
	}
	
	public void setGlobalPosition(String position) {
		
		globalPosition.setRow(Integer.parseInt("" + position.charAt(0)));
		globalPosition.setColumn(Integer.parseInt("" + position.charAt(2)));
		
	}
	
	public String getName() {
		
		return name; 
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	
	public void setScore(long totalScore) { 
		
		this.totalScore = totalScore;
	}
	
	public long getScore() {
		
		return totalScore;
	}
	
	public Board getBoard() {
		
		return board;
	}
	
	public void setManagingPlayer(boolean isManager) {
		
		this.isManager = isManager();
	}
	
	public boolean isManager() {
		return isManager; 
	}
	

	
}
