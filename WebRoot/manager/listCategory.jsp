<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>listCategory</title>
 
 <script type="text/javascript">
 	function del(id){
 		if(window.confirm("确定删除？")){
 			window.location.href="${pageContext.request.contextPath }/manager/CategoryServlet?method=delete&id="+id;
 		}
 	}
 	
 </script>
 
  </head>
  
  <body style="text-align: center;">
  
    <form action="" method="post">
    
    	<table border="1" width="70%">
    		<tr>
    			<th>分类名称</th>
    			<th>分类描述</th>
    			<th>分类操作</th>
    		</tr>
    		<c:forEach items="${list}" var="list">
    		<tr>
    			<td>${list.name }</td>
    			<td>${list.description }</td>
    			<td>
    				<a href="${pageContext.request.contextPath }/manager/CategoryServlet?method=update&id=${list.id }" target="body">修改</a>
    				<a href="javascript:void(0)" onclick="del('${list.id }')">删除</a>
    			</td>
    		</tr>
    		</c:forEach>
    	</table>
    </form>
	
  </body>
</html>
