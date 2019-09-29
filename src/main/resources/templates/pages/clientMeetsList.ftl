<#import "../parts/common.ftl" as c>

<#assign head>
    <head>
        <title>Записи для клиента</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="/static/style/css/table.css"/>
        <link rel="stylesheet" href="/static/style/css/style.css"/>
    </head>
</#assign>

<@c.page head=head>
    <table>
        <thead>
        <tr>
            <th>дата</th>
            <th>день</th>
            <th>начало</th>
            <th>конец</th>
            <th>логин</th>
            <th>телефон</th>
            <th>услуга</th>
        </tr>
        </thead>

        <tbody>
        <#list meets as meet>
            <tr>
                <td style="width:65px;">${meet.day.dateString}</td>
                <td>${meet.day.dayOfWeekRu}</td>
                <td>${meet.startMeet}</td>
                <td>${meet.endMeet}</td>
                <td>${meet.client.username}</td>
                <td><#if meet.client.phoneNumber??>${meet.client.phoneNumber}</#if></td>
                <td><#if meet.servicesList??>${meet.servicesList}</#if></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>
