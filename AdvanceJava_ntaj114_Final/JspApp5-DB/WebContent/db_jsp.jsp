<%@page  import="java.sql.*" %>

<%!
  Connection con;
  PreparedStatement ps1,ps2;
  public void jspInit(){
   
    try{
    //Access ServletConfig object
    ServletConfig cg=getServletConfig();
     String driver=cg.getInitParameter("driver");
     String url=cg.getInitParameter("url");
     String dbuser=cg.getInitParameter("dbuser");
     String dbpwd=cg.getInitParameter("dbpwd"); 
    //register jdbc driver
    Class.forName(driver);
    //establis the connection
    con=DriverManager.getConnection(url,dbuser,dbpwd);
    //create PreparedStatement objects
    ps1=con.prepareStatement("select * from student");
    ps2=con.prepareStatement("insert into student values(?,?,?)");
    }
    catch(SQLException se){
     se.printStackTrace();
     }
     catch(Exception e){
      e.printStackTrace();
     } 
  }//jspInit()
 %>
 
 <%
   //read additional req param(s1) value
   String paramValue=request.getParameter("s1");
   
   if(paramValue.equalsIgnoreCase("register")){ //for sumbit button
     //read form data
     int sno=Integer.parseInt(request.getParameter("sno"));
     String sname=request.getParameter("sname");
     String addrs=request.getParameter("sadd");
     //set values to query params
     ps2.setInt(1,sno);
     ps2.setString(2,sname);
     ps2.setString(3,addrs);
     //execute the Query
     int result=ps2.executeUpdate();
     if(result==0){ %>
        <h1>Registration failed</h1>
      <%}
        else{
       %>
        <h1>Registration succeded</h1>
       <%}
        }//if  
        else{   //for hyperlink
         ResultSet rs=ps1.executeQuery(); %>
          <table border='1'>
          <tr><th>sno</th><th>sname</th><th>sadd</th></tr>
        <%  while(rs.next()){ %>
          <tr>
           <td><%=rs.getInt(1)%></td>
           <td><%=rs.getString(2)%></td>
           <td><%=rs.getString(3)%></td>
           </tr>
        <% } %>
         </table>
       <%  } %>
       <bR><br>
        <a href="form.html">home</a> <br><br>
        
<%!  public void jspDestroy(){
       try{
        if(ps1!=null)
          ps1.close();
       }
       catch(Exception e){
        e.printStackTrace();       
       }
       try{
        if(ps2!=null)
          ps2.close();
       }
       catch(Exception e){
        e.printStackTrace();       
       }
       
       try{
        if(con!=null)
          con.close();
       }
       catch(Exception e){
        e.printStackTrace();       
       }
     }//jspDestroy()
   %>
