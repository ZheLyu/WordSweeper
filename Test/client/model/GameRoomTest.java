package client.model;

import java.util.*;

import junit.framework.TestCase;

public class GameRoomTest extends TestCase {

	GameRoom GameRoom = new GameRoom("somePlace");
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGameRoom() {
		//fail("Not yet implemented");
		GameRoom GameRoom = new GameRoom("somePlace");
	}

	public void testGetManagingPlayer() {
		fail("Not yet implemented");
	}

	public void testSetCurrentPlayerName() {
		fail("Not yet implemented");
	}

	public void testBoardResponseHandler() {
		//fail("Not yet implemented");
		
		String managingUser = "george";
		String bonus = "4,3";
		String[] names = {"george", "nextOne"};
		String[] positions = {"1,1","1,1"};
		String[] board = {"QuWERTYUIOPLKJHGF", "MLPOKNJIUHBVGYTF"};
		//String[] board = {"QWERTYUIOPLKJHGF", "MLPOKNJIUHBVGYTF"};
		
		long[] scores = {0,30};
		
		String[] names1 = {"george"};
		String[] positions1 = {"1,1"};
		String[] board1 = {"QuWERTYUIOPLKJHGF"};
		//String[] board1 = {"QWERTYUIOPLKJHGF"};
		long[] scores1 = {0};
		
		String[] names2 = {"george","somePlayer", "nextOne"};
		String[] positions2 = {"1,1","1,1","3,3"};
		String[] board2 = {"QuWERTYUIOPLKJHGF", "MLPOKNJIUHBVGYTF","MLPOKNJIUHBVGYTF"};
		long[] scores2 = {0,30,0};
		
		System.out.println(names.length);
		//GameRoom.setCurrentPlayerName(managingUser);
		
		GameRoom.boardResponseHandler(managingUser, bonus, names1, positions1, board1, scores1);
		
		String name1 = GameRoom.getPlayer().getName();
		
		assertEquals("george", name1);
		System.out.println(name1);
		//GameRoom.boardResponseHandler(managingUser, bonus, names, positions, board, scores);
		GameRoom.setCurrentPlayerName(managingUser);
		GameRoom.boardResponseHandler(managingUser, bonus, names, positions, board, scores);
		
		List<Player> players = GameRoom.getPlayerList();
		
		assertEquals("george", players.get(0).getName());
				
		assertEquals("nextOne", players.get(1).getName());
		
		GameRoom.boardResponseHandler(managingUser, bonus, names2, positions2, board2, scores2);
		GameRoom.setGameMode(false);
		GameRoom.getPositionToWeight();
		
		
	}

	public void testGetPlayer() {
		fail("Not yet implemented");
	}

	public void testGetPlayerList() {
		fail("Not yet implemented");
	}

	public void testFindWordResponseHandler() {
		fail("Not yet implemented");
	}

	public void testGetDrawModel() {
		fail("Not yet implemented");
	}

	public void testSetGameId() {
		fail("Not yet implemented");
	}

	public void testGetGameId() {
		fail("Not yet implemented");
	}

	public void testSetLocked() {
		fail("Not yet implemented");
	}

	public void testIsLocked() {
		fail("Not yet implemented");
	}

	public void testFindPlayerByName() {
		fail("Not yet implemented");
	}

	public void testGetPassword() {
		fail("Not yet implemented");
	}

	public void testSetPassword() {
		fail("Not yet implemented");
	}

	public void testGetPositionToWeight() {
		//fail("Not yet implemented");
		
		Map<Position, Integer> positionToWeight = new HashMap<Position, Integer>();
		GameRoom.getPositionToWeight();
		
	}

	public void testGetWord() {
		fail("Not yet implemented");
		
		//GameRoom.getWord(cellList);
	}

	public void testGetPosition() {
		fail("Not yet implemented");
	}

	public void testGetLetter() {
		fail("Not yet implemented");
	}

	
	public void testComputeScore() {
		//fail("Not yet implemented");
		Position position1 = new Position(0,0);
		Position position2 = new Position(1,0);
		Position position3 = new Position(2,0);
		Position position4 = new Position(3,0);
		Position position5 = new Position(0,1);
		Position position6 = new Position(1,1);
		Position position7 = new Position(2,1);
		Position position8 = new Position(3,1);
		Position position9 = new Position(0,2);
		Position position10 = new Position(1,2);
		Position position11 = new Position(2,2);
		Position position12 = new Position(3,3);
		Position position13 = new Position(0,3);
		Position position14 = new Position(1,3);
		Position position15 = new Position(2,3);
		Position position16 = new Position(3,3);
		//Position position17 = new Position(3,0);
		
		
		Cell element1 = new Cell(position1,"Qu");
		Cell element2 = new Cell(position2,"W");
		Cell element3 = new Cell(position3,"E");
		Cell element4 = new Cell(position4,"R");
		
		Cell element5 = new Cell(position5,"T");
		Cell element6 = new Cell(position6,"Y");
		Cell element7 = new Cell(position7,"U");
		Cell element8 = new Cell(position8,"I");
		Cell element9 = new Cell(position9,"O");
		Cell element10 = new Cell(position10,"P");
		Cell element11 = new Cell(position11,"L");
		Cell element12 = new Cell(position12,"K");
		Cell element13 = new Cell(position13,"J");
		Cell element14 = new Cell(position14,"H");
		Cell element15 = new Cell(position15,"G");
		Cell element16 = new Cell(position16,"F");
		
		List<Cell> cellList = new ArrayList<Cell>() ;
		cellList.add(0, element1);
		cellList.add(1, element2);
		cellList.add(2, element3);
		cellList.add(3, element4);
//		cellList.add(4, element5);
//		cellList.add(5, element6);
//		cellList.add(6, element7);
//		cellList.add(7, element8);
//		cellList.add(8, element9);
//		cellList.add(9, element10);
//		cellList.add(10, element11);
//		cellList.add(11, element12);
//		cellList.add(12, element13);
//		cellList.add(13, element14);
//		cellList.add(14, element15);
//		cellList.add(15, element16);
		
		
		String s = GameRoom.getDrawModel().getWord(cellList);
		
		assertEquals("QuWER", s);
		
		System.out.println("Got the word "+s);
		
		String[] names1 = {"george"};
		String[] positions1 = {"1,1"};
		//String[] board1 = {"QWERTYUIOPLKJHGF"};
		String[] board1 = {"QuWERTYUIOPLKJHGF"};
		long[] scores1 = {0};
		String managingUser = "george";
		String bonus = "4,3";
		
		GameRoom.boardResponseHandler(managingUser, bonus, names1, positions1, board1, scores1);
		
		long grade = GameRoom.computeScore(cellList);
		
		assertEquals(2720, grade);
		
		System.out.println("The score is "+grade);
		
		String bonus1 = "1,1";
		
		//String bonus2 = ",";
		
		GameRoom.boardResponseHandler(managingUser, bonus, names1, positions1, board1, scores1);
		GameRoom.boardResponseHandler(managingUser, bonus1, names1, positions1, board1, scores1);
		//GameRoom.boardResponseHandler(managingUser, bonus2, names1, positions1, board1, scores1);
		
		GameRoom.setGameMode(false);
		
		GameRoom.computeScore(cellList);
		
		List<Cell> cellList1 = new ArrayList<Cell>();
		cellList1.add(0, element1);
		cellList1.add(1, element2);
		GameRoom.computeScore(cellList1);
		
		String[] names2 = {"george","somePlayer", "nextOne"};
		String[] positions2 = {"1,1","1,1","3,3"};
		String[] board2 = {"QuWERTYUIOPLKJHGF", "QuWERTYUIOPLKJHGF","MLPOKNJIUHBVGYTF"};
		long[] scores2 = {0,30,0};
		
		GameRoom.boardResponseHandler(managingUser, bonus, names2, positions2, board2, scores2);
		
		GameRoom.computeScore(cellList1);
		
	}

}
