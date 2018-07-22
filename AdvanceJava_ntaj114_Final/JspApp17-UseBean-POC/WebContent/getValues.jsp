
<%@page import="com.nt.beans.*"%>

<!-- Locate Bean class object -->
<jsp:useBean id="st"  class="com.nt.beans.StudentBean" scope="application"/>
<!-- Read and display bean property values -->
sno==<jsp:getProperty name="st" property="sno"/><br>
sname==<jsp:getProperty name="st" property="sname"/><br>
Result==<jsp:getProperty name="st" property="result"/><br>


