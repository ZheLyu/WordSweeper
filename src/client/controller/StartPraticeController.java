package client.controller;


import javax.swing.JFrame;

import client.model.Model;
import client.view.TryApplication;

public class StartPraticeController {
	TryApplication app;
	Model model;
	
	public  StartPraticeController(TryApplication app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public void process() {
		 JFrame frame = new JFrame("title2");
		    frame.setLayout(null);
		    frame.setBounds(20, 20, 300, 100);
		    frame.setVisible(true);
	}
}
