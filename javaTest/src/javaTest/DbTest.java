package javaTest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTest {
	private Connection conn;
	private static final String UserName = "yij6514";
	private static final String Password = "6514";
	private static final String URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
	
	public DbTest() {
		try {
			System.out.println("생성자");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, UserName, Password);
			System.out.println("드라이버 로딩 성공");
		}catch (Exception e) {
            System.out.println("드라이버 로딩 실패 ");
            e.printStackTrace();
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
	}
	
	public static void main(String[] args) {
		DbTest db = new DbTest();
	}
}
