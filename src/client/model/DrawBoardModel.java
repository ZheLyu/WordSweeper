package client.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class DrawBoardModel {


	private Point origin;     // The origin point of the 4 by 4 board
	//private Point cellLt;
	
	private Point point;
	private Point oldSelPoint; 
	
	private int size;
	private int cellSize;
	
	private List<String> selCellList; // store the selected cells
	private Board board;
	
	public DrawBoardModel() {
		
		origin = new Point();
		point = new Point();
		oldSelPoint = new Point();
		board = new Board();
		
		oldSelPoint.x = -1;
		oldSelPoint.y = -1;
		
		
		origin.x = 50;
		origin.y = 50;
		
		size = 400;
		cellSize = size / 4 - 2;
		
		selCellList = new ArrayList<String>();
	}
	
	
    public List<String> getSelCellList() {
		
		return selCellList;
	}
    
    public void clearSelCellList() {
    	
    	selCellList.clear();
    }
    
    public int getSelCellListSize(){
    	return selCellList.size();
    }

    
    public void addDragCellList(Point p) {
    	
    	String s;
    	s = String.format("%d%d", (p.y - origin.y + 1) / (size / 4), (p.x - origin.x + 1) / (size / 4));
		
        if(!selCellList.contains(s)) {
          	
        	selCellList.add(s);
            System.out.println("fuck you" + s);
        }   	
        
    }
	
	public Point getHorizenLine(int rowId) {
		
		point.x = origin.x;
		point.y = origin.y + rowId * size / 4;   //4x4
		
		return point;
	}
	
	public Point getVerticalLine(int colId) {
		
		point.x = origin.x + colId * size / 4;   //4x4
		point.y = origin.y;
		return point;
	}
	
	//get cell left top point
	public Point getCellLt(int row, int col) {
		
		point.x = origin.x + col * size / 4 + 1;	
		point.y = origin.y + row * size / 4 + 1;
		
		return point;
	
	}
	
	public String getCellLetter(int row, int col) {
	   
		return board.getPositionLetter(col, row);
		
	}
	
	public int getBoardSize()
	{
		return size;
	
	}
	
	public int getCellSize()
	{
		return cellSize;
	
	}
	
	
	
}
