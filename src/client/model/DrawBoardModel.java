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
	private List<Cell> selCellList2;
	private Board board;
	
	public DrawBoardModel() {
		
		origin = new Point();
		point = new Point();
		oldSelPoint = new Point();
	
		board = null;
		
		oldSelPoint.x = -1;
		oldSelPoint.y = -1;
		
		
		origin.x = 50;
		origin.y = 150;
		
		size = 280;
		cellSize = size / 4 - 2;
		
		selCellList = new ArrayList<String>();
		selCellList2 = new ArrayList<Cell>();
	}
	
	public void setBoard(Board board) { 
		
		this.board = board;
	}
	
	public Board getBoard() {
		
		return board;
	}
	
    public List<String> getSelCellList() {
		
		return selCellList;
	}
    
    public void clearSelCellList() {
    	
    	selCellList.clear();
    	selCellList2.clear();
    }
    
    public int getSelCellListSize(){
    	return selCellList.size();
    }
    
    public List<Cell> getSelCellList2() {
    	
    	return selCellList2;
    }

    
    public void addDragCellList(Point p) {
    	
    	String s;
    	
    	s = String.format("%d%d", (p.y - origin.y + 1) / (size / 4), (p.x - origin.x + 1) / (size / 4));
    	int col = (p.x - origin.x + 1) / (size / 4);
    	int row = (p.y - origin.y + 1) / (size / 4);
    	
    	if(col>3 || row>3)
    		return;
    	
    	
    	//skip area out of (0.2,0.8) 
    	if((p.x - origin.x + 1)%(size / 4)<(0.2*size/4) || 
    		(p.x - origin.x + 1)%(size / 4)>(0.8*size/4) ||
    		(p.y - origin.y + 1) %(size / 4)<(0.2*size/4)||
    		(p.y - origin.y + 1) %(size / 4)>(0.8*size/4))
    	{
    		
    		return;
    	}
    	
        if(selCellList2.size() >0)
        {
	    	int lastRow=selCellList2.get(selCellList2.size()-1).getPosition().getRow();
	    	int lastCol=selCellList2.get(selCellList2.size()-1).getPosition().getColumn();
	    	
	    	if(col!=lastCol+1 && col!=lastCol-1 && col!=lastCol)
	    		return;
	    	
	    	if(row!=lastRow+1 && row!=lastRow-1 && row!=lastRow)
	    		return;
        }
  
          	
		Position position = new Position(row, col);
        if(!selCellList.contains(s)) {
          	
        	selCellList.add(s);
        	selCellList2.add(new Cell(position, getCellLetter(row, col)));
          //  System.out.println(s);
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
	   
		return board.getPositionLetter(row, col);
		
	}
	
	public int getBoardSize()
	{
		return size;
	
	}
	
	public int getCellSize()
	{
		return cellSize;
	
	}

	
	public String getWord(List<Cell> cellList) {
		
		String s = "";
		for (int i = 0; i < cellList.size(); i++) {
			
			Cell cell = cellList.get(i);
			s += cell.getLetter();
		}
		
		return s.toLowerCase();
	}
	
	
	
}
