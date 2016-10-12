package client.controller;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;


import client.model.Model;
import client.view.*;


public class DragControl implements MouseInputListener{
	
	private SweeperPanel panel; 
	private Model model;

	
	
	// int x0 = 0;     
    // int y0 = 0; 
	
	public DragControl(SweeperPanel panel, Model m) {
		// TODO Auto-generated constructor stub
		this.panel = panel;
		model = m;
		
	}
	
	public void mouseDragged(MouseEvent arg0){
	      
		model.addDragCellList(arg0.getPoint());
        panel.repaint();
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//panel.repaint();
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		panel.repaint();
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		model.clearSelCellList();
		panel.repaint();
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
