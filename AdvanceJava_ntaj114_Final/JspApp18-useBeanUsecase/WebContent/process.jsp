<%@page import="com.nt.service.*,com.nt.dto.*" %>

   <!-- create/locate DTO class object -->
   <jsp:useBean id="dto" class="com.nt.dto.EmployeeDTO" scope="request"/>
   <!-- Set form data to bean(dto) properties -->
   <jsp:setProperty name="dto" property="*"/>
   <!-- Invoke service class methods -->
   <jsp:useBean id="service"  class="com.nt.service.SalaryService" scope="request"/>
   <%
     service.generatePaySlip(dto);
    %>
    <br>
    <b><i> Salary Details</i></b>
    Employee number:  <jsp:getProperty name="dto"  property="eno"/><br>
    Employee name:  <jsp:getProperty name="dto"  property="ename"/><br>
    Employee salary:  <jsp:getProperty name="dto"  property="basicSalary"/><br>
    Employee Gross salary:  <jsp:getProperty name="dto"  property="grossSalary"/><br>
    Employee Net salary:  <jsp:getProperty name="dto"  property="netSalary"/><br>
        
    
    
    
    
   
