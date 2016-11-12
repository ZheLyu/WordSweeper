package client.controller;

import xml.Message;
import junit.framework.TestCase;

public class BoardResponseControllerTest extends TestCase {

	protected void setUp() throws Exception {
		
		if (!Message.configure("wordsweeper.xsd")) {
			fail ("unable to configure protocol");
		}
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBoardResponseController() {
		fail("Not yet implemented");
	}

	public void testProcess() {
		fail("Not yet implemented");
	}

}
