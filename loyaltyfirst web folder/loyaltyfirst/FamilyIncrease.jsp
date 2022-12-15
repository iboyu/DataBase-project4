<%@page import="java.sql.*" %>

<%      
        String fid=request.getParameter("fid");
        String cid=request.getParameter("cid");
        String npoints=request.getParameter("npoints");
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        String url="jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
        Connection conn=DriverManager.getConnection(url,"rjain8","noonooci");
        Statement stmt=conn.createStatement();
        stmt.executeUpdate("UPDATE point_accounts SET NUM_OF_POINTS=NUM_OF_POINTS+"+npoints+" WHERE family_id="+fid+" AND cid!="+cid);
        String output="Successfully updated the point accounts of family members";
        conn.close();
        out.print(output);
    
%>
