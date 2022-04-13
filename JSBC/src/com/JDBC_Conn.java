package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_Conn {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "c##scott";
		String password="tiger";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your option");
		System.out.println("1. To see the Table\n2. To insert\n3. To delete");
		int opt = sc.nextInt();
		switch (opt) {
		case 1:
			try {
				Connection conn = DriverManager.getConnection(url,username,password);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("Select * from EMPLOYEE");
					while(rs.next()) {
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
					}
					conn.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			break;
		case 2:
			try {
				Connection conn = DriverManager.getConnection(url,username,password);
				Statement st = conn.createStatement();
				int result = st.executeUpdate("insert into employee values(901,'TRIVENI', 'puli.tri@atos.net',8844557788,156,21)");
				System.out.println(result);
				conn.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			break;
		case 3:
			try {
				Connection conn = DriverManager.getConnection(url,username,password);
				Statement st = conn.createStatement();
				int result = st.executeUpdate("delete from employee where eid =901");
				System.out.println(result);
				conn.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}

		default:
			break;
		}
	
		sc.close();
		
		
	}
}