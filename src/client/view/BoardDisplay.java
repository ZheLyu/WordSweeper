/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

BoardDisplay.java : implementation file
This is a view class for creating the game board page.

History:
7 Oct, 2016	--- Bing Zhao @1
- Created.

*****************************************************************/



package client.view;

import javax.swing.JFrame;

import client.model.Model;

public class BoardDisplay extends JFrame {
	
	 SweeperPanel panel;
     Model model;
     
	/**
	 * Create the frame.
	 */
	public BoardDisplay(Model m) {
		//getContentPane().setBackground(Color.YELLOW);
		//setBounds(100, 100, 577, 499);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		model = m;
		panel = new SweeperPanel(m);
		//getContentPane().add(panel, BorderLayout.WEST);
		//panel.setLayout(null);
		this.add(panel);
		
	}
	

}
