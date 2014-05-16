<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>后台主页</title>
    
  </head>
  
	<frameset rows="20%,*">
		<frame src="${pageContext.request.contextPath }/manager/header.jsp" name="header">
		<frameset cols="20%,*">
			<frame src="${pageContext.request.contextPath }/manager/left.jsp" name="left">
			<frame src="${pageContext.request.contextPath }/manager/body.jsp" name="body">
		</frameset>
	</frameset>
</html>
