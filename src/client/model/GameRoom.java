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
	private DrawBoardModel drawModel;
	private String gameId;
	private boolean locked; 
	private List<Player> players; 
	private String password; 
	private Board board;
	private Map<String, Player> findPlayerByName; 
	private Map<String, Integer> findScoreByName;
	private Position bonus;
	
	public GameRoom(String gameId, String password) {
		
		this.password = password;
		players = new ArrayList<Player>();
		findPlayerByName = new HashMap<String, Player>();
		findScoreByName = new HashMap<String, Integer>();
		bonus = null;
		this.gameId = gameId;
		locked = false; 
		drawModel = new DrawBoardModel();
	}
	
	// Returns the managing player
	public Player getManagingPlayer() {
		
		return null;
	}
	
	
	public DrawBoardModel getDrawModel() {
		return drawModel;
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
	
	public boolean addPlayer(String name, String sixteenLetter, String globalPosition, boolean isManager) {
		Player player = new Player(name, sixteenLetter, globalPosition, isManager);
		findPlayerByName.put(name, player);
		return players.add(player);
	}
	
	
	public boolean removePlayer(Player player) {
		findPlayerByName.remove(player.getName());
		return players.remove(player);
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
	
	public void setBonus(String bonus) {
		this.bonus = new Position(Integer.parseInt("" + bonus.charAt(0)), 
				                  Integer.parseInt("" + bonus.charAt(2)));
	
	}
	
	public Map<Position, Integer> computeSharedArea(String name) {
		
		if (findPlayerByName.get(name) == null) {
			throw new IllegalArgumentException();
		
		}
		// store the sixteen position of the given player in a set for comparison
		Set<Position> positions = getPositonByName(name);
		
		Set<Position> union = new HashSet<>();
		Map<Position, Integer> positionToWeight = new HashMap<>();
		
		for (int i = 0; i < players.size(); i++) {
			
			if (!players.get(i).getName().equals(name)) { // avoid name repetition
				Set<Position> positionsTemp = getPositonByName(name);
				// add positions of the given player to union
				union.addAll(positions);
				// get the union of positions of the given player and players.get(i)
				union.retainAll(positionsTemp);
				// copy the position in the union to positionToWeight
				Iterator<Position> itr = union.iterator();
				while(itr.hasNext()) {
					Position temp = itr.next();
					if (positionToWeight.containsKey(temp)) { // if the position exist in the map, add 1 to the weight
						positionToWeight.put(temp, positionToWeight.get(temp) + 1);
					} else { // if the position does not exists, create a new one
						positionToWeight.put(temp, 1);
					}
				}
				union.clear(); // clear union for next use
			}
			
		}
		return positionToWeight;
	}
	
	private Set<Position> getPositonByName(String name) {
		
		Position globalPosition = findPlayerByName.get(name).getGlobalPosition();
		int row = globalPosition.getRow();
		int col = globalPosition.getColumn();
		
		// store the sixteen position of the given player in a set for comparison
		Set<Position> positions = new HashSet<>();
		
		for (int i = row; i < row + 4; i++) {
			for (int j = col; j < col + 4; j++) {
				positions.add(new Position(i, j));
			}
		}
		return positions; 
		
	}
	 
	
	
}
