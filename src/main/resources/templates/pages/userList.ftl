<!DOCTYPE HTML>
<html lang="uk">

<head>
    <title>User List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body>
<button type="button" name="back" onclick="history.back()">назад</button>
<a href="/">На головну</a>

<h1>Список юзерів</h1>

<table>
    <thead>
        <tr>
            <th>Юзернейм</th>
            <th>Роль</th>
            <th></th>
        </tr>
    </thead>

    <tbody>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td>
                <#list user.roles as role>${role}<#sep>, </#list>
            </td>
            <td><a href="/users/${user.id}">редагувати</a></td>
        </tr>
    </#list>
    </tbody>
</table>

</body>

</html>