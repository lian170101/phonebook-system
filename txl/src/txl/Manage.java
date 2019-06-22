package txl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Manage {

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";

	public static final String DBURL = "jdbc:mysql://localhost:3306/txl";

	public static final String DBUSER = "root";

	public static final String DBPASS = "root";
	
	public void login() throws Exception{
		
		System.out.println("�û���");
		System.out.println("����");

		Scanner sc2 = new Scanner(System.in);
		String username = sc2.nextLine();
		String password = sc2.nextLine();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT username,password FROM admin where username = '" + username + "'and password = '" + password + "'";
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Admin adm1 = new Admin();
			adm1.setUsername(rs.getString("username"));
			adm1.setPassword(rs.getString("password"));
			if (adm1.Login(username, password) == 1) {
				System.out.println("\n��ӭʹ��ͨѶ¼ϵͳ");
				break;
			} else {
				System.out.println("�û������������");
				System.exit(0);
				break;
			}
		}
		
		
		rs.close();
		stmt.close();
		conn.close();
	}

	public void show() throws Exception {

		Connection conn1 = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		String sql1 = "select * from phone ";

		Class.forName(DBDRIVER);
		conn1 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt1 = conn1.createStatement();
		rs1 = stmt1.executeQuery(sql1);
		while (rs1.next()) {
			String name = rs1.getString("name");
			String tel1 = rs1.getString("tel");
			String addr = rs1.getString("addr");
			System.out.println("������" + name + ",���룺" + tel1 + ",��ַ��" + addr);
		}
		rs1.close();
		stmt1.close();
		conn1.close();

	}

	public void searchByName() throws Exception {

		System.out.println("����������");
		Scanner sc6 = new Scanner(System.in);
		String name = sc6.nextLine();

		Connection conn1 = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		String sql1 = "select name,tel,addr from phone where name = '" + name + "'";

		Class.forName(DBDRIVER);
		conn1 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt1 = conn1.createStatement();
		rs1 = stmt1.executeQuery(sql1);
		while (rs1.next()) {
			String name1 = rs1.getString("name");
			String tel = rs1.getString("tel");
			String addr = rs1.getString("addr");
			System.out.println("������" + name1 + ",���룺" + tel + ",��ַ��" + addr);
		}
		rs1.close();
		stmt1.close();
		conn1.close();

	}

	public void searchByTel() throws Exception {

		System.out.println("������룺");
		Scanner sc7 = new Scanner(System.in);
		String tel = sc7.nextLine();

		Connection conn1 = null;
		Statement stmt1 = null;
		ResultSet rs1 = null;
		String sql1 = "select name,tel,addr from phone where tel = '" + tel + "'";

		Class.forName(DBDRIVER);
		conn1 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt1 = conn1.createStatement();
		rs1 = stmt1.executeQuery(sql1);
		while (rs1.next()) {
			String name = rs1.getString("name");
			String tel1 = rs1.getString("tel");
			String addr = rs1.getString("addr");
			System.out.println("������" + name + ",���룺" + tel1 + ",��ַ��" + addr);
		}
		rs1.close();
		stmt1.close();
		conn1.close();

	}
	
	public void deleteByName() throws Exception {

		System.out.println("����������");
		Scanner sc6 = new Scanner(System.in);
		String name = sc6.nextLine();

		Connection conn4 = null;
		Statement stmt4 = null;
		String sql4 = "delete from phone where name = '" + name + "'";

		Class.forName(DBDRIVER);
		conn4 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt4 = conn4.createStatement();
		int rs4 = stmt4.executeUpdate(sql4);
//		while (rs4.next()) {
//			System.out.println("ɾ���ɹ�");
//		}
		//rs4.close();
		if(rs4 > 0)
			System.out.println("ɾ���ɹ�");
		stmt4.close();
		conn4.close();

	}

	public void deleteByTel() throws Exception {

		System.out.println("������룺");
		Scanner sc6 = new Scanner(System.in);
		String tel = sc6.nextLine();

		Connection conn4 = null;
		Statement stmt4 = null;
		String sql4 = "delete from phone where tel = '" + tel + "'";

		Class.forName(DBDRIVER);
		conn4 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt4 = conn4.createStatement();
		int rs4 = stmt4.executeUpdate(sql4);
		if(rs4 > 0)
			System.out.println("ɾ���ɹ�");
		stmt4.close();
		conn4.close();

	}
	
	public void add() throws Exception {

		System.out.println("�ֱ��������������롢��ַ��");
		Scanner sc8 = new Scanner(System.in);
		String name = sc8.nextLine();
		String tel = sc8.nextLine();
		String addr = sc8.nextLine();
		Connection conn3 = null ;
		Statement stmt3 = null ;
		String sql3 = "insert into phone(name,tel,addr) "+ " VALUES ('" + name + "','" + tel + "','" + addr + "')";
		Class.forName(DBDRIVER) ;
		conn3 = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt3 = conn3.createStatement();
		stmt3.executeUpdate(sql3);
		stmt3.close();
		conn3.close();
	}
	
public void changeByTel() throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("����:");
		Scanner sc2 = new Scanner(System.in);
		String name = sc2.nextLine();
		String sql1 = "select name,tel,addr from phone where name = '" + name + "'";

		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql1);
		while (rs.next()) {
			String name1 = rs.getString("name");
			String tel = rs.getString("tel");
			String addr = rs.getString("addr");
			System.out.println("�û�����" + name1 + ",���룺" + tel + ",��ַ��" + addr);
		}
		
		System.out.println("�����º���:");
		Scanner sc3 = new Scanner(System.in);
		String tel = sc2.nextLine();
		
		String sql = "update phone set tel = '" + tel +"' where name = '" + name + "'";
		Class.forName(DBDRIVER);
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
		
	}
	
}
