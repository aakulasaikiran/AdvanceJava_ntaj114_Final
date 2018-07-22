<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Declare variable having scope with value -->
 <c:set var="msg" value="hello" scope="request"/>
<!-- Display value -->
 Value :: <c:out value="${msg}"/>
<!-- remove variable from scope -->
 <c:remove var="msg" scope="request"/>
 <br>
 <!-- Display value -->
 Value :: <c:out value="${msg}"  />
 
   