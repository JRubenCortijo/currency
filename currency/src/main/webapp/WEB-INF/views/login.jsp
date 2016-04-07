<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="login.heading"/></h1>
<form:form method="post" commandName="checkLogin">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">User:</td>
        <td width="20%">
          <form:input path="name"/>
        </td>
        <td align="right" width="20%">Password:</td>
        <td width="20%">
          <form:password path="password"/>
        </td>
        <td width="60%">
          <form:errors path="password" cssClass="error"/>
        </td>
    </tr>
  </table>
  <br>
  <input type="submit" align="center" value="Log In">
</form:form>
<a href="<c:url value="register.htm"/>">Register</a>
</body>
</html>