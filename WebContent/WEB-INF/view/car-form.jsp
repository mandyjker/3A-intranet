<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Add a Car</h3>

	<form:form action="saveCar" modelAttribute="car" method="POST" class="ui form">
		<div class="field">
			<label>License Plate</label> 
			<form:input path="licencePlate"/>
		</div>
		<div class="field">
			<label>Model</label> 
			<form:input path="model"/>
		</div>
		<div class="field">
			<label>Fuel Type</label> 
			<form:input path="fuelType"/>
		</div>
		<div class="field">
			<label>Year</label> 
			<form:input path="year"/>
		</div>
		<div class="field">
			<label>Worker ID</label>
			<form:input path="workerID"/>
		</div>
		<div class="field">
			<label>Customer AFM</label>
			<form:input path="customerAFM"/>
		</div>
		<button class="ui button" type="submit">Submit</button>
	</form:form>

</div>