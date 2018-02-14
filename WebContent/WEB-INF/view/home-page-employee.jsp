<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Employee Home Page</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<p>Welcome!</p><br>
			<p>Here are the actions you can do:</p><br>
			<a href="${pageContext.request.contextPath}/customer/list" class="item">List All Customers</a><br>
			<a href="${pageContext.request.contextPath}/customer/showAddForm" class="item">Register new customer</a><br>
			<a href="${pageContext.request.contextPath}/car/list" class="item">List All Cars</a><br>
			<a href="${pageContext.request.contextPath}/car/showAddForm" class="item">Register car</a><br>
		</div>
	</div>
</body>
</html>