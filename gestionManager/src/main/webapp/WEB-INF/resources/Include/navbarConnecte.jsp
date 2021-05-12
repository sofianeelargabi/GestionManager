<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link href="css/navbarConnecte.css" rel="stylesheet" />
<!-- Bootstrap CSS  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light navbar-dark">


        
        <div class="navbar-brand" >
            <a href="#"> <img src="img/manager.png" alt="saj logo" class="logo align-self-center" height=105
                    width=110> </a>
        </div>
        <ul class="navbar-nav nav">
        <form:form class="form" action="accueilConnecte" method="get">
            <li class="nav-item item">
                <a><button class="nav-link btn">Accueil</button></a>
            </li>
            </form:form>
            <form:form class="form" action="manager" method="get">
            <li class="nav-item item">
            <a><button class="nav-link btn">Managers</button></a>
            </li>
              </form:form>
           
            <li class="nav-item dropdown " >
              <a class="nav-link dropdown down" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Employés </a>
             
              <div class="dropdown-menu " id="deroulant" aria-labelledby="navbarDropdownMenuLink">
               <form:form class="form" action="employe" method="post">
               <a><button class="nav-link btn">Liste Employés</button></a>
               </form:form>
                <form:form class="form" action="ajoutEmploye" method="get">
                 <a><button class="nav-link btn">Ajout Employé</button></a>
                </form:form>  
              </div>
          </li>
          <form:form class="form" action="parametres" method="get">
            <li class="nav-item item">
             <a><button class="nav-link btn">Paramètres</button></a>
              
            </li>
            </form:form>
            <form:form class="form">
            <li class="nav-item item">
                <a class="nav-link btn" href="#">Contact</a>
            </li>
            </form:form>
             <form:form class="form">
            <li class="nav-item item">
                <a class="nav-link btn" href="#">Qui sommes-nous ?</a>
            </li>
            </form:form>
             <form:form class="form" action = "logout" method="get">
            <li class="nav-item item">
            <a><button onclick="return onButtonDeco();" class="nav-link btn">Déconnexion</button></a>
                
            </li>
            </form:form>
        </ul>
    </nav>
    <script src="js/jsImports.js"></script>
</body>
</html>