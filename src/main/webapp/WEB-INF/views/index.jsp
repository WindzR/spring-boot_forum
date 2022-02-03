<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Форум job4j</title>
</head>
<body class="container grey lighten-3">
<div class="container mt-3">
    <nav>
        <div class="nav-wrapper container light-blue darken-4">
            <a class="brand-logo center-align">ФОРУМ IT СПЕЦИАЛИСТОВ</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li>
                    Пользователь: <c:out value="${user.username}"/>
                </li>
            </ul>
        </div>
    </nav>
    <br><br>
    <div class="row">
        <div>
            <a href='<c:url value='/create'/>'>
                <i class="material-icons">edit</i>
                Создать новую тему
            </a>
        </div>
        <table class="table">
            <thead class="tableHeader blue darken-4" style="color: whitesmoke">
            <tr>
                <th scope="col">№</th>
                <th scope="col">Тема</th>
                <th scope="col">Описание</th>
                <th scope="col">Дата создания</th>
                <th scope="col">Обновить</th>
            </tr>
            </thead>
            <tbody class="tableBody blue lighten-3">
            <c:forEach items="${posts}" var="post" varStatus="count">
                <tr>
                    <td><c:out value="${count.count}"/></td>
                    <td>
                        <a href='<c:url value="/view?id=${post.id}"/>'>
                            <i class="material-icons">chat_bubble_outline</i>
                            <c:out value="${post.name}"/>
                        </a>
                    </td>
                    <td><c:out value="${post.description}"/></td>
                    <td>
                        <calendar:formatDate value="${post.created}"
                        pattern="dd-MM-yyyy HH:mm"/>
                    </td>
                    <td>
                        <a href='<c:url value="/update?id=${post.id}"/>'>
                            <i class="material-icons">edit</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>