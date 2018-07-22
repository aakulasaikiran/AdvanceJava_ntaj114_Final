<%@page import="java.util.*,com.nt.dto.BookDTO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script language="JavaScript">
  function showPrint(){
    frames.focus();
    frames.print();
  }

</script>

<%-- <%
   //read ListDTO from request scoe
   List<BookDTO> listDTO=(List<BookDTO>)request.getAttribute("booksListDTO");
   
   if(listDTO!=null){ 
   %>
    <h1> Books beloging to category:: <%=request.getParameter("category") %></h1>
    
      <table border="1" width="70%" height="70%" bgcolor="cyan">
       <tr style="color:blue"><th>BookId</th><th>BookName</th><th>Author</th><th>status</th><th>Category</th>
     <%
       for(BookDTO dto:listDTO){ %>
         <tr style="color:red">
           <td><%=dto.getBookId() %></td>
           <td><%=dto.getBookName() %></td>
           <td><%=dto.getAuthor()%></td>
           <td><%=dto.getStatus()%></td>
           <td><%=dto.getCategory()%></td> 
        </tr>
     <%
      }//for
     }//if
     else{
        %>
       <h1>Records not found</h1>     
      <%} %>
     </table>
  <br><br>
    <a href="javascript:showPrint()">print</a>
     --%>
<h1 style="color:red;text-align:center">Book Details</h1>

<b>Books belonging to category=${param.category}<br>

<c:choose>
 <c:when test="${!empty booksListDTO }">
   <table border="1">
    <tr><th>Id</th><th>BookName</th><th>Author</th><th>status</th><th>Category</th></tr>
    <c:forEach var="dto" items="${booksListDTO}" >
       <tr>
         <td>${dto.bookId}</td>
         <td>${dto.bookName}</td>
         <td>${dto.author}</td>
         <td>${dto.status}</td>
         <td>${dto.category}</td>
    </c:forEach>
   </table>
   <a href="javascript:showPrint()">print</a>
 </c:when>
  <c:otherwise>Books not Found  </c:otherwise>
</c:choose>     
