<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/frontpage.css">
<title>Exhibition</title>
</head>
<h1>Online Art Gallery</h1>
<body>
<div class="navbar">
  <a href="frontpage.jsp">Home</a>
  <a href="Paintings.jsp">Paintings</a>
      <a href="frontpage.jsp">Logout</a>
      <a href="add_exhibition.jsp">Add Exhibition</a>
      <a href="#" class="navbar1"> 
 
</div>
<br>
<br>
<h2>Upcoming Exhibitions</h2>
<table>
<tr>
	<td>Exhibition ID</td>
	<td>Exhibition Name</td>
	<td>Exhibition </td>
	<td>Start Date</td>
	<td>End Date</td>
	<td>Venue</td>
</tr>
<%
String url = "jdbc:mysql://localhost:3306/topper";

String driver = "com.mysql.jdbc.Driver";
String userName = "root";
String password = "root";
String query= "select * from exhibition";
try {
    Class.forName(driver).newInstance();
    Connection conn = DriverManager.getConnection(url, userName, password);

    Statement st = conn.createStatement();
   
    ResultSet rs = st.executeQuery(query);
    while(rs.next()){
    	%>
    	<tr>
    		<td><%= rs.getString("e_id") %></td>
    		 <td><%= rs.getString("e_name") %></td>
    		<td><%= rs.getString("e_type") %></td>

    		<td><%= rs.getString("start_date") %></td>
    		<td><%= rs.getString("end_date") %></td>
    		<td><%= rs.getString("venue") %></td>
    		
    		<script type="text/javascript">
   
    
</script>
<% HttpSession hsession = request.getSession();
String s1 = rs.getString("e_type");
hsession.setAttribute("s2", s1);
%>
    	</tr>
   <%} %>
   <%rs.close();
   st.close();
   conn.close();
   }
   catch (Exception e) {
   }
   %>
  <%-- <% }finally {
	  rs.close();
	   st.close();
	   conn.close();
            /* if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } */
        }
   
%> --%>
        </table>
    </div>
    
</body>
</html>