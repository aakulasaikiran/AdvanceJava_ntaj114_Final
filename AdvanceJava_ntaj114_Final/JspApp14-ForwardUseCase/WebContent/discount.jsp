<h1><center> From discount.jsp</center></h1>


 <%
 //read billAmt as request param value
  float billAmt=Float.parseFloat(request.getParameter("bAmt"));
  //read form data
  String name=request.getParameter("iname");
  float price=Float.parseFloat(request.getParameter("iprice"));
  float qty=Float.parseFloat(request.getParameter("iqty"));
  //calculate 30% discount
  float discount=billAmt*0.3f;
  %>
  <h1 style="color:red;text-align:center">Bill Details</h1>
    Item name:: <%=name %> <br>
    Item Price :: <%=price %><br>
    Item Qty:: <%=qty %><br>
    Bill Amount:: <%=billAmt %><br>
    Discount ::: <%=discount %><br>
    NetBill amount::: <%=(billAmt-discount)%>
    <br>
<a href="form.html">home</a>