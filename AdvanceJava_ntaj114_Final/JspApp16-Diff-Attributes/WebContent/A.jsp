
<b><center> A.jsp</center></b>
<% //To create Attributes 
   pageContext.setAttribute("jdbcCon","con",pageContext.PAGE_SCOPE);
   pageContext.setAttribute("score","123/4",pageContext.REQUEST_SCOPE);
   pageContext.setAttribute("user","raja",pageContext.SESSION_SCOPE);
   pageContext.setAttribute("pwd","hyd",pageContext.APPLICATION_SCOPE);
   //forward the request
%>
<jsp:forward page="B.jsp"/>
