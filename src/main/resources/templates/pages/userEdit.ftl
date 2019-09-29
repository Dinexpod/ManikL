<#import "../parts/common.ftl" as c>

<#assign head>
    <head>
        <title>Редактор пользователей</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="/static/style/css/table.css"/>
        <link rel="stylesheet" href="/static/style/css/style.css"/>
    </head>
</#assign>

<@c.page head=head>
    <h1>Редактирование пользователей</h1>

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
        <button type="submit">Сохранить</button>
    </form>
</@c.page>
