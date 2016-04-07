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
<h1><fmt:message key="register.heading"/></h1>
<form:form method="post" commandName="registerForm">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">User ID:</td>
        <td width="20%">
          <form:input path="name"/>
        </td>
       <td align="right" width="20%">Password:</td>
        <td width="20%">
          <form:input path="password"/>
        </td>
      <td align="right" width="20%">Email:</td>
        <td width="20%">
          <form:input path="email"/>
        </td>      
      <td align="right" width="20%">Date of Birth:</td>
        <td width="20%">
          <form:input path="dob"/>
        </td> 
       <td align="right" width="20%">Street:</td>
        <td width="20%">
          <form:input path="street"/>
        </td> 
      <td align="right" width="20%">Zip Code:</td>
        <td width="20%">
          <form:input path="zipcode"/>
        </td>         
      <td align="right" width="20%">City:</td>
        <td width="20%">
          <form:input path="city"/>
        </td>       
        <td align="right" width="20%">Country:</td>
        <td width="20%">
          <form:select path="country" items="${countryList}"/>
        </td>   
        <td width="60%">
          <form:errors path="name" cssClass="error"/>
        </td>
    </tr>
  </table>
  <br>
  <input type="submit" align="center" value="Register">
</form:form>
</body>
</html>