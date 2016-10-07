package client.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;


import client.model.BoardCreater;
import client.view.*;


public class DragControl implements MouseInputListener{
	
	SweeperPanel panel; 
	BoardCreater model;
	Point point;
	
	
	 int x0 = 0;     
     int y0 = 0; 
	

	
	public DragControl(SweeperPanel panel2, BoardCreater m) {
		// TODO Auto-generated constructor stub
		this.panel=panel2;
		model=m;
		
		
	}
	
	

	public void mouseDragged(MouseEvent arg0){
	      
		model.addDragCellLIst(arg0.getPoint());
		
        panel.repaint();
        	
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		model.clearSelCellList();
		
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
