
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="msg" value="hello how are u"/>

uppercase : ${fn:toUpperCase(msg)}<br>
lowercase : ${fn:toLowerCase(msg)}<br>
length :  ${fn:length(msg)}<br>
subString :  ${fn:substring(msg,2,6)}<br>
index of hello :  ${fn:indexOf(msg,"hello")}<br>
starts with hello :  ${fn:startsWith(msg,"hello")}<br>
starts with u :  ${fn:endsWith(msg,"u")}<br>