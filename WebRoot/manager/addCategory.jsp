<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>listCategory</title>
    
  </head>
  
  <body>
  
   	<form action="${pageContext.request.contextPath }/manager/CategoryServlet?method=add" method="post">
   			<table border="1">
   				<tr>
   					<td>分类名称：</td>
   					<td><input type="text" name="name"></td>
   				</tr>
   				<tr>
   					<td>分类描述：</td>
   					<td><textarea rows="20" cols="70" name="description"></textarea></td>
   				</tr>
   				<tr>
   					<td>添加分类：</td>
   					<td><input type="submit" value="添加"></td>
   				</tr>
   			</table>
   	</form>
	
  </body>
</html>
