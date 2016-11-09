/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

StartPratice.java : implementation file 
This is a control class to practice.

History:
7 Oct, 2016	--- Zhe Lyu @1
- Created.

*****************************************************************/

package client.controller;

import client.model.*;
import client.view.*;

public class StartPraticeController {
	Application app;
	GameRoom model;
    
    public StartPraticeController(Application app, GameRoom model) {
		
		this.app = app;
		this.model = model;
		
	}
	
	// Creates a flame when user press practice button 
	public void process() {
		
		BoardDisplay frame = new BoardDisplay(app, model);
		    //frame.setLayout(null);
		    //frame.setBounds(500, 100, 800, 800);
		    frame.setVisible(true);
	}
}
