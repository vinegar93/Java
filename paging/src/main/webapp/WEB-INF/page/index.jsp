<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>paging</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>age</th>
				<th>birth</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td colspan="4">
					第${pb.pc }页/共${pb.tp }页
					<a href="<c:url value="/user/index.action" />?pc=1">首页</a>
					<c:if test="${pb.pc > 1 }">
						<a href="<c:url value="/user/index.action" />?pc=${pb.pc - 1 }">上一页</a>
					</c:if>
					<%-- 计算begin、end --%>
					<c:choose>
						<%-- 如果总页数不足10页，那么把所有的页数都显示出来！ --%>
						<c:when test="${pb.tp <= 10 }">
							<c:set var="begin" value="1" />
							<c:set var="end" value="${pb.tp }" />
						</c:when>
						<c:otherwise>
							<%-- 当总页数>10时，通过公式计算出begin和end --%>
							<c:set var="begin" value="${pb.pc-5 }" />
							<c:set var="end" value="${pb.pc+4 }" />	
							<%-- 头溢出 --%>
							<c:if test="${begin < 1 }">
								<c:set var="begin" value="1" />
								<c:set var="end" value="10" />
							</c:if>	
							<%-- 尾溢出 --%>
							<c:if test="${end > pb.tp }">
								<c:set var="begin" value="${pb.tp - 9 }" />
								<c:set var="end" value="${pb.tp }" />
							</c:if>	
						</c:otherwise>
					</c:choose>
					<%-- 循环遍历页码列表 --%>
					<c:forEach var="i" begin="${begin }" end="${end }">
						<c:choose>
							<c:when test="${i eq pb.pc }">
								[${i }]
							</c:when>
							<c:otherwise>
								<a href="<c:url value="/user/index.action" />?pc=${i}">[${i }]</a>	
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pb.pc < pb.tp }">
						<a href="<c:url value="/user/index.action" />?pc=${pb.pc + 1 }">下一页</a>
					</c:if>
					<a href="<c:url value="/user/index.action" />?pc=${pb.tp }">尾页</a>
				</td>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach items="${pb.list }" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.age }</td>
					<td><fmt:formatDate value="${user.birth }" pattern="yyyy/MM/dd HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>