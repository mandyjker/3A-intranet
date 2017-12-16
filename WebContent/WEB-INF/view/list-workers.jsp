<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Workers</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>WRM - Worker Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Password</th>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempWorker" items="${workers}">

					<tr>
						<td>${tempWorker.id}</td>
						<td>${tempWorker.username}</td>
						<td>${tempWorker.password}</td>
						<td>${tempWorker.firstName}</td>
						<td>${tempWorker.lastName}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>