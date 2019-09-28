<#import "../parts/common.ftl" as c>

<#assign head>
    <head>
        <title>User List</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="/static/style/css/table.css"/>
        <link rel="stylesheet" href="/static/style/css/style.css"/>
    </head>
</#assign>

<@c.page head=head>
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
</@c.page>
