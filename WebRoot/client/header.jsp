<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>header</title>
    
    <script type="text/javascript">
    	function register(){
    		window.parent.frames.item(2).location.href="${pageContext.request.contextPath}/register.jsp";
    	}
    	function index(){
    		window.parent.frames.item(2).location.href="${pageContext.request.contextPath}/client/IndexServlet?method=listBook";
    	}
    	function cart(){
    		window.parent.frames.item(2).location.href="${pageContext.request.contextPath}/client/BuyServlet?method=listCart";
    	}
    	function order(userid){
    		window.parent.frames.item(2).location.href="${pageContext.request.contextPath}/client/BuyServlet?method=listOrder&userid="+userid;
    	}
    </script>
  </head>
  
  <body style="text-align: center;">
  
   <h1>斌斌小书店</h1>
		<c:if test="${empty sessionScope.user}">
			<form action="${pageContext.request.contextPath }/client/UserServlet?method=login" method="post">
				用户名：<input type="text" name="username">
				密码：<input type="password" name="password">
				<input type="submit" value="登陆">
			<input type="button" value="注册" onclick="register()">
			</form>
		</c:if>
		<c:if test="${!empty sessionScope.user}">
			<a href="javascript:index()">首页</a>
			<a href="javascript:cart()">查看购物车</a>
			<a href="javascript:order('${sessionScope.user.id }')">查看订单</a>
			欢迎您：${sessionScope.user.username }&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }/client/UserServlet?method=loginOut">注销</a>
		</c:if>
  </body>
</html>
