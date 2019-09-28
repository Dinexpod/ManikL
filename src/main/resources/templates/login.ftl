<!DOCTYPE HTML>
<html lang="uk">

<head>
    <meta charset="UTF-8">
    <title>Login page</title>
    <link rel="stylesheet" href="/static/style/css/style.css"/>
</head>

<body>
<div class="top">
    <span class="left"><a href="#"><strong  onclick="history.back()">назад</strong></a></span>
    <span class="right"><a href="/"><strong>На головну</strong></a></span>
    <div class="clr"></div>
</div>

<div id="login-form">
    <h1>АВТОРИЗАЦІЯ</h1>
    <fieldset>
        <form action="/login" method="POST">
            <label><input type="text" name="username" placeholder="Юзернейм" max="15" required/></label>
            <label><input type="password" name="password" placeholder="Пароль" required/></label>
            <label><input type="hidden" name="_csrf" value="${_csrf.token}"/></label>
            <input type="submit" value="Ввійти"/>
        </form>

        <a href="/registration"><input type="button" value="Не зареєстровані? Зареєструйтесь!"/></a>
    </fieldset>
</div>
</body>

</html>
