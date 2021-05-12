<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title><spring:message code="login.title"></spring:message></title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

<link href="css/loginCss.css" rel="stylesheet" />

<!-- Bootstrap CSS  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

<!-- JQUERY -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>

<!-- MDBootstrap Datatables JS  -->
<script type="text/javascript" src="js/addons/datatables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/v/dt/dt-1.10.24/datatables.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.colVis.min.js"></script>
<!-- Font awesome -->
<link href="\C:\Users\afpa\Documents\fontawesome/css/all.css"
	rel="stylesheet">
<!--load all styles -->
</head>
<body>
	
	<%@ include file="/WEB-INF/resources/Include/navbar.jsp"%>



	<div class="login-dark">
		<form:form action="accueil" method="post" modelAttribute="compte">

			<div class="illustration">
				<i class="icon ion-ios-locked-outline"></i>
			</div>

			<spring:message var="placeholderLog" code="login.placeholderLogin"></spring:message>
			<div class="form-group">
				<form:input class="form-control" path="login" type="text"
					placeholder='${placeholderLog}'></form:input>
			</div>

			<spring:message var="placeholderMdp" code="login.placeholderMdp"></spring:message>
			<div class="form-group">
				<form:input class="form-control" path="password" type="password"
					placeholder='${placeholderMdp}'></form:input>
			</div>

			<div class="form-group">
				<input type="submit"
					value="<spring:message code="login.connexion"></spring:message>"
					class="btn btn-primary btn-block">
			</div>
			<a href="#" class="forgot"><spring:message code="login.mdpOublie"></spring:message></a>
		</form:form>
	</div>


</body>

</html>