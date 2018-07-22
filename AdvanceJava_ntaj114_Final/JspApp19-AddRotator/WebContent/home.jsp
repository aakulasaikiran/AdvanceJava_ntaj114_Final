
<%@page import="com.nt.service.*" %>

<!-- create servie class object -->
<jsp:useBean id="service" class="com.nt.service.AddRotatorService" scope="application"/>

<%
  service.nextAdvertisement();
  response.setHeader("refresh","2");
 %>
 
 <br>
 <a href="<jsp:getProperty name="service" property="link"/>">
   <img src="<jsp:getProperty name="service" property="image"/>">
</a>
 
<br><br>
 <h1> Body of  web page</h1>

