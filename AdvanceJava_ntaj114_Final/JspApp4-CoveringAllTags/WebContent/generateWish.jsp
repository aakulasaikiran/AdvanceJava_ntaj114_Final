

<%!
  public String generateWish(String uname){
     java.util.Calendar calendar=null;
     int hour=0;
//      System.out.println("generateWish(-) method");
     //get System Date
     calendar=java.util.Calendar.getInstance();
     //get Current hour
     hour=calendar.get(java.util.Calendar.HOUR_OF_DAY);
     //generate Wish Message
     if(hour<=12)
      return "Good Morning::"+uname;
     else if(hour<=16)
      return "Good AfterNoon::"+uname;
     else if(hour<=20)
      return "Good Evening::"+uname;
      else
       return "Good night::"+uname;
    }//method
 %>
<!--  <h1><center> Welcome to JSP</center></h1> -->
 <br>
  System Date and Time:: <%-- <%=new java.util.Date()  --%> <br>
  
  <% String uname="raja"; %>
  
  <br><br>
   Wish Message ::: <%=generateWish(uname)%>
  
  
  
  
  

