

<table width="100%" height="100%" rows="3" cols="3">
  <tr >
    <td colspan="3">
      <jsp:include page="/headurl"/>
    </td>
  </tr>
  <tr>
   <td><%@include file="left_content.html"%></td>
   <td><jsp:include page="home.jsp"/></td>
   <td>
    <table rows="2" cols="1">
      <tr>
        <td><jsp:include page="horoscope.jsp"/></td>
      </tr>
       <tr>
        <td><jsp:include page="weather.jsp"/></td>
      </tr>
    </table>
   </td>
   <tr >
     <td colspan="3"><%@include file="footer.html"%> </td>
   </tr>
</table>