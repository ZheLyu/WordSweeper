package client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import client.controller.CreateGameRequestController;
import client.model.GameRoom;

public class CreateRoomPage extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	
	public CreateRoomPage(final Application app, final GameRoom m) 
	{
		setTitle("Create Room");
		setBounds(100, 100, 464, 281);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room ID:");
		lblNewLabel.setBounds(39, 28, 109, 43);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPlayerId = new JLabel("Player ID:");
		lblPlayerId.setBounds(39, 98, 109, 43);
		getContentPane().add(lblPlayerId);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(128, 159, 123, 51);
		btnNewButton.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
				
				new CreateGameRequestController(app, m).process();
				dispose();
				
				BoardDisplay frame = new BoardDisplay(app, m);
			    frame.setVisible(true);
				
				

			}
		});
		
		getContentPane().add(btnNewButton);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(252, 159, 123, 51);
		getContentPane().add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(163, 36, 212, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 98, 212, 35);
		getContentPane().add(textField_1);
	
	}
}
