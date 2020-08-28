package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
public static Connection getConn()throws Exception
{
	Class.forName("com.mysql.jdbc.Driver");
	
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/topper","root","root");
}
}
