<!DOCTYPE HTML>
<html lang="uk">

<head>
    <title>User editor</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body>
<button type="button" name="back" onclick="history.back()">назад</button>
<a href="/">На головну</a>

<h1>Редагування юзера</h1>

<form action="/users" method="POST">
    <label><input type="text" name="username" value="${user.username}"/></label>
    <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}/>${role}
            </label>
        </div>
    </#list>
    <label><input type="hidden" name="userId" value="${user.id}"/></label>
    <label><input type="hidden" name="_csrf" value="${_csrf.token}"/></label>
    <button type="submit">Зберегти</button>
</form>
</body>

</html>
