<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>register</title>
    
  </head>
  
  <body style="text-align: center;">
  
    <form action="${pageContext.request.contextPath }/client/UserServlet?method=register" method="post" target="header">
    	<table border="1" width="70%">
    		<tr>
    			<th>用户名</th>
    			<td>
    				<input type="text" name="username">
    			</td>
    		</tr>
    		<tr>
    			<th>密码</th>
    			<td>
    				<input type="password" name="password">
    			</td>
    		</tr>
    		<tr>
    			<th>手机</th>
    			<td>
    				<input type="text" name="cellphone">
    			</td>
    		</tr>
    		<tr>
    			<th>住址</th>
    			<td>
    				<input type="text" name="address">
    			</td>
    		</tr>
    		<tr>
    			<th>邮箱</th>
    			<td>
    				<input type="text" name="email">
    			</td>
    		</tr>
    		<tr>
    			<th>操作</th>
    			<td>
    				<input type="submit" value="注册">
    			</td>
    		</tr>
    	</table>
    </form>
	
  </body>
</html>
