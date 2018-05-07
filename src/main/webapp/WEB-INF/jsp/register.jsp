
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
  <div class="w3-bar w3-red w3-card w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <%@ include file="menu.jsp"%>
    <!-- MENU -->
</div>
<header class="w3-container w3-red w3-center" style="padding:128px 16px">

    <!-- CONTENT -->
    <h2>Formularz rejestracyjny</h2>
    <form name="regForm" action="./register" method="post">
        <p><label>Nazwa użytkownika</label>
        <input type="text" name="login">
        </p>

        <p><label>Hasło</label>
            <input type="password" name="password">
        </p>

        <p><label>Powtórz hasło</label>
            <input type="password" name="repeatPassword">
        </p>

        <p><label>Adres email</label>
            <input type="email" name="email">
        </p>

        <c:if test="${errorMsg eq true}">
            <span>Formularz zawiera błędy!!!</span>
        </c:if>

        <p><input type="submit" value="Zarejestruj">
        </p>

    </form>

</header>
</div>
</body>
<footer class="w3-container w3-padding-64 w3-center w3-opacity">
 <p>Projekt końcowy kursu Java od podstaw realizowany przez Filip Doliński / Rafał Pietrzyk</p>
</footer>
</html>
