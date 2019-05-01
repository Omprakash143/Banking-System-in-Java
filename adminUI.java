//package Library;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class adminUI extends JFrame implements ActionListener{
	
	JButton getUserCount ;
	JButton verifyUser ;
	JButton getUserDetails;
	JButton close;
	
	adminUI(){
		this.setLayout(new FlowLayout());
		
		getUserCount = new JButton("getUserCount");
		verifyUser = new JButton("verifyUser");
		getUserDetails = new JButton("getUserDetails");
		close = new JButton("close");
		
		getUserCount.addActionListener(this);
		verifyUser.addActionListener(this);
		getUserDetails.addActionListener(this);
		close.addActionListener(this);
		
		this.add(verifyUser);
		this.add(getUserCount);
		this.add(getUserDetails);
		this.add(close);
		
		setTitle("WELCOME PRAKASH");
		setSize(200,200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(getUserCount == arg0.getSource()) {
			
		}
		
		if(verifyUser == arg0.getSource()) {
			
		}
		
		if(getUserDetails == arg0.getSource()) {
			
		}
		
		if(close == arg0.getSource()) {
			dispose();
		}
	}

}
