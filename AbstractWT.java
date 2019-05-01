//package Library;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AbstractWT implements ActionListener,Runnable{
	JFrame windowFrame;
	JPanel welcomePanel;
	JPanel buttonPanel;
	JLabel welcomeLabel;
	JButton buttonCashDeposit;
	JButton buttonCheckBalance;
	JButton buttonCashWithdraw;
	JButton removeMyAccount;
	static String user,pwd;
	Database db;
	
	AbstractWT(String user , String pwd){
		this.user = user;
		this.pwd = pwd;
	}
	
	AbstractWT(){
		
		// All about frame
		windowFrame = new JFrame("Welcome 2 Library");     //main frame
		windowFrame.setLayout(new GridLayout());		//setting layout to frame
		
		
		welcomePanel = new JPanel();
		welcomePanel.setLayout(new FlowLayout());
		welcomePanel.setSize(400,400);
		
		buttonPanel = new JPanel();  // panel to place buttons
		
		
		welcomeLabel = new JLabel("WELCOME 2 OUR BANK");
		
		
		buttonCashDeposit = new JButton("CASH DEPOSIT");
		
		buttonCashWithdraw = new JButton("CASH WITHDRAW");
		
		buttonCheckBalance = new JButton("CHECK BALANCE");
		
		removeMyAccount = new JButton("REMOVE ACCOUNT");
		
		
		windowFrame.add(welcomePanel);   // adding panel to frame
		welcomePanel.add(welcomeLabel);	// adding label to panel
		buttonPanel.add(buttonCashWithdraw);	// adding buttonCashWithdraw to buttonPanel
		buttonPanel.add(buttonCashDeposit);		// adding buttonCashDeposit to buttonPanel
		buttonPanel.add(buttonCheckBalance);	// adding buttonCheckBalance to buttonPanel
		buttonPanel.add(removeMyAccount);     // adding removeMyAccount to buttonPanel
		windowFrame.add(buttonPanel);
		
		
		windowFrame.setBackground(Color.green);
		windowFrame.setSize(500,500);
		windowFrame.setVisible(true);				//	making frame visible
		
		buttonCashDeposit.addActionListener(this);
		buttonCashWithdraw.addActionListener(this);
		buttonCheckBalance.addActionListener(this);
		removeMyAccount.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(buttonCashWithdraw == arg0.getSource()) {
			new CashWithdraw();
		}
		
		if(buttonCashDeposit == arg0.getSource()) {
			new cashDeposit();
		}
		
		if(buttonCheckBalance == arg0.getSource()) {
			db.CheckBalance();
		}
		
		if(removeMyAccount == arg0.getSource()) {
			boolean bool = true;
			try {
				bool = new Database().removeUser(user, pwd);
			}catch(Exception e) {
				
			}
			if(bool==false) {
				System.out.println("user removed successfully");
				windowFrame.dispose();
			}
			
		}
		
	}
	
	@Override
	public void run() {
		
	}
	
}
