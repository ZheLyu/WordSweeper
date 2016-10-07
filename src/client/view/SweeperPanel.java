package client.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

import client.controller.DragControl;
import client.model.BoardCreater;




public class SweeperPanel extends JPanel{
	
	BoardCreater model;
	
	DragControl control;
	
	public SweeperPanel (BoardCreater m) {
		
		model =m;
		
        control = new DragControl(this, model);
		
		this.addMouseListener(control);
		this.addMouseMotionListener(control);
		
	
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int magin=20;
		
		g.setColor(Color.red);
		
		//draw board outline
		for(int i=0;i<5;i++)
		{
		   Point hLineNode = model.getHorizenLine(i);
		   g.drawLine(hLineNode.x,hLineNode.y,hLineNode.x+model.size,hLineNode.y);
		   
		   Point vLineNode = model.getVerticalLine(i);
		   g.drawLine(vLineNode.x,vLineNode.y,vLineNode.x,vLineNode.y+model.size);
		}
	
		
		
		//
		for(int row=0;row<4;row++)
		{
			for(int col=0;col<4;col++)
			{
				ArrayList<String> list =new ArrayList<String>();
				list=model.getSelCellList();
			
				String ss;
		    	ss=String.format("%d%d", row,col);
				
				if(list.contains(ss))
					g.setColor(Color.yellow);
				else
					g.setColor(Color.white);
				
				Point cellLt = model.getCellLt(row, col);
				g.fillRect(cellLt.x, cellLt.y, model.cellSize, model.cellSize);
			
				g.setColor(Color.black);
				g.setFont(new Font("Arial",Font.PLAIN,model.cellSize-magin));
				String s=model.getCellLetter(row, col);
				g.drawString(s, cellLt.x+magin, cellLt.y+model.cellSize-magin);
			}
		}
		
		
		
	
		
	}
	

}
