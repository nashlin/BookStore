<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>updateBook</title>
    
  </head>
  
   <body style="text-align: center">
  
    <form action="${pageContext.request.contextPath }/manager/BookServlet?method=update&id=${book.id }" method="post" enctype="multipart/form-data">
    	<table border="1" width="70%">
    		<tr>
    			<td>书名</td>
    			<td>
    				<input type="text" name="name" value="${book.name }">
    			</td>
    		</tr>
    		<tr>
    			<td>作者</td>
    			<td>
    				<input type="text" name="author" value="${book.author }">
    			</td>
    		</tr>
    		<tr>
    			<td>售价</td>
    			<td>
    				<input type="text" name="price" value="${book.price }">
    			</td>
    		</tr>
    		<tr>
    			<td>图片</td>
    			<td>
    				<input type="file" name="image">
    			</td>
    		</tr>
    		<tr>
    			<td>描述</td>
    			<td>
    				<textarea rows="5" cols="50" name="description">${book.description }</textarea>
    			</td>
    		</tr>
    		<tr>
    			<td>分类</td>
    			<td>
    				<select name="category">
    					<c:forEach items="${list}" var="list">
    						<option value="${list.id }">${list.name }</option>
    					</c:forEach>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>添加图书</td>
    			<td>
    				<input type="submit" value="修改">
    			</td>
    		</tr>
    	</table>
    </form>
	
  </body>
</html>
