//package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
		boolean registeredUsers(String user,int acc,String pwd,String againpwd,int mobile) throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","rootpwd");
			Statement statement = connection.createStatement();
			boolean b = true;
			try {
				b = statement.execute("insert into registeredusers values("+"'"+user+"'"+","+acc+","+"'"+"pwd"+"'"+","+"'"+againpwd+"'"+","+"'"+mobile+"'"+")");
				boolean b1 = statement.execute("commit");
				System.out.println(b);
				System.out.println(b1);
				return b;
			}catch(Exception e) {
				
			}finally {
				connection.close();
			}
			return b;
	}
		
		boolean checkLoginDetails(String username,String password) throws ClassNotFoundException, SQLException {
			String myquery = "select username,pwd from registeredusers where username="+"'"+username+"'";
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","rootpwd");
			Statement statement = connection.createStatement();
			try {
				 ResultSet rs = statement.executeQuery(myquery);
					rs.next();
					String user = rs.getString(1).toString();
					String pwd = rs.getString(2).toString();
					AbstractWT.user = user;
					AbstractWT.pwd = pwd;
					boolean b1 = statement.execute("commit");
					System.out.println(b1);
					if(user.equals(username) && pwd.equals(password)) {
						return true;
					}
			}catch(Exception e) {
				
			}finally{
				connection.close();
			}
			return false;
	}
		
		boolean removeUser(String username,String password) throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","rootpwd");
			Statement statement = connection.createStatement();
			boolean b = true;
			try {
					b = statement.execute("delete from registeredusers where username="+"'"+username+"'"+" and "+"pwd="+"'"+password+"'");
				boolean b1 = statement.execute("commit");
				System.out.println(b);
				System.out.println(b1);
			}catch(Exception e) {
				
			}finally {
				connection.close();
			}
			return b;
		}
		
		boolean cashWithdraw(int amount , int acc_no) throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","rootpwd");
			Statement statement = connection.createStatement();
			boolean b = true;
			try {
					//b = statement.execute("delete from registeredusers where username="+"'"++"'"+" and "+"pwd="+"'"+password+"'");
				boolean b1 = statement.execute("commit");
				System.out.println(b);
				System.out.println(b1);
			}catch(Exception e) {
				
			}finally {
				connection.close();
			}
			return b;
		}
		
		void CheckBalance() {
			
		}

}
