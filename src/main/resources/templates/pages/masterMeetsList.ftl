<#import "../parts/common.ftl" as c>

<#assign head>
    <head>
        <title>Записи для мастера</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="/static/style/css/style.css"/>
        <link rel="stylesheet" href="/static/style/css/table.css"/>
    </head>
</#assign>

<@c.page head=head>
    <form action="/masterMeetsList" method="POST">
        <label><input type="text" name="date" placeholder="Дата (2019-09-07)"/></label>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Показать!</button>
    </form>

    <h1>Запись на <#if day.dateString??>${day.dateString}</#if> (<#if day.dayOfWeekRu??>${day.dayOfWeekRu}</#if>)</h1>
    <br/>
    <table>
        <thead>
        <tr>
            <th>Начало</th>
            <th>Конец</th>
            <th>логин</th>
            <th>номер телефона</th>
            <th>услуга</th>
        </tr>
        </thead>

        <tbody>
        <#list meets as meet>
            <tr>
                <td><#if meet.startMeet??>${meet.startMeet}</#if></td>
                <td><#if meet.endMeet??>${meet.endMeet}</#if></td>
                <td><#if meet.client.username??>${meet.client.username}</#if></td>
                <td><#if meet.client.phoneNumber??>${meet.client.phoneNumber}</#if></td>
                <td><#if meet.servicesList??>${meet.servicesList}</#if></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>
