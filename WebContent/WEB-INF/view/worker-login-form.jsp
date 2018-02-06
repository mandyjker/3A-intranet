<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Login for worker</h3>

	<form:form action="workerLogin" method="POST" class="ui form">
		<c:if test="${param.error != null}">
                <i>Sorry! Invalid username/password!</i>
        </c:if>
		<div class="field">
			<label>Worker ID</label> 
			<form:input type="text" path="id"/>
		</div>
		<div class="field">
			<label>Username</label> 
			<form:input type="text" name="username" path="username"/>
		</div>
		<div class="field">
			<label>Password</label> 
			<form:input type="password" name="password" path="password"/>
		</div>
		<button class="ui button" type="submit">Login</button>
	</form:form>
</div>