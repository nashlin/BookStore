<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>showCustomerOrderItem</title>
    
  </head>
  
  <body style="text-align: center;">
  
  	<h3>您的订单明细如下：</h3>
    <table border="1" width="80%">
    	<tr>
    		<th>书名</th>
    		<th>售价</th>
    		<th>数量</th>
    		<th>应付款项</th>
    	</tr>
    	
    	<c:forEach items="${list}" var="orderItem">
	    	<tr>
	    		<td>${orderItem.book.name }</td>
	    		<td>${orderItem.book.price }元</td>
	    		<td>${orderItem.num }</td>
	    		<td>${orderItem.price }</td>
	    	</tr>
	    </c:forEach>
	    
	    <tr>
	    	<td colspan="2">总计应付款项</td>
	    	<td colspan="2">${orders.totalPrice }</td>
	    </tr>
    </table>
	
	<br/><br/><br/>
	<h3>收货人详细地址：</h3>
	
	<table border="1" width="80%">
    	<tr>
    		<th>用户名</th>
    		<th>手机</th>
    		<th>地址</th>
    		<th>邮箱</th>
    	</tr>
   	
    	<tr>
    		<td>${sessionScope.user.username }</td>
    		<td>${sessionScope.user.cellphone }</td>
    		<td>${sessionScope.user.address }</td>
    		<td>${sessionScope.user.email }</td>
    	</tr>
	 </table>
	 <br/><br/>
  </body>
</html>
