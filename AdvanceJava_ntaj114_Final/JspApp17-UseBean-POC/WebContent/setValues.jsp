
<%@page import="com.nt.beans.*"%>

<!-- create/Locate Bean class -->
<jsp:useBean id="st" class="com.nt.beans.StudentBean" scope="application"/>

<%-- <!-- set values to bean properies -->
<jsp:setProperty name="st" property="sno" value="101"/>
<jsp:setProperty name="st" property="sname" value="raja"/>
<jsp:setProperty name="st" property="result" value="pass"/>
 --%>
<%--  <!-- set req param values to bean properties -->
 <jsp:setProperty name="st" property="sno" param="stno"/>
 <jsp:setProperty name="st" property="sname" param="stname"/>
 <jsp:setProperty name="st" property="result" param="stresult"/>
 --%>
  <!-- set req param values to bean properties(when req params and bean properties are matching) -->
  <jsp:setProperty name="st" property="*"/>
  
  
 
<h1><b><i> Values are set...</i></b></h1>

