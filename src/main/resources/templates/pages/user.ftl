<!DOCTYPE HTML>
<html lang="uk">

<head>
    <title>About user</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="/static/style/css/table.css"/>
    <link rel="stylesheet" href="/static/style/css/style.css"/>
</head>

<body>
<div class="top">
    <span class="left"><a href="#"><strong onclick="history.back()">назад</strong></a></span>
    <span class="right"><a href="/"><strong>На головну</strong></a></span>
    <div class="clr"></div>
</div>

<form method="POST">
    <label><input type="text" name="username" placeholder="Введіть логін юзера:" required/></label>
    <label><input type="text" name="sex" placeholder="Введіть стать юзера:" required/></label>
    <label><input type="text" name="age" placeholder="Введіть вік юзера:" required/></label>
    <label><input type="hidden" name="_csrf" value="${_csrf.token}"/></label>
    <button type="submit">Додати</button>
</form>

<h1>Список юзерів</h1>

<table>
    <thead>
    <tr>
        <th>id</th>
        <th>юзернейм</th>
        <th>стать</th>
        <th>вік</th>
    </tr>
    </thead>

    <tbody>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.sex}</td>
            <td>${user.age}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>

</html>
