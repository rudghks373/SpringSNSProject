<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<% 
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:testdb", "scott", "tiger");
	Statement st = conn.createStatement();
	
	String sql = "SELECT jsonobj FROM feed WHERE id = " + id + " ORDER BY no DESC LIMIT 10";
	ResultSet rs = st.executeQuery(sql);
	
	// generate the result in the form of the JSON array
	String list = "[";
	int cnt = 0;
	while(rs.next()) {
		if (++cnt > 1) list += ", ";
		list += rs.getString("jsonobj");
	}
	list += "]";

	out.print(list);
	
	rs.close();
	st.close();
	conn.close();
%>