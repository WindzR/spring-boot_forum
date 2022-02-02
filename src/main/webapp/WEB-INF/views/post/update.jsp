<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="ru">
<head>
    <!-- Required meta tags -->
    <%--    <meta charset="utf-8">--%>
    <%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
    <!--Import Google Icon Font-->
    <%--    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">--%>
    <!--Import materialize.css-->
    <%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">--%>
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
    <title>create Post</title>
</head>

<body>
<h3 class="col s12 center-align">Создание новой темы</h3>
<br>
<h5 class="col s12 center-align">Пожалуйста, введите заголовок и описание темы.</h5>
<br>

<form  action="<c:url value='/save?id=${post.id}'/>" method='POST'>
    <table>
        <tr>
            <td>Тема:</td>
            <td><input type='text' name='name' value="<c:out value="${post.name}"/>"></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><input type='text' name='description' value="<c:out value="${post.description}"/>"></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Обновить" /></td>
        </tr>
    </table>
</form>
</body>
</html>