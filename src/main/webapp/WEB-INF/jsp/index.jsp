
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% new SessionUtils().checkSession(request, response); %>
<html>
<head>
    <title>Serwis do prowadzenia budżetu domowego</title>
</head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
</style>
<body>
<div class="w3-top">

    <%@ include file="menu.jsp"%>
    <!-- MENU -->
</div>

    <c:if test="${registrationComplete eq true}">
        <p>Rejestracja zakończona powodzeniem. Zaloguj się do systemu.</p>
    </c:if>


 <!-- CONTENT -->V
<header class="w3-container w3-red w3-center" style="padding:128px 16px">
<c:if test="${registrationComplete eq true}">
        <p>Rejestracja zakończona powodzeniem. Zaloguj się do systemu.</p>
    </c:if>
  <h1 class="w3-margin w3-jumbo">BUDŻET DOMOWY(v1.0)</h1>
  <p class="w3-xlarge">Zarządzaj w prosty sposób swoimi finansami</p>
</header>

<footer class="w3-container w3-hover-white w3-center w3-opacity">

 <p>Projekt końcowy kursu Java od podstaw realizowany przez Filip Doliński / Rafał Pietrzyk</p>
</footer>

</body>
</html>
