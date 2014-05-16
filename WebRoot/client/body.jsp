<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>body</title>

	</head>

	<body style="text-align: center">

		<div align="center">
			<table width="80%" align="center">
			<c:forEach items="${page.list}" var="book">
				<tr>
					<td>
						<table>
							<tr>
								<td rowspan="4">
									<img alt=""
										src="${pageContext.request.contextPath }/images/${book.image }">
								</td>
								<td>
									<li>${book.name }</li>
								</td>
							</tr>
							<tr>
								<td>
									<li>${book.author }</li>
								</td>
							</tr>
							<tr>
								<td>
									<li>${book.price }</li>
								</td>
							</tr>
							<tr>
								<td>
									<a href="${pageContext.request.contextPath }/client/BuyServlet?method=buy&bookid=${book.id }">购买</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</c:forEach>

			<!-- 分页 -->
			<tr>
				<td>
						共${page.totalPage }页&nbsp;&nbsp;
			    		当前第${page.currentPage }页&nbsp;&nbsp;
			    		<c:forEach end="${page.totalPage}" begin="1" var="num">
			    			[<a href="${pageContext.request.contextPath }/client/IndexServlet?method=listBook&categoryid=${categoryid}&currentPage=${num }">${num }</a>]
			    		</c:forEach>
			    		&nbsp;&nbsp;
			    		每页${page.pageSize }条记录&nbsp;&nbsp;
			    		总共${page.totalRecord }条记录
				</td>
			</tr>
		</table>
		</div>

	</body>
</html>
