
package client.model;

import java.util.*;

/**
 * 
 * This player class stores all the information related to a player, including if the player is manager
 * the total score gained in the game, the global position related to a board in the server, the board
 * which the player is playing with, the name of the player
 * @author ZELING LEI 
 *
 */
public class Player {
	
	/**
	 * True if the player is manager
	 */
	private boolean isManager;
	/**
	 * The score of the player
	 */
	private long totalScore;
	/**
	 * The global position on the server side
	 */
	private Position globalPosition;
	/**
	 * The board the player is playing with 
	 */
	private Board board;
	/**
	 * The name of the player
	 */
	private String name; 
	
	/**
	 * Constructs a player based on the message received from the server 
	 * @param name
	 * 		  the name of the player
	 * @param boardContents
	 * 		  the board content of the player 
	 * @param globalPosition
	 * 		  the global position on the server side
	 * @param totalScore
	 * 		  The score of the player
	 * @param isManager
	 * 		  True if the player is manager
	 */
	public Player(String name, String boardContents, String globalPosition, long totalScore, boolean isManager) {
		
		
		this.name = name; 
		this.board = new Board(boardContents);
		this.globalPosition = new Position (Integer.parseInt("" + globalPosition.charAt(2)),
											Integer.parseInt("" + globalPosition.charAt(0)));
				                       
		this.isManager = isManager; 
		this.totalScore = totalScore;
		
	}
	
	
	/** Get the player's position from server*/
	public Position getGlobalPosition() {
		
		return globalPosition; 
	}
	/**
	 * Updates the global position based on given position
	 * @param position
	 */
	public void setGlobalPosition(String position) {
		
		globalPosition.setRow(Integer.parseInt("" + position.charAt(0)));
		globalPosition.setColumn(Integer.parseInt("" + position.charAt(2)));
		
	}
	/**
	 * Returns the name of the player
	 * @return
	 */
	public String getName() {
		
		return name; 
	}
	
	/**
	 * Sets the name of the player 
	 * @param name
	 */
	public void setName(String name) {
		
		this.name = name;
	}
	
	/**
	 * Set the total score of the player 
	 * @param totalScore
	 */
	public void setScore(long totalScore) { 
		
		this.totalScore = totalScore;
	}
	
	/**
	 * Gets the  total score
	 * @return
	 */
	public long getScore() {
		
		return totalScore;
	}
	
	/**
	 * Get the board of the player
	 * @return
	 */
	public Board getBoard() {
		
		return board;
	}
	
	/**
	 * Set the manager information of the current player
	 * @param isManager
	 */
	public void setManagingPlayer(boolean isManager) {
		
		this.isManager = isManager();
	}
	/**
	 * Returns true if the player is manager
	 * @return
	 */
	public boolean isManager() {
		return isManager; 
	}
	

	
}
