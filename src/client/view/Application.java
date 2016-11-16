/***************************************************************
Generated by Eclipse
Version JAVA SE 1.7

Application.java : implementation file
This is a view class to create a frame for player to create game, 
join game or practice.

History:
1 Oct, 2016	--- George Heineman @1
- Created.

7 Oct, 2016 --- Zhe Lyu @2
-Modify.
*****************************************************************/


package client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import client.ServerAccess;
import client.controller.CreateGameRequestController;
import client.controller.ExitGameRequestController;
import client.controller.JoinGameRequestController;
import client.controller.StartPraticeController;
import client.model.GameRoom;







import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;

public class Application extends JWindow {
    

	static String Version ="V 1.0.28"; 

	

	/** GUI application maintains reference to Model for ease of navigation. */
	public final GameRoom model;
	
	
	ServerAccess serverAccess;
	

	JPanel  contentPane;
	JButton btnCreateGame;
	JButton btnJoinGame;
	JButton btnStartPratice;
	JButton btnExitGame;
	JLabel lblNewLabel_1;
	
	static int HSTART = 588;
	static int VSTART = 300;
	static int VSPAN = 100;
	static int WIDTH = 350;
	static int HEIGHT = 80;
	
	/**
	 * Create the Application frame.
	 */
	public Application(final GameRoom model) {
		
		this.model = model;
		
		//setTitle("Word Sweeper");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		
	
		contentPane =new JPanel(){
			
			protected void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				ImageIcon icon =new ImageIcon("src\\client\\res\\mainBKG.jpg");
			    Image img=icon.getImage();
			    g.drawImage(img, 0, 0, icon.getIconWidth(),icon.getIconHeight(),this);
			}
			
		};
		contentPane.setBounds(0, 0, 1600, 900);
		
	
		lblNewLabel_1 = new JLabel(Version);
		lblNewLabel_1.setBounds(1400, 850, 200, 63);
		
		
		
		btnCreateGame = new JButton("Create Game");
		btnCreateGame.setBounds(HSTART+10, VSTART, WIDTH, HEIGHT);
		
		btnCreateGame.setBorderPainted(false);
		btnCreateGame.setContentAreaFilled(false);
		Icon iconCreateA=new ImageIcon("src\\client\\res\\btnCreateA.png");
	    Icon iconCreateB=new ImageIcon("src\\client\\res\\btnCreateB.png");
		btnCreateGame.setIcon(iconCreateA);
		btnCreateGame.setPressedIcon(iconCreateB);
		
		btnCreateGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new CreateGameRequestController(Application.this, model).process();
				
				CreateRoomPage createPage= new CreateRoomPage(Application.this, model);
				createPage.setVisible(true);
				
			}
		});
		
		btnJoinGame = new JButton("Join Game");
		btnJoinGame.setBounds(HSTART, VSTART+VSPAN, WIDTH, HEIGHT);
		
		btnJoinGame.setBorderPainted(false);
		btnJoinGame.setContentAreaFilled(false);
		Icon iconJoinA=new ImageIcon("src\\client\\res\\btnJoinA.png");
	    Icon iconJoinB=new ImageIcon("src\\client\\res\\btnJoinB.png");
	    btnJoinGame.setIcon(iconJoinA);
	    btnJoinGame.setPressedIcon(iconJoinB);
		
		
		btnJoinGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JoinGamePage joinPage= new JoinGamePage(Application.this, model);
				joinPage.setVisible(true);
				
				
			}
		});
		
		btnStartPratice=new JButton("Start Pratice");
		btnStartPratice.setBounds(HSTART, VSTART+2*VSPAN, WIDTH, HEIGHT);
		
		btnStartPratice.setBorderPainted(false);
		btnStartPratice.setContentAreaFilled(false);
		Icon iconPracA=new ImageIcon("src\\client\\res\\btnPracA.png");
	    Icon iconPracB=new ImageIcon("src\\client\\res\\btnPracB.png");
	    btnStartPratice.setIcon(iconPracA);
	    btnStartPratice.setPressedIcon(iconPracB);
		
		
		btnStartPratice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartPraticeController(Application.this,model).process();
			}
		});
		
		
		btnExitGame= new JButton("Exit Game");
		btnExitGame.setBounds(HSTART, VSTART+3*VSPAN, WIDTH, HEIGHT);
		
		btnExitGame.setBorderPainted(false);
		btnExitGame.setContentAreaFilled(false);
		Icon iconExitA=new ImageIcon("src\\client\\res\\btnExitA.png");
	    Icon iconEixtB=new ImageIcon("src\\client\\res\\btnExitB.png");
	    btnExitGame.setIcon(iconExitA);
	    btnExitGame.setPressedIcon(iconEixtB);
		
		
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new ExitGameRequestController(Application.this,model).process();
				System.exit(0);
			}
		});
		
		
		getContentPane().setLayout(null);  	
		getContentPane().add(contentPane);
		
		contentPane.setLayout(null);  	
		contentPane.add(btnCreateGame);
		contentPane.add(btnJoinGame);
		contentPane.add(btnStartPratice);
		contentPane.add(btnExitGame);
		contentPane.add(lblNewLabel_1);
		
	}


	public void setServerAccess(ServerAccess access) {
		this.serverAccess = access;
	}
	
	/** Get the server access object. */
	public ServerAccess getServerAccess() {
		return serverAccess;
	}
}

