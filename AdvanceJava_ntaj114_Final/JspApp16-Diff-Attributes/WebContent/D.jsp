
<!--  read and display diff scope attributes -->
 <b><center> D.jsp</center></b> <br>
page scope attribute:: <%=pageContext.findAttribute("jdbcCon")%><br>
request scope attribute:: <%=pageContext.findAttribute("score")%><br>
session scope attribute:: <%=pageContext.findAttribute("user")%><br>
application scope attribute:: <%=pageContext.findAttribute("pwd")%><br>

