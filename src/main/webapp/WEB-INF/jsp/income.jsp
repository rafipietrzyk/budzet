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
<header class="w3-container w3-red w3-center" style="padding:128px 16px">
    <!-- CONTENT -->
    <h2>Dodawanie budżetu</h2>
    <form name="regForm" action="./income" method="post">
<label>Wybierz kategorię:</label>
                <select name="categoryID">
                    <option value="-1">--Wybierz</option>
                    <%-- model z bazy danych--%>
                    <c:forEach items="${category}" var="category">
                        <option value="${category.categoryID}">${category.categoryName} - ${category.categoryType}</option>
                    </c:forEach>
                </select>
        <p><label>Nazwa Wpłaty</label>
            <input type="text" name="incomeName">
        </p>

        <p><label>Kwota Wpłaty</label>
            <input type="number" name="incomeAmount">
        </p>
        <p><label>Data Wpłaty</label>
                        <input type="date" name="addDate">
                        </p>
        <p><input type="submit" value="Dodaj">
        </p>
    </form>
</header>
<footer class="w3-container w3-padding-64 w3-center w3-opacity">
 <p>Projekt końcowy kursu Java od podstaw realizowany przez Filip Doliński / Rafał Pietrzyk</p>
</footer>
</body>
</html>
