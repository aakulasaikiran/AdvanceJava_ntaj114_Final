<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!-- establish the connection -->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
                            url="jdbc:oracle:thin:@localhost:1521:xe"
                            user="system"
                            password="manager"/>
<!-- send and execute SQL select Query to ResultSet -->
<sql:query var="rs" dataSource="${ds}" sql="select * from emp"/>

<!--process the ResultSEt  -->
<c:forEach var="row" items="${rs.rows}">
  ${row.empno } &nbsp;&nbsp; ${row.ename }   &nbsp;&nbsp; ${row.sal}<br>

</c:forEach>


                             