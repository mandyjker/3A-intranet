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
			<h2>List of Cars</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Licence Plate__</th>
					<th>Model__________</th>
					<th>Fuel Type______</th>
					<th>Year___________</th>
					<th>Condition______</th>
					<th>Reward_________</th>
					<th>Worker_ID______</th>
					<th>Customer AFM</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempCar" items="${cars}">

					<tr>
						<td> ${tempCar.licencePlate} </td>
						<td> ${tempCar.model} </td>
						<td> ${tempCar.fuelType} </td>
						<td> ${tempCar.year} </td>
						<td> ${tempCar.condition} </td>
						<td> ${tempCar.reward} </td>
						<td> ${tempCar.workerID} </td>
						<td> ${tempCar.customerAFM} </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>