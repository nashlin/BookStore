<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>listBook</title>
    
  </head>
  
  <body style="text-align: center;">
  			<h1>图书信息</h1>
    <div align="center">
    	<table border="1" width="80%">
    	<tr>
    		<th>书名</th>
    		<th>作者</th>
    		<th>售价</th>
    		<th>图片</th>
    		<th>描述</th>
    		<th>操作</th>
    	</tr>
    	
    	<c:forEach items="${page.list}" var="book">
    		<tr>
    		<td>${book.name }</td>
    		<td>${book.author }</td>
    		<td>${book.price }</td>
    		<c:url var="url" value="/manager/BookServlet?method=listImage&imageName=${book.image }"></c:url>
    		<td>
    		<a href="${url }" target="body">${book.oldname }</a>
    		</td>
    		<td>${book.description }</td>
    		<td>
    			<a href="${pageContext.request.contextPath }/manager/BookServlet?method=showUpdate&id=${book.id }">修改</a>
    			<a href="${pageContext.request.contextPath }/manager/BookServlet?method=delete&id=${book.id }">删除</a>
    		</td>
    	</tr>
    	</c:forEach>
    </table><br/><br/>
    	
    		共${page.totalPage }页&nbsp;&nbsp;
    		当前第${page.currentPage }页&nbsp;&nbsp;
    		<c:forEach end="${page.totalPage}" begin="1" var="num">
    			[<a href="${pageContext.request.contextPath }/manager/BookServlet?method=list&currentPage=${num }">${num }</a>]
    		</c:forEach>
    		&nbsp;&nbsp;
    		每页${page.pageSize }条记录&nbsp;&nbsp;
    		总共${page.totalRecord }条记录
    	
	
    </div>
  </body>
</html>
