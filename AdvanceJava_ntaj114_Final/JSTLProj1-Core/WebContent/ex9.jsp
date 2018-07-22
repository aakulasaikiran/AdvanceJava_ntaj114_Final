<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="wishMsg" value="hello how are u?"/>

<c:forTokens var="token" items="${wishMsg}" delims="o">
  ${token} <br>
</c:forTokens>