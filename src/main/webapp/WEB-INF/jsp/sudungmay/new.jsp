<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New suDungMay</title>
</head>
<body>
	<div align="center">
		<a href="${pageContext.request.contextPath}">Home</a>
		<form:form action="${pageContext.request.contextPath}/sudungmay/save"
			method="post" modelAttribute="suDungMayForm">
			<table>
				<tr>
					<td><form:label path="id.maKH">maKH</form:label></td>
					<td><form:select path="id.maKH" items="${khachHangs}"
							itemValue="maKH" itemLabel="tenKH" /></td>
					<td><form:errors path="id.maKH" /></td>
				</tr>
				<tr>
					<td><form:label path="id.maMay">maMay</form:label></td>
					<td><form:select path="id.maMay" items="${mays}"
							itemValue="maMay" itemLabel="maMay" /></td>
					<td><form:errors path="id.maMay" /></td>
				</tr>
				<tr>
					<td><form:label path="id.ngayBatDauSuDung">ngayBatDauSuDung</form:label></td>
					<td><form:input type="date" path="id.ngayBatDauSuDung" /></td>
					<td><form:errors path="id.ngayBatDauSuDung" /></td>
				</tr>
				<tr>
					<td><form:label path="id.gioBatDauSuDung">gioBatDauSuDung</form:label></td>
					<td><form:input type="time" path="id.gioBatDauSuDung" /></td>
					<td><form:errors path="id.gioBatDauSuDung" /></td>
				</tr>
				<tr>
					<td><form:label path="thoiGianSuDung">thoiGianSuDung</form:label></td>
					<td><form:input path="thoiGianSuDung" /></td>
					<td><form:errors path="thoiGianSuDung" /></td>
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