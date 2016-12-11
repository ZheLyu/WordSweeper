package client.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.controller.CreateGameRequestController;
import client.controller.JoinGameRequestController;
import client.model.GameRoom;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;

public class EnterRoomDlg extends JFrame implements ActionListener {

	private JTextField textField;
	private int m_iType;
	GameRoom m_gameRoom;
	Application m_app;
	JButton btnNewButton;
	JButton btnCancel;
	JTextArea textArea ;
	
	public EnterRoomDlg(final Application app, final GameRoom m, final int type) {
		// TODO Auto-generated constructor stub
		
		m_iType = type;
		m_gameRoom = m;
		m_app = app;
		
		setTitle("Join Game");
		setBounds(100, 100, 464, 229);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room ID:");
		lblNewLabel.setBounds(39, 28, 109, 43);
		getContentPane().add(lblNewLabel);
		

		
		btnNewButton = new JButton("OK");
		btnNewButton.setBounds(102, 107, 123, 51);
		btnNewButton.addActionListener(this);
		
		
		getContentPane().add(btnNewButton);
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(226, 107, 123, 51);
		btnCancel.addActionListener(this);
		
	
		getContentPane().add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(163, 36, 212, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.RED);
		textArea.setBackground(SystemColor.control);
		textArea.setBounds(102, 73, 310, 24);
		getContentPane().add(textArea);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==btnNewButton)
		{
			if(textField.getText().isEmpty()==true)
			{
				JOptionPane.showMessageDialog(null, "Invaild Room ID", "Invaild Room ID", JOptionPane.ERROR_MESSAGE);
				dispose();
				return;
			}
				
			m_gameRoom.setGameId(textField.getText());
		
	//		m_gameRoom.setCurrentPlayerName(textField.getText());
			
			  if(m_iType==0) {
				 
				  BoardDisplay frame = new BoardDisplay(m_app, m_gameRoom);
				  frame.setVisible(true); 
				  new CreateGameRequestController(m_app, m_gameRoom).process();
				   while (m_gameRoom.getPlayerList().size() == 0) System.out.print("");
				   System.out.println();
				   dispose();
				   
				  
			   } else {
				   
				   new JoinGameRequestController(m_app, m_gameRoom).process();
				   int count = 0; 
				   while (count < 1000000 && m_gameRoom.getPlayerList().size() == 0) {
					   System.out.print(""); 
					   count++;
				   }
				   if(m_gameRoom.getPlayerList().size() == 0){
					   System.out.println("out of time");
					   textArea.setText("Wrong gameroom, please try again!");   
				   }
				   else{
					   BoardDisplay frame = new BoardDisplay(m_app, m_gameRoom);
					   frame.setVisible(true);
					   dispose();
				   }
					   

				  //System.exit(0);
			   }
				   
				
				
		}
		
		if(arg0.getSource()==btnCancel)
		{
			dispose();
		}
		
	}
}
