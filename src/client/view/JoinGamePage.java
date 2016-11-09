package client.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import client.model.Model;

public class JoinGamePage extends JFrame
{
	
	private JTextField textField;
	private JTextField textField_1;
	
	public JoinGamePage(final Application app, final Model m) 
	{
		setTitle("Join Game");
		setBounds(100, 100, 464, 281);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room ID:");
		lblNewLabel.setBounds(39, 28, 109, 43);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPlayerId = new JLabel("Player ID:");
		lblPlayerId.setBounds(39, 98, 109, 43);
		getContentPane().add(lblPlayerId);
		
		JButton btnNewButton = new JButton("Join");
		btnNewButton.setBounds(128, 159, 123, 51);
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
