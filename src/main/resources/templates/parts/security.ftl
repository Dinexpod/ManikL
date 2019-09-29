<#if Session.SPRING_SECURITY_CONTEXT??>
    <#assign name = Session.SPRING_SECURITY_CONTEXT.authentication.principal.getUsername()>
<#else>
    <#assign name = "Гость">
</#if>
