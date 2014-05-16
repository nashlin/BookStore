<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>showOrder</title>
    
    <script type="text/javascript">
    	function orderitem(orderid){
    		window.parent.frames.item(2).location.href="${pageContext.request.contextPath}/client/BuyServlet?method=showOrderItem&orderid="+orderid;
    	}
    </script>
  </head>
  
  <body style="text-align: center">
  
    <table border="1" width="90%">
    	<tr>
    		<th>订单人</th>
    		<th>下单时间</th>
    		<th>订单状态</th>
    		<th>订单总价</th>
    		<th>操作</th>
    	</tr>
    	
    	<c:forEach items="${orders}" var="orders">
	    	<tr>
	    		<td>${orders.user.username}</td>
	    		<td>
	    		<fmt:formatDate value="${orders.date}" pattern="yyyy-MM-dd HH:mm:ss"/>
	    		</td>
	    		<td>${orders.status==0?'未发货':'已发货'}</td>
	    		<td>${orders.totalPrice}</td>
	    		<td>
	    			<a href="javascript:orderitem('${orders.id}')">查看明细</a>
	    		</td>
	    	</tr>
    	</c:forEach>
    	
    </table>
	
  </body>
</html>
