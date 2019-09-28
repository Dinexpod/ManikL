<#import "../parts/common.ftl" as c>

<#assign head>
    <head>
        <title>User recorder</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="/static/style/css/hideTable.css"/>
        <link rel="stylesheet" href="/static/style/css/style.css"/>
    </head>
</#assign>

<@c.page head=head>
    <form action="/recorder" method="POST">
        <section class="masters">
            <label for="masterUsername">Мастер:</label>
            <select name="masterUsername" id="masterUsername">
                <option value="KarinaM">Карина</option>
                <option value="LoraM">Лора</option>
                <option value="NastyaM">Настя</option>
            </select>
        </section>

        <label><input type="text" name="date" placeholder="Дата (2019-09-07)" required/></label>

        <section class="time">
            <label for="hour">На какое время?: часов</label>
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

            <label for="minute">минут</label>
            <select name="minute" id="minute">
                <option value="0">00</option>
                <option value="30">30</option>
            </select>
        </section>

        <hr/>

        <section class="mainService">
            <span>Выберите основную услугу:</span>
            <ol>
                <li>
                    <input type="radio" name="mainService" id="no" value="no" required/>
                    <label for="no">нет</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="snyatie" value="snyatie" required/>
                    <label for="snyatie">снятие</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="snyatie_gelya" value="snyatie_gelya" required/>
                    <label for="snyatie_gelya">снятие геля</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="classMan" value="classMan" required/>
                    <label for="classMan">классический маникюр</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="combMan" value="combMan" required/>
                    <label for="combMan">комбинированный маникюр</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="aparMan" value="aparMan" required/>
                    <label for="aparMan">аппаратный маникюр</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="manMan" value="manMan" required/>
                    <label for="manMan">мужской маникюр</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="classMan_pokr" value="classMan_pokr" required/>
                    <label for="classMan_pokr">классический маникюр + покрытие</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="combMan_pokr" value="combMan_pokr" required/>
                    <label for="combMan_pokr">комбинированный маникюр + покрытие</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="aparMan_pokr" value="aparMan_pokr" required/>
                    <label for="aparMan_pokr">аппаратный маникюр + покрытие</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="snyatie_classMan" value="snyatie_classMan" required/>
                    <label for="snyatie_classMan">снятие + классический маникюр</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="snyatie_combMan" value="snyatie_combMan" required/>
                    <label for="snyatie_combMan">снятие + комбинированный маникюр</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="snyatie_aparMan" value="snyatie_aparMan" required/>
                    <label for="snyatie_aparMan">снятие + аппаратный маникюр</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="snyatie_classMan_pokr" value="snyatie_classMan_pokr"
                           required/>
                    <label for="snyatie_classMan_pokr">снятие + классический маникюр + покрытие</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="snyatie_combMan_pokr" value="snyatie_combMan_pokr" required/>
                    <label for="snyatie_combMan_pokr">снятие + комбинированный маникюр + покрытие</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="snyatie_aparMan_pokr" value="snyatie_aparMan_pokr" required/>
                    <label for="snyatie_aparMan_pokr">снятие + аппаратный маникюр + покрытие</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="pokr_gelLak" value="pokr_gelLak" required/>
                    <label for="pokr_gelLak">покрытие гель-лаком</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="narashch" value="narashch" required/>
                    <label for="narashch">наращивание ногтей</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="korrekts_gel" value="korrekts_gel" required/>
                    <label for="korrekts_gel">коррекция геля</label>
                </li>
                <li>
                    <input type="radio" name="mainService" id="manPed" value="manPed" required/>
                    <label for="manPed">мужской педикюр</label>
                </li>
            </ol>
        </section>

        <section class="dopService">
            <span>Выберите дополнительные услуги:</span>

            <input type="hidden" name="dopService" value=""/>
            <ol>
                <li>
                    <input type="checkbox" name="dopService" id="pokr_usualLak" value="pokr_usualLak"/>
                    <label for="pokr_usualLak">покрытие обычны/лечебным лаком</label>
                </li>
                <li>
                    <input type="checkbox" name="dopService" id="dezVsehNogt" value="dezVsehNogt"/>
                    <label for="dezVsehNogt">дизайн всех ногтей</label>
                </li>
                <li>
                    <input type="checkbox" name="dopService" id="grad" value="grad"/>
                    <label for="grad">градиент</label>
                </li>
                <li>
                    <input type="checkbox" name="dopService" id="ukrepNogtey" value="ukrepNogtey"/>
                    <label for="ukrepNogtey">укрепление ногтей</label>
                </li>
                <li>
                    <input type="checkbox" name="dopService" id="remOneNail" value="remOneNail"/>
                    <label for="remOneNail">ремонт 1 ногтя</label>
                </li>
                <li>
                    <input type="checkbox" name="dopService" id="remTwoNails" value="remTwoNails"/>
                    <label for="remTwoNails">ремонт 2 ногтей</label>
                </li>
                <li>
                    <input type="checkbox" name="dopService" id="remThreeNails" value="remThreeNails"/>
                    <label for="remThreeNails">ремонт 3 ногтей</label>
                </li>
            </ol>
        </section>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Записаться!</button>
    </form>

    <h1>График записей</h1>

    <h2><#if message??>${message}</#if></h2>
    <h2><#if recordStatus??>${recordStatus}</#if></h2>

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
                <td>${day.dateString} (<#if day.dayOfWeekRu??>${day.dayOfWeekRu}</#if>)</td>
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
</@c.page>
