<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	margin: 0 auto;
	border-collapse: collapse;
	width: 50%;
}

th {
	text-align: left;
	background: #4a87e8;
    color: white;
}

th, td {
	padding: 10px; /* to add space within each cell */
	border: 1px solid black; /* to add borders to the cells */
}
</style>

<script type="text/javascript">
function showPopup(name) {
    alert("I am " + name);
}
</script>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h2>Welcome, ${userId}</h2>
	<table>
		<tr>
			<th>Department</th>
			<th>Student ID</th>
			<th>Marks</th>
			<th>Pass %</th>
		</tr>
		<c:forEach items="${studentInfoMap}" var="map">
			<c:forEach items="${map.value}" var="info" varStatus="loop">
				<tr>
					<c:if test="${loop.index == 0}">
						<td rowspan="${fn:length(map.value)}" style="text-align: center;"><c:out
								value="${map.key}"></c:out></td>
					</c:if>
					<td><a href="#" onclick="showPopup('${info.studentName}'); return false;"><c:out value="${info.studentId}"></c:out></a></td>
					<td style="text-align: right;"><c:out value="${info.mark}"></c:out></td>
					<td style="text-align: center;"><c:out value="${info.passingRate}"></c:out></td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
</body>
</html>