package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao {

	public static int saveUser(user u)
	{
		System.out.print("in dao "+u);
		
		Connection con = null;
		int result=0;
		try{
			con = DBConnection.getConn();
			PreparedStatement stmt = con.prepareStatement("insert into user(name,email,mobile,password) values(?,?,?,?)");
			
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getMobile());
			stmt.setString(4, u.getPassword());
			
			result= stmt.executeUpdate();
		}catch(Exception e)
		{
		   e.printStackTrace();	
		}finally{
			
			try{
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	return result;
	}


public static ArrayList<user> getUsers()
{
      ArrayList<user> userList = new ArrayList<user>();	
      Connection con = null;
      
      try{
    	  con = DBConnection.getConn();
    	  
    	  Statement stmt = con.createStatement();
    	  ResultSet rs =stmt.executeQuery("select name,email,mobile,password,id from user");
    	  
    	  while(rs.next())
    	  {
    		  user u = new user();
    		  u.setName(rs.getString(1));
    		  u.setEmail(rs.getString(2));
    		  u.setMobile(rs.getString(3));
    		  u.setPassword(rs.getString(4));
    		  u.setId(rs.getInt(5));
    		  userList.add(u);
    	  }
      }catch(Exception e)
      {
    	  e.printStackTrace();
      }
return userList;
   }

public static boolean validate(String name, String password){
	
	boolean status=false;
	Connection con = null;
	
	try{
		con = DBConnection.getConn();
	    PreparedStatement ps=con.prepareStatement("select * from user where name=? and password=?");	
	    ps.setString(1,name);
	    ps.setString(2,password);
	    
	    ResultSet rs=ps.executeQuery();
	    status=rs.next();
	}catch(Exception e){System.out.println(e);}
	    
	return status;
}
}