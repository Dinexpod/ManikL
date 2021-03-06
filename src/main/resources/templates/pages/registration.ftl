<#import "../parts/common.ftl" as c>

<#assign head>
    <head>
        <title>Registration page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="/static/style/css/style.css"/>
    </head>
</#assign>

<@c.page head=head>
    <div id="login-form">
        <h1>Реєстрація</h1>

        <#if message??>${message}</#if>

        <fieldset>
            <form action="/registration" method="POST">
                <label><input type="text" name="username" placeholder="Юзернейм" max="15" required/> </label>
                <label><input type="password" name="password" placeholder="Пароль" min="10" required/> </label>
                <label><input type="text" name="sex" placeholder="Пол" required/></label>
                <label><input type="text" name="age" placeholder="Возрост (лет)" required/></label>
                <label><input type="hidden" name="_csrf" value="${_csrf.token}"/></label>
                <input type="submit" value="Зарегистрироваться"/>
            </form>
        </fieldset>
    </div>
</@c.page>
