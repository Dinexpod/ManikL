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
    <h1>Мой профиль</h1>
    <a href="/userProfileEdit/${user.id}"> (редактировать) </a>
    <br/>
    <table>
        <tbody>
        <tr>
            <td style="width: 100px;">Логин:</td>
            <td><#if user.username??>${user.username}</#if></td>
        </tr>
        <tr>
            <td>Имя:</td>
            <td><#if user.firstName??>${user.firstName}</#if></td>
        </tr>
        <tr>
            <td>Отчество:</td>
            <td><#if user.lastName??>${user.lastName}</#if></td>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td><#if user.middleName??>${user.middleName}</#if></td>
        </tr>
        <tr>
            <td>Возрост:</td>
            <td><#if user.age??>${user.age}</#if></td>
        </tr>
        <tr>
            <td>Пол:</td>
            <td><#if user.sex??>${user.sex}</#if></td>
        </tr>
        <tr>
            <td>Телефон:</td>
            <td><#if user.phoneNumber??>${user.phoneNumber}</#if></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><#if user.email??>${user.email}</#if></td>
        </tr>
        <tr>
            <td>День рождения:</td>
            <td><#if user.birthday??>${user.birthday}</#if></td>
        </tr>
        </tbody>
    </table>
</@c.page>
