<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>List of Customers</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>AFM___________</th>
					<th>Username________</th>
					<th>Password________</th>
					<th>First Name______</th>
					<th>Last Name_______</th>
					<th>Worker ID</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">

					<tr>
						<td> ${tempCustomer.afm} </td>
						<td> ${tempCustomer.username} </td>
						<td> ${tempCustomer.password} </td>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.workerID} </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>