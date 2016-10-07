package client.view;

import javax.swing.JFrame;

import client.model.BoardCreater;

public class BoardDisplay extends JFrame{
	
	 SweeperPanel panel;
     BoardCreater model;
     
	/**
	 * Create the frame.
	 */
	public BoardDisplay(BoardCreater m) {
		//getContentPane().setBackground(Color.YELLOW);
		//setBounds(100, 100, 577, 499);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model = m;
		
		panel = new SweeperPanel(m);
		//getContentPane().add(panel, BorderLayout.WEST);
		//panel.setLayout(null);
		this.add(panel);
		
	}
	

}
