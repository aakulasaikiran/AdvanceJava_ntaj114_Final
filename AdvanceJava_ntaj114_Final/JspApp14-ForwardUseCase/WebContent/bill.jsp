
<% //read form data
  String name=request.getParameter("iname");
  float price=Float.parseFloat(request.getParameter("iprice"));
  float qty=Float.parseFloat(request.getParameter("iqty"));
  //calcualate bill Amount
  float billAmt=price*qty;
  //if billAmt is >=50000 forward it to discount.jsp
  if(billAmt>=50000){ %>
    <jsp:forward page="discount.jsp">
      <jsp:param name="bAmt" value="<%=billAmt%>"/>
    </jsp:forward>
   <% } 
    else{ %>
    <h1 style="color:red;text-align:center"> Bill Details</h1> 
     Item name::: <%=name %> <br>
     Item price ::: <%=price %><br>
     Qty::: <%=qty %> <br>
     Bill amount ::: <%=billAmt %><br>
     <a href="form.html">home</a>
  <%}
     %>    
  