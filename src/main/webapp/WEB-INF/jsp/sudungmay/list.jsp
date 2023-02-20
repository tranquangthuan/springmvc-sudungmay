<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}

table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 50%;
}

td {
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>

	<div align="center">
		<a href="add">Add sử dụng máy</a> <a
			href="${pageContext.request.contextPath}">Home</a>
		<div>
			<form action="${pageContext.request.contextPath}/product/search"
				method="get">
				<input type="text" name="searchKey"> <input type="submit"
					value="Search">
			</form>
		</div>
		<table>
			<thead>
				<tr>
					<th width="10%">maKH</th>
					<th width="10%">tenKH</th>
					<th width="20%">maMay</th>
					<th width="20%">viTri</th>
					<th width="10%">ngayBatDauSuDung</th>
					<th width="20%">gioBatDauSuDung</th>
					<th width="20%">thoiGianSuDung</th>
					<th width="20%">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${suDungMays}" varStatus="status">
					<tr>
						<td>${i.id.maKH}</td>
						<td>${i.khachHang.tenKH}</td>
						<td>${i.id.maMay}</td>
						<td>${i.may.viTri}</td>
						<td>${i.id.ngayBatDauSuDung}</td>
						<td>${i.id.gioBatDauSuDung}</td>
						<td>${i.thoiGianSuDung}</td>
						<td><a
							href="delete?maKH=${i.id.maKH}&maMay=${i.id.maMay}&ngayBatDauSuDung=${i.id.ngayBatDauSuDung}&gioBatDauSuDung=${i.id.gioBatDauSuDung}">Delete</a>
							<a
							href="update/?maKH=${i.id.maKH}&maMay=${i.id.maMay}&ngayBatDauSuDung=${i.id.ngayBatDauSuDung}&gioBatDauSuDung=${i.id.gioBatDauSuDung}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />

		<div class="pagination">
			<c:if test="${currentPage > 1}">
				<a href="list?page=${currentPage-1}">Previous</a>
			</c:if>
			<c:forEach begin="1" end="${totalPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<a class="active"> ${i} </a>
					</c:when>
					<c:otherwise>
						<a href="list?page=${i}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${currentPage lt totalPages}">
				<a href="list?page=${currentPage+1}">Next</a>
			</c:if>
		</div>
	</div>
</body>
</html>