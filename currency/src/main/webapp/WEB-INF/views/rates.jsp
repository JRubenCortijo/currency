<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head><title></title></head>
  <body>
    <h1><fmt:message key="rates.heading"/></h1>
	
	
	<form:form method="post" commandName="currencyForm">	
		<table>
			<tr>
				<td>Currency :</td>
				<td>
					<form:select path="currency" items="${currencyList}"/>
                 </td>
				<td><form:errors path="currency" cssClass="error" /></td>
				<td>Date :</td>
				<td>
					<form:input path="date" value="${date}"/> (format:dd/MM/yyyy)
                 </td>
				<td><form:errors path="date" cssClass="error" /></td>
			</tr>
		</table>
	  <br>
	  <input type="submit" align="center" value="Get Currency">
	  <input type="hidden" value="${name}" name="name" />
	</form:form>
	
	<table>
		<tr>
			<td>
			<c:if test="${change != null}">
			The rate for USD/<c:out value="${currency}"/> the day <c:out value="${dateCurrency}"/> was: <c:out value="${change}"/>
			</c:if>
			</td>
		</tr>
	</table>
 	<br>
    <h3>Historical</h3>
    <c:forEach items="${historicals}" var="hist">
      <c:out value="${hist}"/><br><br>
    </c:forEach>
	
	 <br>
    	<a href="<c:url value="login.htm"/>">Logout</a>
    <br>
  </body>
</html>