package client.controller;

import client.model.*;
import client.view.*;

public class StartPraticeController {
	Application app;
	Model model;
    Model m;
	public StartPraticeController(Application app, Model model) {
		
		this.app = app;
		this.model=model;
		m=new Model();
	}
	
	public void process() {
		
		BoardDisplay frame = new BoardDisplay(m);
		    //frame.setLayout(null);
		    frame.setBounds(500, 100, 800, 800);
		    frame.setVisible(true);
	}
}
