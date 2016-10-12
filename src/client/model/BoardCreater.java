package client.model;
import java.awt.Point;
import java.util.ArrayList;


public class BoardCreater {
	
	private Point origin;
	//private Point cellLt;
	
	private Point point;
	private Point oldSelPoint; 
	
	public int size;
	public int cellSize;
	ArrayList<String> selCellList;
	private Board board;
	
	public BoardCreater() {
		
		origin = new Point();
		point = new Point();
		oldSelPoint = new Point();
		board = new Board();
		
		oldSelPoint.x=-1;
		oldSelPoint.y=-1;
		
		
		origin.x = 50;
		origin.y = 50;
		size = 360;
		cellSize = size / 4 - 2;
		
		selCellList = new ArrayList<String>();
	}
	
	
    public ArrayList<String>getSelCellList(){
		
		return selCellList;
	}
    
    public void clearSelCellList() {
    	
    	selCellList.clear();
    }

    
    public void addDragCellLIst(Point p)
    {
    	String s;
    	s=String.format("%d%d", (p.y-origin.y+1)/(size/4),(p.x-origin.x+1)/(size/4));
		
        if(!selCellList.contains(s)) {
          	
        	selCellList.add(s);
          	System.out.println(s);
        }   	
        
    }
	
	public Point getHorizenLine(int rowId)
	{
		point.x=origin.x;
		point.y=origin.y+rowId*size/4;   //4x4
		
		return point;
	}
	
	public Point getVerticalLine(int colId)
	{
		point.y = origin.y;
		point.x = origin.x+colId*size/4;   //4x4
		
		return point;
	}
	
	public Point getCellLt(int row, int col) {
		
		point.x = origin.x+col*size/4+1;
		
		point.y = origin.y+row*size/4+1;
		
		return point;
	
	}
	
	public String getCellLetter(int row, int col) {
	   
		return board.getPositionLetter(col, row);
		
	}
	
	
	public Point getCellIndex(Point p) {
		
		point.y = (p.x-origin.x+1)/(size/4);
		point.x = (p.y-origin.y+1)/(size/4);
		
		return point;
	}
	
	
}
