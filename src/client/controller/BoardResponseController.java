/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

BoardResponseController.java : implementation file
This is a controller class for checking whether the game has been locked or not.
History:

*****************************************************************/

package client.controller;

import javax.sound.midi.MidiDevice.Info;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.Message;
import client.model.GameRoom;
import client.view.Application;

/**
 * Tells the client whether the model is locked or not BY SOME OTHER CLIENT. This will never be returned to a client
 * to tell him that HE has the model locked (that is job of LockResponse).
 */
public class BoardResponseController extends ControllerChain {

	public Application app;
	public GameRoom model;
	
	public BoardResponseController(Application a, GameRoom m) {
		super();
		this.app = a;
		this.model = m;
	}
	
	public boolean process(Message response) {
		
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("boardResponse")) {
		//	System.out.println("is not board response response");
			return next.process(response);
		}
	//	System.out.println("!!in board response " + response.toString());
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
	//	int size = Integer.valueOf(map.getNamedItem("size").getNodeValue());
		String managingUser = map.getNamedItem("managingUser").getNodeValue();
		String bonus = map.getNamedItem("bonus").getNodeValue();
	
	//	String content=map.getNamedItem("content").getNodeValue();
		String gameId = map.getNamedItem("gameId").getNodeValue();
		model.setGameId(gameId);
		//app.getResponseArea().append("Board Message received for game:" + gameId + "\n");
		//app.getResponseArea().append("Players:\n");
		
		
		NodeList list = boardResponse.getChildNodes();
		//System.out.println(list.getLength());
		String[] name= new String[list.getLength()];
		String[] position= new String[list.getLength()];
		String[] board= new String[list.getLength()];
		long[] s= new long[list.getLength()];
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
		    String pname=  n.getAttributes().getNamedItem("name").getNodeValue();
		    name[i]=pname;
		    String pposition = n.getAttributes().getNamedItem("position").getNodeValue();
		    position[i]=pposition;
			String pboard = n.getAttributes().getNamedItem("board").getNodeValue();
			board[i]=pboard;
			//System.out.println(board[i]);
			String score = n.getAttributes().getNamedItem("score").getNodeValue();
			s[i] = Long.valueOf(score);
		//	app.getResponseArea().append("  " + pname  + "\n");
		}
		model.boardResponseHandler(managingUser, bonus, name, position, board, s);
		// at this point, you would normally start processing this...
		//app.getResponseArea().append(response.toString());
		//app.getResponseArea().append("\n");			
		return true;
			
		
		// this refers to the outer node of the Message DOM (in this case, updateResponse).
//		Node boardResponse = response.contents.getFirstChild();
//		NamedNodeMap map = boardResponse.getAttributes();
//		
//		String gameId = map.getNamedItem("gameId").getNodeValue();
//		//app.getResponseArea().append("Board Message received for game:" + gameId + "\n");
//		//app.getResponseArea().append("Players:\n");
//		NodeList list = boardResponse.getChildNodes();
//		for (int i = 0; i < list.getLength(); i++) {
//			Node n = list.item(i);
//			String pname = n.getAttributes().getNamedItem("name").getNodeValue();
//			//app.getResponseArea().append("  " + pname  + "\n");
//		}
//		
		// at this point, you would normally start processing this...
		//app.getResponseArea().append(response.toString());
		//app.getResponseArea().append("\n");
		
//		NodeList ls = response.contents.getChildNodes();
//		System.out.println(ls.getLength());
//		for (int j = 0; j < ls.getLength(); j++) {
//			Node child = ls.item(j);
//			
//			NamedNodeMap map = child.getAttributes();
//			for (int i = 0; i < map.getLength(); i++) {
//				Node attribute = map.item(i);
//			
//				String name = attribute.getNodeName(); 
//				String value = attribute.getNodeValue();
//				System.out.println(name + " = " + value);
//			}
//			System.out.println(child.getChildNodes().getLength());
//			process(child);
//		}
		/*NodeList ls = response.contents.getChildNodes();
		
		System.out.println(ls.getLength());
		for (int j = 0; j < ls.getLength(); j++) {
			Node child = ls.item(j);
			Node BoardResponse = response.contents.getFirstChild();
			NamedNodeMap infor = BoardResponse.getAttributes();
				String gameId = infor.getNamedItem("gameId").getNodeValue();
			    String size= infor.getNamedItem("size").getNodeValue();
			    int s =Integer.valueOf(size);
				String isManagingUser= infor.getNamedItem("managingUser").getNodeValue();
				String  contents = infor.getNamedItem("contents").getNodeValue();
				String bonus = infor.getNamedItem("bonus").getNodeValue();

			process(child);
		}
		model.boardResponseHandler(managingUser, bonus, names, positions, board, scores);
		return true;
	}
	
	
	public static void process(Node child) {

//		NodeList list = child.getChildNodes();
//		for (int i = 0; i < list.getLength(); i++) {
//			
//			Node child1 = list.item(i);
//			NamedNodeMap map1 = child1.getAttributes();
//			String gameId = map1.getNamedItem("gameId").getNodeValue();
//			int size = Integer.valueOf(map1.getNamedItem("size").getNodeValue());
//			String score = map1.getNamedItem("score").getNodeValue();
//			String contents= map1.getNamedItem("contents").getNodeValue();
//			String bonus=map1.getNamedItem("bonus").getNodeValue();
//			System.out.println();
//		}
//		
		NodeList list = child.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			
			Node child1 = list.item(i);
			NamedNodeMap map1 = child1.getAttributes();

			String name = map1.getNamedItem("name").getNodeValue();
		    String position= map1.getNamedItem("position").getNodeValue();
			String score = map1.getNamedItem("score").getNodeValue();
			long s = Long.valueOf(score);
			String board= map1.getNamedItem("board").getNodeValue();
			

//			for (int j = 0; j < map1.getLength(); j++) {
//				Node attribute = map1.item(j);
//				String name = attribute.getNodeName(); 
//				String value = attribute.getNodeValue();
//				System.out.println(name + " = " + value);
				System.out.println(map1.getNamedItem("board").getNodeValue());
				System.out.println(map1.getNamedItem("name").getNodeValue());
				System.out.println(map1.getNamedItem("position").getNodeValue());
				System.out.println(map1.getNamedItem("score").getNodeValue());
				System.out.println();
			//}
			System.out.println();

		}*/
	} 

}

