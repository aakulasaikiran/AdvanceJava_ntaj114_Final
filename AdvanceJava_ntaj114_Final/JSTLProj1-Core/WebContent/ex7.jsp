<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*" %>

<c:forEach var="i" begin="1" end="10"  step="1">
  <c:out value="2 * ${i}="/>
  <c:out value="${2*i}"/> <br>
</c:forEach>

<hr>

<jsp:scriptlet>
  String names[]={"ravi","raja","rani","mahesh","harsh-Gujju"};
  request.setAttribute("namesList",names);
</jsp:scriptlet>

 <c:forEach var="nam" items="${namesList}">
    <c:out value="${nam}"/> <br>
 </c:forEach>
 <hr>
 <jsp:scriptlet>
  <![CDATA[
   List<String> fruits=new ArrayList();
   fruits.add("mango");fruits.add("apple"); fruits.add("orange");
   request.setAttribute("fruitsList",fruits);
   ]]>
</jsp:scriptlet>


 <c:forEach var="phal" items="${fruitsList}">
    <c:out value="${phal}"/> <br>
 </c:forEach>
 
