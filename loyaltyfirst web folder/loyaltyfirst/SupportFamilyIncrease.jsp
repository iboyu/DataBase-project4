<%@page import="java.sql.*" %>

<%      
        String cid=request.getParameter("cid");
        String tref=request.getParameter("tref");
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url="jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
        Connection conn=DriverManager.getConnection(url,"rjain8","noonooci");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select c.family_id, p.percent_added, p.num_of_points from customers c, transactions t, point_accounts p where c.cid="+cid+" AND t.tref="+tref+" AND t.point_acct_no = p.point_acct_no");
        String output="";
      
        while(rs.next()){
            
            output+=rs.getObject(1)+","+rs.getObject(2)+","+rs.getObject(3)+"#";
            
            }
        conn.close();
        out.print(output);
    
%>
