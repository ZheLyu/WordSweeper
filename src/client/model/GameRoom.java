
package client.model;

import java.util.*;

import client.view.SweeperPanel;

/**
 * This is a model class, used to communicate with controller classes and boundary classes.
 * 
 * @author ZELING LEI
 *
 */

public class GameRoom {
	
	/**
	 * An object including methods and points to draw board model 
	 */
	private DrawBoardModel drawBoardModel;  
	/**
	 * Current game id
	 */
	private String gameId;
	/**
	 * True if the room is locked
	 */
	private boolean locked; 
	private List<Player> players; 
	/**
	 * the password of the room
	 */
	private String password; 
	/**
	 * A map stores the relation between name and player 
	 */
	private Map<String, Player> findPlayerByName; 
	private Position bonus;
	/**
	 * Current player 
	 */
	private Player player; 
	/**
	 * The name of current player 
	 */
	private String currentPlayerName;
	/**
	 * A map stores the relation between position to weight
	 */
	private Map<Position, Integer> globalPositionToWeight;
	/**
	 * The name of managing user 
	 */
	private String managingUser;
	/**
	 * Indicates whether the game is in practice mode
	 */
    boolean isPracticeMode;
  
	
	/**
	 * Initialize the game, some of the attribute may initialize later 
	 * @param gameId
	 */
	public GameRoom(String gameId) {
	
		this.gameId = gameId;
		bonus = null;
		drawBoardModel = new DrawBoardModel();
		findPlayerByName = new HashMap<String, Player>();
		locked = false; 
		password= "";
		players = new ArrayList<Player>();
		player = null;
		currentPlayerName = "";
		globalPositionToWeight = new HashMap<Position, Integer>();
		managingUser = "";
		isPracticeMode = true;
	}
	
	/**
	 * Returns the managing player
	 * @return
	 */
	public String getManagingPlayer() {
		
		return managingUser;
	}
	/**
	 * Set current player name, used when the user first login
	 * @param name
	 */
	public void setCurrentPlayerName(String name) {
		
		currentPlayerName = name;
	}
	
	/**
	 * Gets current player name, used when the user first login
	 * @return
	 */

	public String getCurrentPlayerName() {
			
		return currentPlayerName;
	}
		
	/**
	 * Set the game mode, whether is practice game or not 
	 * @param isPracticeMode
	 */
	public void setGameMode(boolean isPracticeMode) {
		
		this.isPracticeMode = isPracticeMode;
	}
	/**
	 * Returns true if the game is in practice mode 
	 * @return
	 */
    public boolean getGameMode() {
		
		return this.isPracticeMode;
	}

	/**
	 * Receives all the message passed by board response xml message, and pass them to other
	 * classes, such as player, in model package
	 * @param managingUser
	 * @param bonus
	 * @param names
	 * @param positions
	 * @param board
	 * @param scores
	 */
	public void boardResponseHandler(String managingUser, String bonus, String[] names, 
			                         String[] positions, String[] board, long[] scores) {
		
		this.managingUser = managingUser;
		setBonus(bonus);
		players.clear();
		findPlayerByName.clear();
		globalPositionToWeight.clear();
		getDrawModel().clearSelCellList();
		
		int length = names.length; // store the number in the game room

			
		for (int i = 0; i < length; i++) {
			
			if (names[i].equals(currentPlayerName)) { // update the current player
				
				player = new Player(names[i], board[i], positions[i], scores[i], names[i].equals(managingUser));
				players.add(player);
				drawBoardModel.setBoard(player.getBoard());
				findPlayerByName.put(names[i], player);
			} else { // update the attribute of other players
				
				Player newPlayer = new Player(names[i], board[i], positions[i], scores[i], names[i].equals(managingUser));
				players.add(newPlayer);
				findPlayerByName.put(names[i], newPlayer);
			}
		
			
		}
		
		computeSharedArea(); // update shared area 
		
	}
	
	/**
	 * Returns the current player
	 * @return
	 */
	public Player getPlayer() {
		
		return player; 
	}
	
	/**
	 * Returns the list of players
	 * @return
	 */
	public List<Player> getPlayerList() {
		
		return players;
	}
	
	/**
	 * Receives information from find word response, now it is here for future use
	 * @param score
	 */
	public void findWordResponseHandler(long score) {
		
		//player.setScore(score);
	}
	/**
	 * Returns the draw model of the current game
	 * @return
	 */
	public DrawBoardModel getDrawModel() {
		return drawBoardModel;
	}
	/**
	 * Refreshes the draw model of the game 
	 * @param drawBoardModel
	 */
	public void setDrawBoardModel(DrawBoardModel drawBoardModel) {
		this.drawBoardModel = drawBoardModel;
	}
	/**
	 * Sets the game id based on the given value 
	 * @param gameId
	 */
	public void setGameId(String gameId) {
		this.gameId = gameId; 
	}
	
	/**
	 * Returns the game id 
	 * @return
	 */
	public String getGameId() {
		
		return gameId; 
	}
	/**
	 * Locks the game room 
	 * @param locked
	 */
	public void setLocked(boolean locked) {
		
		this.locked = locked; 
		
	}
	/**
	 * Returns true if the room is locked
	 * @return
	 */
	public boolean isLocked() {
		
		return locked; 
	}
	
	/**
	 * Returns a map which helps to find a player object based on the name
	 * @return
	 */
	public Map<String, Player> findPlayerByName() {
		return findPlayerByName;
	}
	/**
	 * Gets the password of the game room
	 * @return
	 */
	public String getPassword() {
		return password; 
	}
	/**
	 * Set the password of the game room
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	// set the bonus 
	private void setBonus(String bonus) {
		this.bonus = new Position(Integer.parseInt("" + bonus.charAt(2)),
				                  Integer.parseInt("" + bonus.charAt(0)));	
	}
	/**
	 *  Get the bonus of the current board
	 *  if the bonus is not in the board or the game is practice mode return "" instead
	 * @return
	 */
	public String getBonus() {
		if (!isPracticeMode) {
			Position newBonus = bonus.globalToLocal(player.getGlobalPosition());
			if (newBonus.getColumn() >= 0 && newBonus.getColumn() <= 3 && newBonus.getRow() >= 0 && newBonus.getRow() <= 3)
				return " row: " + (newBonus.getRow() + 1) + " col: " + (newBonus.getColumn() + 1);
			else 
				return "";
			
		} else {
			return "";
		}

	}
	/**
	 * Returns a map which stores the number of people in the related position
	 * @return
	 */
	public Map<Position, Integer> getPositionToWeight() {
		Map<Position, Integer> positionToWeight = new HashMap<Position, Integer>();
		for (Position globalPosition: globalPositionToWeight.keySet()) {
			positionToWeight.put(globalPosition.globalToLocal(player.getGlobalPosition()), globalPositionToWeight.get(globalPosition));
		}
		return positionToWeight;
	}
	
	// Compute shared area based on the global position of the players
	private void computeSharedArea() {
		
		
		// Stores the sixteen position of the current player
		String name = player.getName();
		Set<Position> positions = getPositonsByName(name);
		
		
		for (int i = 0; i < players.size(); i++) {
			
			if (!players.get(i).getName().equals(name)) { // avoid name repetition
				
				Player tempPlayer = players.get(i);
				// Stores the sixteen position of the tempPlayer
				Set<Position> positionsTemp = getPositonsByName(tempPlayer.getName());
				// Stores the shared positions of two players
				Set<Position> intersection = new HashSet<>();
				// add positions of the current player to union
				intersection.addAll(positions);
				// get the union of positions of the current player and tempPlayer
				intersection.retainAll(positionsTemp);
				// copy the position in the union to positionToWeight
				Iterator<Position> itr = intersection.iterator();
				while(itr.hasNext()) {
					Position temp = itr.next();
					if (globalPositionToWeight.containsKey(temp)) { // if the position exist in the map, add 1 to the weight
						globalPositionToWeight.put(temp, globalPositionToWeight.get(temp) + 1);
					} else { // if the position does not exist, create a new one, at least two players share the same position
						globalPositionToWeight.put(temp, 2);
					}
				}
			}
			
		}
	}
	/**
	 * Stores the sixteen position of the given player in a set for comparison
	 * @param name
	 * @return 
	 */
	private Set<Position> getPositonsByName(String name) {
		
		Position globalPosition = findPlayerByName.get(name).getGlobalPosition();
		int row = globalPosition.getRow();
		int col = globalPosition.getColumn();
		
		Set<Position> positions = new HashSet<>();
		// get the sixteen position
		for (int i = row; i < row + 4; i++) {
			for (int j = col; j < col + 4; j++) {
				positions.add(new Position(i, j));
			}
		}
		return positions; 
		
	}
	
	/**
	 *  The score of one letter is POW(2, m) * WEIGHT * BONUS, m is the number of people share this letter
	    then produce the word score by adding up the score in each letter, and the final score should be POW(2, n) * wordScore, 
	    n is the length of the word
	 * @param cellList stores the letters of the word 
	 * @return the score of the letters in the cells 
	 */
	public long computeScore(List<Cell> cellList) {
		
		long score = 0;
		
		if(cellList.size()==0)
			return 0;
		int bonusMutiply = 1;
		for (int i = 0; i < cellList.size(); i++) {
				
			Cell cell = cellList.get(i);
			String letter = cell.getLetter();
			// transform the local position to global
			
			int sharedAreaMutiply = 0;
			
			if (!isPracticeMode) { // the player is playing on line
				
				Position globalPosition = cell.getPosition().localToGlobal(player.getGlobalPosition());
				
				if (globalPositionToWeight.containsKey(globalPosition)) {
					
					sharedAreaMutiply  = globalPositionToWeight.get(globalPosition);
				}
				
				if (bonus != null && globalPosition.equals(bonus)) {
					
					bonusMutiply = 10;
				}
			}
			score += Word.WEIGHT.get(letter) * Math.pow(2, sharedAreaMutiply);
		}
			score *=  bonusMutiply;
		
		// if the length of the letter is larger than 3, then multiply the total score by POW(2, wordLength) * 10
		
		score *= 10 * Math.pow(2, cellList.size());
		
		return score;
	
	}

	
}
