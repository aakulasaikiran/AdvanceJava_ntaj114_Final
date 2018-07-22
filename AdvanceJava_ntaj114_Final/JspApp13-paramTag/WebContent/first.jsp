
<%String bkName="CRJ";%>

<jsp:forward page="second.jsp">
 <jsp:param name="bookId" value="1001"/>
 <jsp:param name="bookName" value="<%=bkName%>"/>
</jsp:forward>