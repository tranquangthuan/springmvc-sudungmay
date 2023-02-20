<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<div align="center">
		<a href="${pageContext.request.contextPath}">Home</a>
		<form:form action="${pageContext.request.contextPath}/may/save"
			method="post" modelAttribute="mayForm">
			<table>
				<tr>
					<td><form:label path="maMay">maMay</form:label></td>
					<td><form:input path="maMay" /></td>
					<td><form:errors path="maMay" /></td>
				</tr>
				<tr>
					<td><form:label path="trangThai">trangThai</form:label></td>
					<td><form:input path="trangThai" /></td>
					<td><form:errors path="trangThai" /></td>
				</tr>
				<tr>
					<td><form:label path="viTri">viTri</form:label></td>
					<td><form:input path="viTri" /></td>
					<td><form:errors path="viTri" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button value="Add">Add</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>