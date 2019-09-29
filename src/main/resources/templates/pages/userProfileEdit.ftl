<#import "../parts/common.ftl" as c>

<#assign head>
    <head>
        <title>Мой профиль</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="/static/style/css/table.css"/>
        <link rel="stylesheet" href="/static/style/css/style.css"/>
    </head>
</#assign>

<@c.page head=head>
    <form action="/userProfileEdit" method="POST">
        <label>
            <span>Имя</span>
            <input type="text" name="firstName" value="<#if user.firstName??>${user.firstName}<#else>-</#if>"/>
        </label>
        <br/>
        <label>
            <span>Фамилия</span>
            <input type="text" name="lastName" value="<#if user.lastName??>${user.lastName}<#else>-</#if>"/>
        </label>
        <br/>
        <label>
            <span>Отчество</span>
            <input type="text" name="middleName" value="<#if user.middleName??>${user.middleName}<#else>-</#if>"/>
        </label>
        <br/>
        <label>
            <span>Возраст</span>
            <input type="text" name="age" value="<#if user.age??>${user.age}<#else>-</#if>"/>
        </label>
        <br/>
        <label>
            <span>Телефон</span>
            <input type="text" name="phoneNumber" value="<#if user.phoneNumber??>${user.phoneNumber}<#else>-</#if>"/>
        </label>
        <br/>
        <label>
            <span>Еmail</span>
            <input type="text" name="email" value="<#if user.email??>${user.email}<#else>-</#if>"/>
        </label>
        <br/>
        <label><input type="hidden" name="userId" value="${user.id}"/></label>
        <label><input type="hidden" name="_csrf" value="${_csrf.token}"/></label>
        <br/>
        <button type="submit">Изменить</button>
    </form>
</@c.page>