<#macro page head = "" footer = "">
    <!DOCTYPE HTML>
    ${head}
    <html lang="ru">
    <body>
    <div class="top">
        <span class="left"><a href="#"><strong onclick="history.back()">назад</strong></a></span>
        <span><a href="/"><strong>На главную</strong></a></span>
        <span><a href="/login"><strong>Вход</strong></a></span>

        <span><a href="/registration"><strong>Регистрация</strong></a></span>
        <span><a href="/user"><strong>Пользователи</strong></a></span>
        <span><a href="/users"><strong>Редактирование пользователей</strong></a></span>
        <span><a href="/recorder"><strong>Записаться</strong></a></span>
        <span><a href="/mastersRecordList"><strong>Для мастера</strong></a></span>
        <span><a href="/clientRecordList"><strong>Мои записи</strong></a></span>

        <form action="/logout" method="POST">
            <label><input type="hidden" name="_csrf" value="${_csrf.token}"/></label>
            <input type="submit" value="Вийти"/>
        </form>
        <div class="clr"></div>
    </div>
    <br/>
    <br/>
    <#nested>
    ${footer}
    </body>
    </html>
</#macro>