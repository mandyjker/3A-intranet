<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Login for worker</h3>

	<form:form action="workerLogin" method="POST" class="ui form">
		<div class="field">
			<label>Worker ID</label> 
			<input type="text" path="id"/>
		</div>
		<div class="field">
			<label>Username</label> 
			<input type="text" name="username" path="username"/>
		</div>
		<div class="field">
			<label>Password</label> 
			<input type="password" name="password" path="password"/>
		</div>
		<button class="ui button" type="submit">Login</button>
	</form:form>
</div>