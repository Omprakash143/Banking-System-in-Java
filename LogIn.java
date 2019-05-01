
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// calls main bank frame i.e AbstractWT class

public class LogIn extends JFrame implements ActionListener{
	TextField userText;
	TextField pwdText;
	JButton submitButton ;
	JButton exitButton ;
	JButton registerButton;
	JButton adminButton;
	JLabel usernameLabel;
	JLabel pwdLabel;
	JLabel welcomeToBankLabel;
	
	public LogIn() {
		this.setLayout(new FlowLayout());
		
		submitButton = new JButton("SUBMIT");
		exitButton = new JButton("EXIT");
		registerButton = new JButton("REGISTER");
		adminButton = new JButton("LOGIN AS ADMIN");
		
		welcomeToBankLabel = new JLabel("LogIn Form");
		pwdLabel = new JLabel("Passsword",Label.LEFT);
		usernameLabel = new JLabel("Username",Label.LEFT);
		
		
		userText = new TextField(20);
		pwdText = new TextField(20);
		pwdText.setEchoChar('*');
		
		submitButton.addActionListener(this);
		exitButton.addActionListener(this);
		registerButton.addActionListener(this);
		adminButton.addActionListener(this);
		
		this.add(welcomeToBankLabel);
		this.add(usernameLabel);
		this.add(userText);
		this.add(pwdLabel);
		this.add(pwdText);
		this.add(exitButton);
		this.add(submitButton);
		this.add(registerButton);
		this.add(adminButton);
		
		setTitle("Login successful");
		setSize(200,200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg) {
		String username,password;
		if(arg.getSource()==submitButton) {
			username = userText.getText().toString();
			password = pwdText.getText().toString();
			boolean bool = false;
			try {
				bool = new Database().checkLoginDetails(username,password);
			}catch(Exception e) {
				
			}
			if(bool==true) {
				new AbstractWT();
			}
			
		}
		if(arg.getSource()==exitButton) {
			System.exit(0);
		}
		if(arg.getSource()==registerButton) {
			new RegistrationForm();
		}
		
		if(arg.getSource()==adminButton) {
			username = userText.getText().toString();
			password = pwdText.getText().toString();
			if(username.equals("admin") && password.equals("adminpass")) {
				new adminUI();
			}
		}
		
	}

}
