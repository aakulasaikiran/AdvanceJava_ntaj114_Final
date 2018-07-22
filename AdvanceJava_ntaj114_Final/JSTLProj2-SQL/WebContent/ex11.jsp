<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!-- establish the connection -->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
                            url="jdbc:oracle:thin:@localhost:1521:xe"
                            user="system"
                            password="manager"/>
 <!-- send and execute non-select SQL Query -->
 <sql:update dataSource="${ds}" var="count" sql="update emp set sal=sal+? where empno=?">
   <sql:param value="1000"/>
   <sql:param>7499</sql:param>
 </sql:update>
 
 ${count} no.of records are updated.
 
 
                             