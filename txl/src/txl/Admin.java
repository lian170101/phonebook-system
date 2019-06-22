package txl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	
	public static final String DBURL = "jdbc:mysql://localhost:3306/txl" ;
	
	public static final String DBUSER = "root" ;
	
	public static final String DBPASS = "root" ;
	
	private String username;
	private String password;
	
	public Admin(){};
	public Admin(String strUsername,String strPassword)
	{
		username = strUsername;
		password = strPassword;
	}

	public int Login(String strUsername, String strPassword) {
		
		if(this.getUsername().equals(strUsername) && this.getPassword().equals(strPassword))		
		{
			return 1;	
		}
		else
		{
			return 0;
		}		
	}

	public void register() throws Exception{
		
		System.out.println("输入用户名、密码：");
		Scanner sc8 = new Scanner(System.in);
		String username = sc8.nextLine();
		String password = sc8.nextLine();
		Connection conn3 = null ;
		Statement stmt3 = null ;
		String sql3 = "insert into admin(username,password) "+ " values ('" + username + "','" + password + "')";
		Class.forName(DBDRIVER) ;
		conn3 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt3 = conn3.createStatement();
		int i = stmt3.executeUpdate(sql3);
		if(i > 0)
			System.out.println("注册成功");
		stmt3.close();
		conn3.close();
	}
	
	public void change() throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("用户名:");
		Scanner sc2 = new Scanner(System.in);
		String username = sc2.nextLine();
		String sql1 = "select username,password from admin where username = '" + username + "'";

		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql1);
		while (rs.next()) {
			String name = rs.getString("username");
			String pass = rs.getString("password");
			System.out.println("用户名：" + name + ",密码：" + pass);
		}
		
		System.out.println("输入新密码:");
		Scanner sc3 = new Scanner(System.in);
		String password = sc2.nextLine();
		
		String sql = "update admin set password = '" + password +"' where username = '" + username + "'";
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
