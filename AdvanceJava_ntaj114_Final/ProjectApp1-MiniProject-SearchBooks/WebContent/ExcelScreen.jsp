<%@page import="java.util.*,com.nt.dto.BookDTO"%>




<%
   response.setContentType("application/vnd.ms-excel");
   response.addHeader("Content-Disposition","attachment;fileName=books.xls");
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
    
    