package client.model;

import java.util.Random;

import junit.framework.TestCase;

public class CellTest extends TestCase {
	
	private static final String[] ALPHABET = {"A", "B", "C", "D", "E", "F", "G", "H", "I", 
            "J", "K", "L", "M", "N", "O", "P", "Qu", "R", 
            "S", "T", "U", "V", "W", "X", "Y", "Z"};

	Random r = new Random();
	int random = r.nextInt(26);
	
	protected void setUp() throws Exception {
		super.setUp();
		
		
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCell() {
		//fail("Not yet implemented");
		Cell cell = new Cell(new Position(6, 4), ALPHABET[random]);
		
		cell.getPosition();
		System.out.println(cell.toString());
		cell.getLetter();
	}



}
