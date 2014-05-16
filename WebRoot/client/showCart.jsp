<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>showCart</title>
    
  </head>
  
  <body style="text-align: center;">
  
  	<h1>购物车信息</h1>
    <table border="1" width="80%">
    	<tr>
    		<th>书名</th>
    		<th>单价</th>
    		<th>数目</th>
    		<th>小计</th>
    	</tr>
    	
    	<c:forEach items="${sessionScope.cart.map}" var="cart">
    	<tr>
    		<td>${cart.value.book.name }</td>
    		<td>${cart.value.book.price}</td>
    		<td>${cart.value.num}</td>
    		<td>${cart.value.price }</td>
    	</tr>
    	</c:forEach>
    	<tr>
    		<td colspan="2">总计</td>
    		<td colspan="2">${cart.totalPrice }</td>
    	</tr>
    	<tr>
    		<td colspan="4">
    			<a href="${pageContext.request.contextPath }/client/UserServlet?method=createOrder">生成订单</a>
    		</td>
    	</tr>
    </table>
	
  </body>
</html>
