<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:import url="abc.html"/>


<c:url var="u2" value="http://localhost:2525/JSTLProj1-Core/ex1.jsp"/>

<c:url var="u1" value="abc.html"/>
<c:import url="${u2}"/>

<br>
<a href="${u1}">link1</a>

