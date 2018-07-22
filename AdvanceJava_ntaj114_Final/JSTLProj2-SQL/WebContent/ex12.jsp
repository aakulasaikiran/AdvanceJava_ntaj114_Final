<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!-- establish the connection -->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
                            url="jdbc:oracle:thin:@localhost:1521:xe"
                            user="system"
                            password="manager"/>
                            
<!-- send and execute SQL non-select  Query to ResultSet -->
<sql:transaction dataSource="${ds}">
  <sql:update var="count" sql="delete from student where sno=?">
    <sql:param value="1111"/>
  </sql:update>
</sql:transaction>

${count} no.of records are deleted.    


                             