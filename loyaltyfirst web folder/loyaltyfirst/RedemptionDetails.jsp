<%@page import="java.sql.*" %>

<%      
        String prizeid=request.getParameter("prizeid");
        String cid=request.getParameter("cid");
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url="jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
        Connection conn=DriverManager.getConnection(url,"rjain8","noonooci");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select p.p_description, p.points_needed, r_date, center_name from prizes p NATURAL JOIN exchgcenters, redemption_history where p.prize_id="+prizeid+" AND cid="+cid);
        String output="";
      
        while(rs.next()){
            
            output+=rs.getObject(1)+","+rs.getObject(2)+","+rs.getObject(3)+","+rs.getObject(4)+"#";
            
            }
        conn.close();
        out.print(output);
    
%>
