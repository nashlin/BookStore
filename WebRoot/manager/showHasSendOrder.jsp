<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>showHasSendOrder</title>
    
  </head>
  
  <body style="text-align: center;">
  
   <table border="1" width="90%">
   		<tr>
   			<th>订单人</th>
   			<th>下单时间</th>
   			<th>订单状态</th>
   			<th>总价</th>
   			<th>操作</th>
   		</tr>
   		
   		<c:forEach items="${list}" var="list">
   			<tr>
   				<td>${list.user.username }</td>
   				<td>${list.date }</td>
   				<td>已发货</td>
   				<td>${list.totalPrice }</td>
   				<td>
   					<a href="${pageContext.request.contextPath }/manager/OrderServlet?method=showOrderItem&orderid=${list.id }">查看明细</a>
   				</td>
   			</tr>
   		</c:forEach>
   </table>
	
  </body>
</html>
