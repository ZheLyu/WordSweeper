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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import client.ServerAccess;
import client.controller.CreateGameController;
import client.controller.JoinGameController;
import client.controller.StartPraticeController;
import client.model.Model;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Application extends JFrame {
    
	static String Version ="V 1.0.7"; 

	/** GUI application maintains reference to Model for ease of navigation. */
	public final Model model;
	
	JPanel contentPane;
	ServerAccess serverAccess;
	
	JButton btnCreateGame;
	JButton btnJoinGame;
	JButton btnStartPratice;
	
	/**
	 * Create the Application frame.
	 */
	public Application(final Model model) {
		this.model = model;
		setTitle("Skeleton Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnCreateGame = new JButton("Create Game");
		btnCreateGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateGameController(Application.this, model).process();
			}
		});
		
		btnJoinGame = new JButton("Join Game");
		btnJoinGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinGameController(Application.this, model).process();
			}
		});
		
		btnStartPratice=new JButton("Start Pratice");
		btnStartPratice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartPraticeController(Application.this,model).process();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Word   Sweeper");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
		
		JLabel lblNewLabel_1 = new JLabel(Version);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(299, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnStartPratice, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
								.addComponent(btnJoinGame, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
								.addComponent(btnCreateGame, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))))
					.addGap(90))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCreateGame)
					.addGap(35)
					.addComponent(btnJoinGame)
					.addGap(36)
					.addComponent(btnStartPratice)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}


	public void setServerAccess(ServerAccess access) {
		this.serverAccess = access;
	}
	
	/** Get the server access object. */
	public ServerAccess getServerAccess() {
		return serverAccess;
	}
}

