//package Library;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CashWithdraw extends JFrame implements ActionListener{
	
	TextField accountNo;
	JLabel accountNoLabel;
	TextField passwd;
	JLabel passwdLabel;
	TextField amount;
	JLabel amountLabel;
	JButton confirm;
	Database db;
	
	
	
	CashWithdraw(){
				this.setLayout(new FlowLayout());
				
				
				
				accountNoLabel = new JLabel("acc_no");
				this.add(accountNoLabel);
				accountNo = new TextField(20);
				this.add(accountNo);
				passwdLabel = new JLabel("password");
				this.add(passwdLabel);
				passwd = new TextField(20);
				this.add(passwd);
				amountLabel = new JLabel("amount");
				this.add(amountLabel);
				amount = new TextField(20);
				this.add(amount);
				confirm = new JButton("confirm");
				this.add(confirm);
				confirm.addActionListener(this);
				
				
				this.setBackground(Color.green);
				this.setSize(500,500);
				this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int acc_no = Integer.parseInt(accountNo.getText());
		int withdrawAmount = Integer.parseInt(amount.getText());
		System.out.println(acc_no+""+withdrawAmount);
		try {
			//db.cashWithdraw(withdrawAmount , acc_no);
		}catch(Exception e) {
			
		}
		
		
	}
}
