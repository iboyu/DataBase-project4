<%@page import="java.sql.*" %>

<%      
        String tref=request.getParameter("tref");
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url="jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
        Connection conn=DriverManager.getConnection(url,"rjain8","noonooci");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select t_date, t_points, prod_name, prod_points, quantity from transactions NATURAL JOIN transactions_products, products where tref="+tref);
        String output="";
      
        while(rs.next()){
            
            output+=rs.getObject(1)+","+rs.getObject(2)+","+rs.getObject(3)+","+rs.getObject(4)+","+rs.getObject(5)+"#";
            
            }
        conn.close();
        out.print(output);
    
%>
