package client.model;

import java.util.*;

public class Player {
	
	private Boolean isManger;
	private String nickName;
	private String id;
	private int totalScore;
	private Position position;
	private List<String> words;
 
	public void Plyaer(Boolean isManger, String nickName, String id){
	
		this.isManger = isManger;
		this.nickName = nickName;
		this.id = id;
	}
	
	public void setPosition(Position position) {
		
		//TODO:
	}

}
