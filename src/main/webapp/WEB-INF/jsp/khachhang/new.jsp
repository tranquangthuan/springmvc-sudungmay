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
		<form:form action="${pageContext.request.contextPath}/khachhang/save"
			method="post" modelAttribute="khachHangForm">
			<table>
				<tr>
					<td><form:label path="maKH">maKH</form:label></td>
					<td><form:input path="maKH" /></td>
					<td><form:errors path="maKH" /></td>
				</tr>
				<tr>
					<td><form:label path="diaChi">diaChi</form:label></td>
					<td><form:input path="diaChi" /></td>
					<td><form:errors path="diaChi" /></td>
				</tr>
				<tr>
					<td><form:label path="diaChiEmail">diaChiEmail</form:label></td>
					<td><form:input path="diaChiEmail" /></td>
					<td><form:errors path="diaChiEmail" /></td>
				</tr>
				<tr>
					<td><form:label path="soDienThoai">soDienThoai</form:label></td>
					<td><form:input path="soDienThoai" /></td>
					<td><form:errors path="soDienThoai" /></td>
				</tr>
				<tr>
					<td><form:label path="tenKH">tenKH</form:label></td>
					<td><form:input path="tenKH" /></td>
					<td><form:errors path="tenKH" /></td>
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