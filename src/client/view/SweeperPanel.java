/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

SweeperPanel.java : implementation file
This is a view class for creating the game board panel control

History:
7 Oct, 2016	--- Bing Zhao @1
- Created.

*****************************************************************/

package client.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import client.controller.DragControl;
import client.model.DrawBoardModel;
import client.model.GameRoom;
import client.model.Player;
import client.model.Position;


public class SweeperPanel extends JPanel{
	
	private static final int SIZE = 4;
	private DrawBoardModel model;
	private GameRoom gameRoom;
	private DragControl control;
	private Map<Position, Integer> positionToWeight;
	
	int dlgWidth;
	int dlgHeight;
	
	
	
	public SweeperPanel(Application app, GameRoom m) {
		gameRoom = m;
		model = m.getDrawModel();
		positionToWeight = m.getPositionToWeight();
        control = new DragControl(this, m, app);
		this.addMouseListener(control);
		this.addMouseMotionListener(control);
		
		dlgWidth  =864;
		dlgHeight =576;
		
	}
	
	public String getLastSelectedWord()
	{
		return control.getlSelectedWord();
	}
	
	public long getLastSelectedScore()
	{
		return control.getlSelectedScore();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		
		ImageIcon icon =new ImageIcon("src\\client\\res\\bk2.jpg");
		//icon.setImage(icon.getImage().getScaledInstance(test.WIDTH,test.HEIGHT,Image.SCALE_DEFAULT));
		
		Image img=icon.getImage();
	    g.drawImage(img, 0, 0, icon.getIconWidth(),icon.getIconHeight(),this);
	        
		
		int magin = 10;
		
		g.setColor(Color.red);
		//draw board outline
		for (int i = 0; i <= SIZE; i++) {
		   
		   Point hLineNode = model.getHorizenLine(i);
		   g.drawLine(hLineNode.x, hLineNode.y, hLineNode.x + model.getBoardSize(), hLineNode.y);
		   
		   Point vLineNode = model.getVerticalLine(i);
		   g.drawLine(vLineNode.x, vLineNode.y, vLineNode.x, vLineNode.y + model.getBoardSize());
		}
		
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				
				List<String> list = new ArrayList<String>();
				list = model.getSelCellList();
				Position position = new Position(row, col);
				
				int weight=1;
				if (positionToWeight.containsKey(position))
				    weight = positionToWeight.get(position);
				
				String ss;
		    	ss = String.format("%d%d", row, col);
		    	
				
				if(list.contains(ss)) // the cell is selected 
				{
					//System.out.println("paint0"+ss + "  ");
					g.setColor(Color.yellow);
				}
				else                  // the cell is not selected
				{
					if(weight<14)
			            g.setColor(new Color(255,255-(weight-1)*20,255-(weight-1)*20));
					else
						g.setColor(new Color(255,10,10));
				}
				
				Point cellLt = model.getCellLt(row, col);
				g.fillRect(cellLt.x, cellLt.y, model.getCellSize(), model.getCellSize());
			
				
				g.setColor(Color.black);
				
				// Set the letter's size to be cellSize - magin - 30 
				g.setFont(new Font("Arial", Font.PLAIN, model.getCellSize() - magin - 30));
				String s = gameRoom.getDrawModel().getCellLetter(row, col);
			    
				// Sets the baseline of the string to be point(cellLt.x + magin + 5, 
				// cellLt.y + model.cellSize - magin - 5)
				g.drawString(s, cellLt.x + magin + 5, cellLt.y + model.getCellSize() - magin - 5);
			}
		}	
		
		Point xStart = model.getHorizenLine(0);
		
		g.setColor(Color.black);
		g.setFont(new Font("Black", Font.PLAIN, 18));
		
		//total score
		g.setFont(new Font("Yellow", Font.BOLD, 28));
		
		if(gameRoom.getGameMode()==false)
		g.drawString("Total Score: "+ gameRoom.getPlayer().getScore(), xStart.x, xStart.y-25-35);
		
		//selected word
		g.drawString("Word: " +getLastSelectedWord()+"    Score:"+ String.format("%s",getLastSelectedScore()) , xStart.x, xStart.y-25);
		
		//player and room ID
		g.setFont(new Font("Black", Font.BOLD, 20));
		g.drawString("ROOM: "+ gameRoom.getGameId(), dlgWidth-270, 30);
		g.drawString("PLAYER: "+gameRoom.getCurrentPlayerName(), dlgWidth-270, 60);
		
		
		//player list
		g.drawString("PLAYER LIST:", 400, xStart.y+50);
		String strPlayList;
		List<Player> players = gameRoom.getPlayerList();
		g.drawLine(400-5, xStart.y+65, 600, xStart.y+70);
		

		int y= xStart.y+50;
		g.setFont(new Font("Black", Font.BOLD, 15));
				
		for(int i=0; i<players.size();i++)
		{
			String isManager;
			if(players.get(i).isManager())
				isManager ="Manager=Yes";
			else
				isManager ="Manager=No";
			
		   y+=35;
		   strPlayList=String.format("%s  %d  %s",players.get(i).getName(),players.get(i).getScore(),isManager);
		   g.drawString(strPlayList, 400, y);
		   g.drawLine(400-5, y+10, 600, y+10);
		}
		
	
		
		
	}
	

}
