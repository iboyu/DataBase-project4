<%@page import="java.sql.*" %>

<%      
        String cid=request.getParameter("cid");
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url="jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
        Connection conn=DriverManager.getConnection(url,"rjain8","noonooci");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select c.cname, p.NUM_OF_POINTS from customers c, point_accounts p where c.cid= " + cid + " AND p.cid= " + cid);
        String output="";
      
        while(rs.next()){
            
            output+=rs.getObject(1)+","+rs.getObject(2);
            
            }
        conn.close();
        out.print(output);
    
%>
