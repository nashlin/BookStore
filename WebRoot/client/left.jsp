<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>left</title>
    
  </head>
  
  <body>
  	<h3>图书类型</h3>
   <ul>
   		<c:forEach items="${category}" var="list">
   			<li><a href="${pageContext.request.contextPath }/client/IndexServlet?method=listBook&categoryid=${list.id }&currentPage=${num }" target="body">${list.name }</a></li>
   		</c:forEach>
   </ul>
	
  </body>
</html>
