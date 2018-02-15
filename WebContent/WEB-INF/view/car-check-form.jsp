<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Check a Car's Condition</h3>

	<form:form action="updateCar" modelAttribute="car" method="POST" class="ui form">
		<div class="field">
			<label>Licence Plate</label> 
			<form:input path="licencePlate"/>
		</div>
		<div class="field">
			<label>Condition</label>
			<form:input path="condition" value="average"/>
		</div>
		<button class="ui button" type="submit">Submit</button>
	</form:form>

</div>