<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:catch var="e">
    <jsp:scriptlet>
        int a=Integer.parseInt("10a");
        out.println("value::"+a); 
    </jsp:scriptlet>
    
 </c:catch>
<c:out value="${e}"/>