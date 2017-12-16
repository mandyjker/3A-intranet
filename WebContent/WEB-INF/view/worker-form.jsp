<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Worker</h3>

	<form:form action="saveWorker" modelAttribute="worker" method="POST" class="ui form">
		<div class="field">
			<label>ID</label> 
			<form:input path="id"/>
		</div>
		<div class="field">
			<label>Username</label> 
			<form:input path="username"/>
		</div>
		<div class="field">
			<label>Password</label> 
			<form:input path="password"/>
		</div>
		<div class="field">
			<label>First Name</label> 
			<form:input path="firstName"/>
		</div>
		<div class="field">
			<label>Last Name</label>
			<form:input path="lastName"/>
		</div>
		<button class="ui button" type="submit">Save</button>
	</form:form>

</div>