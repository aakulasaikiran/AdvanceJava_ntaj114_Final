<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="p" items="${paramValues}">
  param name= ${p.key}<br>
  Param values=
  <c:forEach var="pv" items="${p.value}">
     ${pv} 
  </c:forEach>
   <br>

</c:forEach>