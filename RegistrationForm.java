//package Library;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;

public class RegistrationForm extends JFrame implements ActionListener{
	TextField usernameText;
	JLabel usernameLabel;
	TextField pwdText;
	JLabel passwordLabel;
	TextField accountNo;
	JLabel accountNoLabel;
	TextField againPwdText;
	JLabel againPwdLabel;
	TextField mobileText;
	JLabel mobileLabel;
	JButton register ;
	JLabel detailsLabel ;
	
	RegistrationForm(){
		this.setLayout(new FlowLayout());
		
		register = new JButton("REGISTER");
		register.addActionListener(this);
		
		usernameText = new TextField(20);
		pwdText = new TextField(20);
		pwdText.setEchoChar('*');
		accountNo = new TextField(20);
		againPwdText = new TextField(20);
		mobileText = new TextField(20);
		
		usernameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		accountNoLabel = new JLabel("Acc_No");
		againPwdLabel = new JLabel("pwdAgain");
		mobileLabel = new JLabel("mobile");
		
		detailsLabel = new JLabel("Fill in the blanks");
		
		this.add(detailsLabel);
		this.add(usernameLabel);
		this.add(usernameText);
		this.add(accountNoLabel);
		this.add(accountNo);
		this.add(passwordLabel);
		this.add(pwdText);
		this.add(againPwdLabel);
		this.add(againPwdText);
		this.add(mobileLabel);
		this.add(mobileText);
		this.add(register);
		
		setTitle("Login successful");
		setSize(200,200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==register) {
			String user = usernameText.getText().toString();
			int accno = Integer.parseInt(accountNo.getText());
			String pwd = pwdText.getText().toString();
			String repwd = againPwdText.getText().toString();
			int mobile = Integer.parseInt(mobileText.getText());
			boolean b = true;
			try {
				b = new Database().registeredUsers(user,accno,pwd,repwd,mobile);
				System.out.print(b);
			}catch(Exception e) {
				
			}
			if(b==false) {
				dispose();
			}
		}
	}
}
