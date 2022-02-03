<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<%--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    <title>create Post</title>
</head>

<body class="container grey lighten-3">

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

<br>
<h5 class="col s12 center-align">Тема обсуждения</h5>
<br>

<div class="container row">
    <div class="col s10 offset-s1">
        <div class="card horizontal blue lighten-3">
            <div class="card-stacked row" style="margin-bottom: 0;">
                <div class="card-content" style="padding-bottom: 10px; padding-top: 10px">
                    <div class="row" style="margin-bottom: 0;">
                        <p class="input-field col s12" style="margin-bottom: 8px">
                            <i class="material-icons">assignment_ind</i>
                            <strong>${user.username}</strong>,
                            <calendar:formatDate value="${post.created}"
                            pattern="dd-MM-yyyy HH:mm"/>
                        </p>
                        <p class="input-field col s12">
                            <strong>${post.name}</strong>
                        </p>
                    </div>
                    <br>
                    <div>
                        <i class="material-icons">announcement</i>
                        ${post.description}
                    </div>
                    <br>
                    <div>
                        <a href="#">
                            <i class="material-icons">chat_bubble_outline</i>
                            Ответить
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>