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
</head>
    <link rel="stylesheet" href="css/parametre.css">

<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">


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

<!-- MDBootstrap Datatables CSS  -->
<link href="css/addons/datatables.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">


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

<!-- MDBootstrap Datatables JS  -->
<script type="text/javascript" src="js/addons/datatables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/v/dt/dt-1.10.24/datatables.min.js"></script>
<script
	src="https://cdn.datatables.net/buttons/1.5.1/js/buttons.colVis.min.js"></script>
<body>
	<%@ include file="/WEB-INF/resources/Include/navbarConnecte.jsp"%>
	<form:form action="parametres" method="post" modelAttribute="emp">
<div class="global">
        <div class="table-responsive ticketList">
            <table id="dtBasicExample" class="table table-striped table-bordered table-sm table" cellspacing="0"
                width="100%">
                <thead>
                    <tr>
                        
                        <th class="th-sm">Nom

                        </th>
                        <th class="th-sm">Prenom

                        </th>
                        <th class="th-sm">Date début

                        </th>
                        <th class="th-sm">Titre

                        </th>
                        <th class="th-sm">Choix Manager

                        </th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${parametres}" var="emp">
					<tr>
						<td>${emp.firstName}</td>
						<td>${emp.lastName }</td>
						<td>${emp.startDate }</td>
						<td>${emp.title }</td>
						<td>
						<form:select path="manager" class="form-select" aria-label="Default select example">
						<form:option value="NONE" label="--- Choix manager ---"/>
						<c:forEach  items="${managers}" var="manager">
						<form:option  value="${manager.firstName} ${manager.lastName}" var="id"/>
				
			   			 </c:forEach>
			    		<form:hidden path="manager" value="${id}" />
						</form:select>
						
						
						
						
						</td>
						
					</tr>
				</c:forEach>
                 </tbody>
                <tfoot>
                    <tr>
                        <th>Nom
                        </th>
                        <th>Prenom
                        </th>
                        <th>Date début
                        </th>
                        <th>Titre
                        </th>
                        <th>Choix Manager
                        </th>
                    </tr>
                </tfoot>
            </table>
            <input type="submit" value="Valider" class="nav-link btn-primary">
        </div>
    </div>
    
    </form:form>
   <script src="js/jsImports.js"></script>
</body>
</html>