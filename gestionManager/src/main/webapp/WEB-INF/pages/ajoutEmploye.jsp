<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/ajoutEmploye.css">


<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

<!-- Bootstrap CSS  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

<!-- Font awesome -->
<link href="\C:\Users\afpa\Documents\fontawesome/css/all.css"
	rel="stylesheet">
<!--load all styles -->



<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.slim.min.js"
	integrity="sha512-6ORWJX/LrnSjBzwefdNUyLCMTIsGoNP6NftMy2UAm1JBm6PRZCO1d7OHBStWpVFZLO+RerTvqX/Z9mBFfCJZ4A=="
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- JQUERY -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>


</head>
<body>
	<%@ include file="/WEB-INF/resources/Include/navbarConnecte.jsp"%>
	<div class="tit">Formulaire d'enregistrement</div>
	<div class="gen2">
		<form:form action="ajoutEmploye" method="post" modelAttribute="emp">

			<div class="row mb-4 inpu">

				<div class="col">
					<div class="form-outline">
					  <spring:message code="emp.placeholderName" var="placeholderName"/> 
						<form:input type="text" id="form6Example2" path="firstName" class="form-control" placeholder='${placeholderName}'/> 
						<label class="info" class="form-label" for="form6Example2"><spring:message code="emp.nom" /></label>
					</div>
				</div>
			</div>

			<div class="form-outline mb-4">
			<spring:message code="emp.placeholderPrenom" var="placeholderPrenom" />
				<form:input type="text" id="form6Example5" path="lastName" class="form-control" placeholder='${placeholderPrenom }' /> 
				<label class="info" class="form-label" for="form6Example5"><spring:message code="emp.prenom" /></label>
			</div>

			<div class="form-outline mb-4">
			<spring:message code="emp.placeholderDate" var="placeholderDate"/>
				<form:input type="date" id="form6Example5" path="startDate" class="form-control" placeholder='${placeholderDate }' />
				 <label class="info" class="form-label" for="form6Example5"><spring:message code="emp.date" /></label>
			</div>

			<div class="form-outline mb-4">
			<spring:message code="emp.placeholderTitle" var="placeholderTitle" />
				<form:input type="text" id="tit" path="title" class="form-control" placeholder='${placeholderTitle }' /> 
				<label class="info" class="form-label" for="tit"><spring:message code="emp.titre" /></label>
			</div>
				
			
				<form:select path="manager" class="form-select" aria-label="Default select example">
				<form:option value="NONE" label="--- Choix manager ---"/>
				<c:forEach  items="${employees}" var="employee">
				<form:option  value="${employee.empId}" var="id"/>
				
			    </c:forEach>
			    <form:hidden path="manager" value="${id}" />
				</form:select>
			
			<!-- Submit button -->
			
			<div class="save">
				<button type="submit" class="btn btn-primary btn-block mb-4">Enregistrer</button>
			</div>
			
		</form:form>
	</div>

</body>

</html>