package client.controller;

import client.model.*;
import client.view.*;

public class StartPraticeController {
	Application app;
	Model model;
	BoardCreater boardCreater;
	
	public  StartPraticeController(Application app, Model model) {
		this.app = app;
		this.model = model;
		boardCreater = new BoardCreater();
	}
	
	public void process() {
		BoardDisplay frame = new BoardDisplay(boardCreater);
		    //frame.setLayout(null);
		    frame.setBounds(500, 100, 800, 800);
		    frame.setVisible(true);
	}
}
