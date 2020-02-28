<#import "parts/common.ftl" as c>

<#assign head>
    <head>
        <meta charset="UTF-8">
        <title>Вход</title>
        <link rel="stylesheet" href="/static/style/css/style.css"/>
    </head>
</#assign>

<@c.page head=head>
    <div id="login-form">
        <h1>АВТОРИЗАЦІЯ</h1>
        <fieldset>
            <form action="/login" method="POST">
                <label><input type="text" name="username" placeholder="Юзернейм" max="15" required/></label>
                <label><input type="password" name="password" placeholder="Пароль" required/></label>
                <label><input type="hidden" name="_csrf" value="${_csrf.token}"/></label>
                <input type="submit" value="Ввійти"/>
            </form>

            <a href="/registration"><input type="button" value="Не зарегистрированы? Зарегистрируйтесь!"/></a>
        </fieldset>
    </div>
</@c.page>
