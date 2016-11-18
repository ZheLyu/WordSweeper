/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

GameRoom.java : implementation file
This is a model class for future use. It records information related
to a game room. It includes password, locked info, the board and 
players playing the game.  

History:
7 Oct, 2016	--- Zeling Lei @1
- Created.

*****************************************************************/
package client.model;

import java.util.*;

public class GameRoom {
	
 // practice model or team model
	private DrawBoardModel drawBoardModel;
	private String gameId;
	private boolean locked; 
	private List<Player> players; 
	private String password; 
	private Map<String, Player> findPlayerByName; 
	private Position bonus;
	private Player player; 
	private Map<Position, Integer> positionToWeight;
	private String managingUser;
	
	
	public GameRoom(String gameId) {
		
		this.gameId = gameId;
		bonus = null;
		drawBoardModel = new DrawBoardModel();
		findPlayerByName = new HashMap<String, Player>();
		locked = false; 
		password= "";
		players = new ArrayList<Player>();
		player = null;
		positionToWeight = new HashMap<Position, Integer>();
		managingUser = "";
	}
	

	// Returns the managing player
	public String getManagingPlayer() {
		
		return managingUser;
	}
	
	public void boardResponseHandler(String managingUser, String bonus, String[] names, 
			                         String[] positions, String[] board, long[] scores) {
		
		this.managingUser = managingUser;
		setBonus(bonus);
		players.clear();
		findPlayerByName.clear();
		positionToWeight.clear();
		int length = names.length; // store the number in the game room
		if (length == 1) { // execute after creating game or there is only one player in the room
			
			player = new Player(names[0], board[0], positions[0], scores[0], true);
			findPlayerByName.put(names[0], player);
			players.add(player);
			
		} else {
			
			for (int i = 0; i < length; i++) {
				
				if (names[i].equals(player.getName())) { // update the current player
					
					player = new Player(names[i], board[i], positions[i], scores[i], names[i].equals(managingUser));
					players.add(player);
					
				} else { // update the attribute of other players
					
					Player newPlayer = new Player(names[i], board[i], positions[i], scores[i], names[i].equals(managingUser));
					players.add(newPlayer);
				}
				findPlayerByName.put(names[i], player);
				
			}
			
		}
		computeSharedArea(); // update shared area 
		
	}
	
	
	public void findWordResponseHandler(long score) {
		
		player.updateTotalScore(score);
	}
		
	public DrawBoardModel getDrawModel() {
		return drawBoardModel;
	}
	
	public void setGameId(String gameId) {
		this.gameId = gameId; 
	}
	
	public String getGameId() {
		
		return gameId; 
	}
	
	public void setLocked(boolean locked) {
		
		this.locked = locked; 
		
	}
	
	public boolean getLocked() {
		
		return locked; 
	}
	
	
	public Map<String, Player> findPlayerByName() {
		return findPlayerByName;
	}
	
	public String getPassword() {
		return password; 
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	private void setBonus(String bonus) {
		this.bonus = new Position(Integer.parseInt("" + bonus.charAt(0)), 
				                  Integer.parseInt("" + bonus.charAt(2)));
	
	}
	
	public Map<Position, Integer> getPositionToWeight() {
		
		return positionToWeight;
	}
	
	// Compute shared area based on the global position of the players
	private void computeSharedArea() {
		
		
		// Stores the sixteen position of the current player
		String name = player.getName();
		Set<Position> positions = getPositonByName(name);
		
		
		for (int i = 0; i < players.size(); i++) {
			
			if (!players.get(i).getName().equals(name)) { // avoid name repetition
				
				Player tempPlayer = players.get(i);
				// Stores the sixteen position of the tempPlayer
				Set<Position> positionsTemp = getPositonByName(tempPlayer.getName());
				// Stores the shared positions of two players
				Set<Position> union = new HashSet<>();
				// add positions of the current player to union
				union.addAll(positions);
				// get the union of positions of the current player and tempPlayer
				union.retainAll(positionsTemp);
				// copy the position in the union to positionToWeight
				Iterator<Position> itr = union.iterator();
				while(itr.hasNext()) {
					Position temp = itr.next();
					if (positionToWeight.containsKey(temp)) { // if the position exist in the map, add 1 to the weight
						positionToWeight.put(temp, positionToWeight.get(temp) + 1);
					} else { // if the position does not exists, create a new one, at least two players share the same position
						positionToWeight.put(temp, 2);
					}
				}
			}
			
		}
	}
	
	// Stores the sixteen position of the given player in a set for comparison
	private Set<Position> getPositonByName(String name) {
		
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
	
	// Produces the word every time the user drag their mouse
	public String getWord(List<Cell> cellList) {
		
		String s = "";
		for (int i = 0; i < cellList.size(); i++) {
			
			Cell cell = cellList.get(i);
			s += cell.getLetter();
		}
		return s;
	}
	
	// the score of one letter is POW(2, m) * WEIGHT * BONUS, m is the number of people share this letter
	// then produce the word score by adding up the score in each letter, if the length of this word is larger
	// than 3, the the final score should be POW(2, n) * wordScore, n is the length of the word
	public long computeScore(List<Cell> cellList) {
		
		long score = 0;
		for (int i = 0; i < cellList.size(); i++) {
				
			Cell cell = cellList.get(i);
			String letter = cell.getLetter();
			// transform the local position to global
			Position globalPosition = cell.getPosition().localToGlobal(player.getGlobalPosition());
			
		//	word += cell.getLetter();
			int sharedAreaMutiply = 1;
			int bonusMutiply = 1;
			if (positionToWeight.containsKey(globalPosition)) {
				
				sharedAreaMutiply  = positionToWeight.get(globalPosition);
			}
			
			if (globalPosition.equals(bonus)) {
				
				bonusMutiply = 10;
			}
			
			score += Word.WEIGHT.get(letter) * sharedAreaMutiply * bonusMutiply;
		}
		
		// if the length of the letter is larger than 3, then multiply the total score by POW(2, wordLength) * 10
		if (cellList.size() >= 3) {
			score *= 10 * Math.pow(2, cellList.size());
		}
		
		return score;
	
	}
	
	
}
