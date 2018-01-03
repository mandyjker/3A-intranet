<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Register a new Customer</h3>

	<form:form action="updateCustomer" modelAttribute="customer" method="POST" class="ui form">
		<div class="field">
			<label>AFM</label> 
			<form:input path="afm"/>
		</div>
		<div class="field">
			<label>First Name</label> 
			<form:input path="firstName"/>
		</div>
		<div class="field">
			<label>Last Name</label>
			<form:input path="lastName"/>
		</div>
		<div class="field">
			<label>Worker ID</label>
			<form:input path="workerID"/>
		</div>
		<button class="ui button" type="submit">Submit</button>
	</form:form>

</div>