<!DOCTYPE HTML>
<html lang="uk">

<head>
    <title>User recorder</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="/static/style/css/hideTable.css"/>
</head>

<body>
<div class="top">
    <span class="left"><a href="#"><strong onclick="history.back()">назад</strong></a></span>
    <span class="right"><a href="/"><strong>На головну</strong></a></span>
    <div class="clr"></div>
</div>

<form action="/recorder" method="POST">
    <section class="masters">
        <label for="masterUsername">Майстер:</label>
        <select name="masterUsername" id="masterUsername">
            <option value="KarinaM">Каріна</option>
            <option value="LoraM">Лора</option>
            <option value="NastyaM">Настя</option>
        </select>
    </section>

    <label><input type="text" name="date" placeholder="Дата (2019-09-07)" required/></label>

    <section class="time">
        <label for="hour">На котру годину?</label>
        <select name="hour" id="hour">
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
        </select>

        <label for="minute">хвилин</label>
        <select name="minute" id="minute">
            <option value="0">00</option>
            <option value="30">30</option>
        </select>
    </section>

    <label><input type="hidden" name="_csrf" value="${_csrf.token}"/></label>
    <button type="submit">Записатись!</button>
</form>

<h1>Графік записів</h1>

<h2><#if message??>${message}</#if></h2>

<table>
    <thead>
    <tr>
        <th>День</th>
        <th>10:00<br/>10:30</th>
        <th>10:30<br/>11:00</th>
        <th>11:00<br/>11:30</th>
        <th>11:30<br/>12:00</th>
        <th>12:00<br/>12:30</th>
        <th>12:30<br/>13:00</th>
        <th>13:00<br/>13:30</th>
        <th>13:30<br/>14:00</th>
        <th>14:00<br/>14:30</th>
        <th>14:30<br/>15:00</th>
        <th>15:00<br/>15:30</th>
        <th>15:30<br/>16:00</th>
        <th>16:00<br/>16:30</th>
        <th>16:30<br/>17:00</th>
        <th>17:00<br/>17:30</th>
        <th>17:30<br/>18:00</th>
        <th>18:00<br/>18:30</th>
        <th>18:30<br/>19:00</th>
        <th>19:00<br/>19:30</th>
        <th>19:30<br/>20:00</th>
        <th>20:00<br/>20:30</th>
        <th>20:30<br/>21:00</th>
    </tr>
    </thead>

    <tbody>
    <#list days as day>
        <tr>
            <td>${day.dateString}</td>
            <#list day.occupation as oc>
                <td>
                    <#if oc??>
                        <#if oc == true>XXX</#if>
                    </#if>
                </td>
            </#list>
        </tr>
    </#list>
    </tbody>
</table>

</body>

</html>
