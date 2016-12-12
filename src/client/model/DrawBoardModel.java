package client.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * This class provides useful methods to draw 4 * 4 board
 *
 */
public class DrawBoardModel {

	/**
	 * The origin point of the 4 * 4 board
	 */
	private Point origin;     // The origin point of the 4 by 4 board
	//private Point cellLt;
	
	private Point point;
	/**
	 * an attribute used for debug
	 */
	private Point oldSelPoint; 
	/**
	 * 
	 * The size of the 4 * 4 board 
	 */
	private int size;
	
	/**
	 * The cell size of the 4 * 4 board
	 */
	private int cellSize;
	/**
	 *  Stores the selected cells, based on type of string
	 */
	private List<String> selCellList; 
	/**
	 * Stores the selected cells based on type of cell 
	 */
	private List<Cell> selCellList2;
	
	/**
	 * Used to get the letters in the board
	 */
	private Board board;
	
	/**
	 * Initialize several points used for drawing board
	 */
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
	/**
	 * Sets the board 
	 * @param board
	 */
	public void setBoard(Board board) { 
		
		this.board = board;
	}
	/**
	 * Returns the board
	 * @return
	 */
	public Board getBoard() {
		
		return board;
	}
	/**
	 * Returns the list of cells 
	 * @return
	 */
    public List<String> getSelCellList() {
		
		return selCellList;
	}
    /**
     * Clears the selected cell list 
     */
    public void clearSelCellList() {
    	
    	selCellList.clear();
    	selCellList2.clear();
    }
    
   /**
    * Returns the size of cell list
    * @return
    */
    public int getSelCellListSize(){
    	return selCellList.size();
    }
    
    /**
     * Returns the list of cells 
     * @return
     */
    public List<Cell> getSelCellList2() {
    	
    	return selCellList2;
    }
    
    /**
     * Adds the selected point to the cell lists, interact with class with drag control in controller class
     * @param p
     */
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
	/**
	 * Returns the horizon line based on the row id 
	 * @param rowId
	 * @return
	 */
	public Point getHorizenLine(int rowId) {
		
		point.x = origin.x;
		point.y = origin.y + rowId * size / 4;   //4x4
		
		return point;
	}
	/**
	 * Returns the point of vertical line based on column id 
	 * @param colId
	 * @return
	 */
	public Point getVerticalLine(int colId) {
		
		point.x = origin.x + colId * size / 4;   //4x4
		point.y = origin.y;
		return point;
	}
	/**
	 * Get cell left top point
	 * @param row
	 * @param col
	 * @return
	 */
	public Point getCellLt(int row, int col) {
		
		point.x = origin.x + col * size / 4 + 1;	
		point.y = origin.y + row * size / 4 + 1;
		
		return point;
	
	}
	
	/**
	 * Returns a letter in the board based on the given row and column
	 * @param row
	 * 		  row 
	 * @param col 
	 * 		  column
	 * @return 
	 */
	public String getCellLetter(int row, int col) {
	   
		return board.getPositionLetter(row, col);
		
	}
	
	/**
	 * Returns the size of the board
	 * @return 
	 */
	public int getBoardSize() {
		return size;
	
	}
	/**
	 * Return the size of cell
	 * @return
	 */
	public int getCellSize() {
		
		return cellSize;
	
	}

	/**
	 * Returns the word the user selects
	 * @param cellList gather the selected cell 
	 * @return
	 */
	public String getWord(List<Cell> cellList) {
		
		String s = "";
		for (int i = 0; i < cellList.size(); i++) {
			
			Cell cell = cellList.get(i);
			s += cell.getLetter();
		}
		
		return s.toLowerCase();
	}
	
	
	
}
