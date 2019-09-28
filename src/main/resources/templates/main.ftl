<!DOCTYPE HTML>
<html lang="uk">

<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="/static/style/css/style.css"/>
</head>

<body>
<div class="top">
    <span class="left"><a href="#"><strong onclick="history.back()">назад</strong></a></span>
    <span><a href="/"><strong>На головну</strong></a></span>
    <span><a href="/login"><strong>Вход</strong></a></span>

    <span><a href="/registration"><strong>регистрация</strong></a></span>
    <span><a href="/user"><strong>Пользователи</strong></a></span>
    <span><a href="/users"><strong>Редактирование пользователей</strong></a></span>
    <span><a href="/recorder"><strong>Записи для клиента</strong></a></span>
    <span><a href="/mastersRecordList"><strong>Записи мастера</strong></a></span>
    <span><a href="/clientRecordList"><strong>Мои записи</strong></a></span>

    <form action="/logout" method="POST">
        <label><input type="hidden" name="_csrf" value="${_csrf.token}"/></label>
        <input type="submit" value="Вийти"/>
    </form>
    <div class="clr"></div>
</div>
</body>

</html>
