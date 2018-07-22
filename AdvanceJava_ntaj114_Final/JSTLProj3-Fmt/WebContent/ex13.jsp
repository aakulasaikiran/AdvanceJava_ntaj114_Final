
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

 <!-- set Locale -->
 <fmt:setLocale value="fr-FR"/>
 
 <!-- Format the number -->
 <fmt:formatNumber var="fnumber" value="3000000000"/>
 formatted number:: ${fnumber}. 
 
 <!-- Format the date -->
  <jsp:useBean id="dt" class="java.util.Date"/>
 <fmt:formatDate var="fdate" value="${dt}"/>
<br>formatted date:: ${fdate}.

 <!-- Locate propperties file -->
 <fmt:setBundle basename="com/nt/commons/myfile"/>
 <!-- format the messages -->
 <fmt:message var="fmsg" key="wishMsg"/>
 <br>
  Formatted message :: ${fmsg}
