package client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

import client.ServerAccess;
import client.controller.CreateGameController;
import client.controller.JoinGameController;
import client.controller.StartPraticeController;
import client.model.Model;

import javax.swing.JLabel;




public class Application extends JFrame {


	/** GUI application maintains reference to Model for ease of navigation. */
	public final Model model;
	
	JPanel contentPane;
	ServerAccess serverAccess;
	
	JButton btnCreateGme;
	JButton btnJoinGame;
	JButton btnStartPratice;
	
	/**
	 * Create the frame.
	 */
	public Application(final Model model) {
		this.model = model;
		setTitle("Skeleton Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCreateGame = new JButton("Create Game");
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
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(90)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnStartPratice, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(btnJoinGame, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(btnCreateGame, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(76))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(btnCreateGame)
					.addGap(57)
					.addComponent(btnJoinGame)
					.addGap(66)
					.addComponent(btnStartPratice)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	/** Record the means to communicate with server. */
	public void setServerAccess(ServerAccess access) {
		this.serverAccess = access;
	}
	
	/** Get the server access object. */
	public ServerAccess getServerAccess() {
		return serverAccess;
	}
	
	/** Navigation access to actionable elements in the GUI. */
	
}

