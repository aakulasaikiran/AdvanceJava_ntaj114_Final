<%@page import="nl.captcha.Captcha"%>

<%
//get Captcha obj from Session attribute
Captcha captcha=(Captcha)session.getAttribute(Captcha.NAME);
//get Answer
String answer=request.getParameter("answer");
//compare challeng and aswier
if(captcha.isCorrect(answer)){ %>
  <h1> Valid Repsonse</h1>
<%}
else{
 %>
   <h1>Invalid response </h1>
 <%}%>