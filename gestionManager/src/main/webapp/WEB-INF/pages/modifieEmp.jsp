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
<div class="head">
	<nav class="navbar navbar-expand-sm bg-light navbar-dark">
    
        <div class="navbar-brand" >
            <a href="#"> <img src="img/manager.png" alt="saj logo" class="logo align-self-center" height=105
                    width=110> </a>
        </div>
        
        <div>
        <ul class="navbar-nav nav">
        <form:form class="form" action="accueilConnecte" method="get">
            <li class="nav-item item">
                <a><button class="nav-link btn"><spring:message code="nav.accueil"></spring:message></button></a>
            </li>
            </form:form>
            <form:form class="form" action="manager" method="get">
            <li class="nav-item item">
            <a><button class="nav-link btn">Managers</button></a>
            </li>
              </form:form>
           
            <li class="nav-item dropdown " >
              <a class="nav-link dropdown down" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="nav.employes"></spring:message> </a>
             
              <div class="dropdown-menu " id="deroulant" aria-labelledby="navbarDropdownMenuLink">
               <form:form class="form" action="employe" method="post">
               <a><button class="nav-link btn"><spring:message code="nav.listemp"></spring:message></button></a>
               </form:form>
                <form:form class="form" action="ajoutEmploye" method="get">
                 <a><button class="nav-link btn"><spring:message code="nav.addemp"></spring:message></button></a>
                </form:form>  
              </div>
          </li>
          <form:form class="form" action="parametres" method="get">
            <li class="nav-item item">
             <a><button class="nav-link btn"><spring:message code="nav.param"></spring:message></button></a>
              
            </li>
            </form:form>
            <form:form class="form" action="contact" method="get">
            <li class="nav-item item">
               <a><button class="nav-link btn">Contact</button></a>
            </li>
            </form:form>
             <form:form class="form" action="qsm" method="get">
            <li class="nav-item item">
                <a><button class="nav-link btn"><spring:message code="login.QSM"></spring:message></button></a>
            </li>
            </form:form>
             <form:form class="form" action = "logout" method="get">
            <li class="nav-item item" id="deco">
            <a><button onclick="return onButtonDeco();" class="nav-link btn"><spring:message code="nav.deco"></spring:message></button></a>
      
            </li>
            </form:form>
            
        </ul>
        </div>
        
        
        
        
    </nav>
	
	<div class="langues">
        
        <a href="${pageContext.request.contextPath}/update?lang=en"><img src="img/angleterre.png" alt="English" height=30 width=30 /></a>
	   <a href="${pageContext.request.contextPath}/update?lang=fr"><img src="img/france.png" alt="Français" height=30 width=30 /></a>
    </div>
    
    </div>




	<div class="tit">
		<spring:message code="modifEmp.title"></spring:message>
	</div>
	<div class="gen2">
		<form:form action="update" method="post" modelAttribute="employee">
			<form:hidden path="empId"/>	
			<form:hidden path="startDate"/>
			<div class="row mb-4 inpu">

				<div class="col">
					<div class="form-outline">
						<spring:message code="emp.placeholderName" var="placeholderName" />
						<form:input type="text" id="form6Example2" path="firstName"
							class="form-control" placeholder='${placeholderName}' />
						<label class="info" class="form-label" for="form6Example2"><spring:message code="emp.nom" /></label>
					</div>
				</div>
			</div>

			<div class="form-outline mb-4">
				<spring:message code="emp.placeholderPrenom" var="placeholderPrenom" />
				<form:input type="text" id="form6Example5" path="lastName"
					class="form-control" placeholder='${placeholderPrenom }' />
				<label class="info" class="form-label" for="form6Example5"><spring:message
						code="emp.prenom" /></label>
			</div>

			<%-- <div class="form-outline mb-4">
				<spring:message code="emp.placeholderDate" var="placeholderDate" />
				<input type="text" name="startDate" id="form6Example5" value = "${employee.startDate}" class="form-control" />
				<label class="info" class="form-label" for="form6Example5"><spring:message
						code="emp.date" /></label>
			</div>
 --%>
			<div class="form-outline mb-4">
				<spring:message code="emp.placeholderTitle" var="placeholderTitle" />
				<form:input type="text" id="tit" path="title" class="form-control"
					placeholder='${placeholderTitle }' />
				<label class="info" class="form-label" for="tit"><spring:message
						code="emp.titre" /></label>
			</div>
			<c:choose>
				<c:when test="${employee.manager==null}">
				<form:select path="manager.empId" class="form-select" aria-label="Default select example">
						<form:option value=""><spring:message code="addEmp.chooseManag"></spring:message></form:option>
						<c:forEach items="${managers}" var="manager">
							<form:option value="${manager.empId}" var="id" required="true">${manager.firstName} ${manager.lastName} </form:option>
						</c:forEach>

					</form:select>
				</c:when>
				<c:otherwise>
					<form:select path="manager.empId" class="form-select" aria-label="Default select example">
					
						<form:option value="${employee.manager.empId}">${employee.manager.firstName} ${employee.manager.lastName}</form:option>
						<c:forEach items="${managers}" var="manager" >
						<c:if test="${manager.empId ne employee.manager.empId && manager.empId ne employee.empId}">
							<form:option value="${manager.empId}" var="id" required="true">${manager.firstName} ${manager.lastName} </form:option>
						</c:if>
						</c:forEach>

					</form:select>
				</c:otherwise>
			</c:choose>
			<br>
			<br>
			<c:choose>
				<c:when test="${employee.department.deptId==null}">
					<form:select class="form-select" path="department.deptId" name="dept"
						id="dept-select">
						<form:option value="">
							<spring:message code="addEmp.chooseDept"></spring:message>
						</form:option>
						<form:option value="1">1</form:option>
						<form:option value="2">2</form:option>
						<form:option value="3">3</form:option>
						<form:option value="4">4</form:option>
					</form:select>
				</c:when>
				<c:when test="${employee.department.deptId=='1'}">
					<form:select class="form-select" path="department.deptId" name="dept"
						id="dept-select">
						<form:option value="${employee.department.deptId}"></form:option>
						<form:option value="2">2</form:option>
						<form:option value="3">3</form:option>
						<form:option value="4">4</form:option>
					</form:select>
				</c:when>
				<c:when test="${employee.department.deptId=='2'}">
					<form:select class="form-select" path="department.deptId" name="dept"
						id="dept-select">
						<form:option value="${employee.department.deptId}"></form:option>
						<form:option value="1">1</form:option>
						<form:option value="3">3</form:option>
						<form:option value="4">4</form:option>
					</form:select>
				</c:when>
				<c:when test="${employee.department.deptId=='3'}">
					<form:select class="form-select" path="department.deptId" name="dept"
						id="dept-select">
						<form:option value="${employee.department.deptId}"></form:option>
						<form:option value="2">1</form:option>
						<form:option value="3">2</form:option>
						<form:option value="4">4</form:option>
					</form:select>
				</c:when>
				<c:when test="${employee.department.deptId=='4'}">
					<form:select class="form-select" path="department.deptId" name="dept"
						id="dept-select">
						<form:option value="${employee.department.deptId}"></form:option>
						<form:option value="1">1</form:option>
						<form:option value="2">2</form:option>
						<form:option value="3">3</form:option>
					</form:select>
				</c:when>
			</c:choose>
			<!-- Submit button -->

			<div class="btns">
				<button type="submit" onclick="return onButtonUpdate();"
					class="btn btn-light">
					<spring:message code="addEmp.save"></spring:message>
				</button>
				<form:form action="cancel" method="get">
				<button type="submit" onclick="return onButtonCancel();"
					class="btn btn-light">
					<spring:message code="addEmp.cancel"></spring:message>
				</button>
				</form:form>
			</div>
		

		</form:form>
	</div>
	<script src="js/jsImports.js"></script>
<%@ include file="/WEB-INF/resources/Include/footer.jsp"%>
</body>
</html>