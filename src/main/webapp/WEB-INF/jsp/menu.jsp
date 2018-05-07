<%@ page import="com.sda.budzet.utils.SessionUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% new SessionUtils().checkSession(request, response); %>

<c:choose>
    <c:when test="${sessionScope.get('user') eq null}">
        <div class="w3-top">
          <div class="w3-bar w3-red w3-card w3-left-align w3-large">
            <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
            <a href="./" class="w3-bar-item w3-button w3-padding-large w3-white">Strona główna</a>
            <a href="./register" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Rejestracja</a>
            <a href="./login" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Logowanie</a>
        </div>
        <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
            <a href="./" class="w3-bar-item w3-button w3-padding-large">Strona główna</a>
            <a href="./register" class="w3-bar-item w3-button w3-padding-large">Rejestracja</a>
            <a href="./login" class="w3-bar-item w3-button w3-padding-large">Logowanie</a>
          </div>
 </div>
    </c:when>
    <c:otherwise>

       <div class="w3-top">
                <div class="w3-bar w3-red w3-card w3-left-align w3-large">
            <a href="./" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Strona główna</a>
          <a href="./income" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Dodaj przychód</a>
            <a href="./outgoings" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Dodaj wydatek</a>
            <a href="./summary" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Bilans</a>
        <form action="./logout"  method="post">
            <input type="submit" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" value="Wyloguj">
        </form>

        </div>
        <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
                    <a href="./" class="w3-bar-item w3-button w3-padding-large">Strona główna</a>
                              <a href="./income" class="w3-bar-item w3-button w3-padding-large">Dodaj przychód</a>
                                <a href="./outgoings" class="w3-bar-item w3-button w3-padding-large">Dodaj wydatek</a>
                                <a href="./summary" class="w3-bar-item w3-button w3-padding-large">Bilans</a>
                            <form action="./logout"  method="post">
                                <input type="submit" class="w3-bar-item w3-button w3-padding-large" value="Wyloguj">
                            </form>
 </div>

<h1 class="w3-margin w3-xlarge">Witaj, ${sessionScope.get('user')}</h1>

 </div>


    </c:otherwise>

</c:choose>


