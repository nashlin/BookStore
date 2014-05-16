<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>功能列表</title>
    
  </head>
  
  <body>
  
  	分类管理<br>
  	<a href="${pageContext.request.contextPath }/manager/addCategory.jsp" target="body">添加分类</a><br>
  	<a href="${pageContext.request.contextPath }/manager/CategoryServlet?method=list" target="body">查看分类</a>
  	<br><br><br>
   	图书管理<br>
   	<a href="${pageContext.request.contextPath }/manager/BookServlet?method=save" target="body">添加图书</a><br>
  	<a href="${pageContext.request.contextPath }/manager/BookServlet?method=list" target="body">查看分类</a>
   	<br><br><br>
   	
   	订单管理<br>
   	<a href="${pageContext.request.contextPath }/manager/OrderServlet?method=hasSend" target="body">已发货订单</a><br>
  	<a href="${pageContext.request.contextPath }/manager/OrderServlet?method=unSend" target="body">未发货订单</a>
	<br><br><br>
  </body>
</html>
