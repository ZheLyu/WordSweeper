package client.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

import client.controller.DragControl;
import client.model.Model;

public class SweeperPanel extends JPanel{
	
	private static final int SIZE = 4;
	private Model model;
	private DragControl control;
	
	
	public SweeperPanel(Model m) {
		
		model = m;
        control = new DragControl(this, model);
		this.addMouseListener(control);
		this.addMouseMotionListener(control);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int magin = 15;
		
		g.setColor(Color.red);
		
		//draw board outline
		for (int i = 0; i <= SIZE; i++) {
		   
		   Point hLineNode = model.getHorizenLine(i);
		   g.drawLine(hLineNode.x, hLineNode.y, hLineNode.x + model.size, hLineNode.y);
		   
		   Point vLineNode = model.getVerticalLine(i);
		   g.drawLine(vLineNode.x, vLineNode.y, vLineNode.x, vLineNode.y + model.size);
		}
	
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				
				ArrayList<String> list = new ArrayList<String>();
				list = model.getSelCellList();
			
				String ss;
		    	ss = String.format("%d%d", row, col);
				
				if(list.contains(ss)) // the cell is selected 
					g.setColor(Color.yellow);
				else                  // the cell is not selected
					g.setColor(Color.white);
				
				Point cellLt = model.getCellLt(row, col);
				g.fillRect(cellLt.x, cellLt.y, model.cellSize, model.cellSize);
			
				g.setColor(Color.black);
				
				// Set the letter's size to be cellSize - magin - 30 
				g.setFont(new Font("Arial", Font.PLAIN, model.cellSize - magin - 30));
				String s = model.getCellLetter(row, col);
			    
				// Sets the baseline of the string to be point(cellLt.x + magin + 5, 
				// cellLt.y + model.cellSize - magin - 5)
				g.drawString(s, cellLt.x + magin + 5, cellLt.y + model.cellSize - magin - 5);
			}
		}	
	}
	

}
