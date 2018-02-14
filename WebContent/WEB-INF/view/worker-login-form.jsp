<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Login for worker</h3>

	<form:form action="workerLogin" modelAttribute="worker" method="POST" class="ui form">
		<div class="field">
			<label>Worker ID</label> 
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
		<button class="ui button" type="submit">Login</button>
	</form:form>
</div>