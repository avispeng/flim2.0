<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<!-- display errors if there are any -->
<c:if test="${allErrors != null}">
	<c:forEach items = "${allErrors }" var="error">
	${error.defaultMessage }<br/>
	</c:forEach>
</c:if>
<form id="registerForm" action="${pageContext.request.contextPath }/users/registerSubmit.action"
method="post" >
Register
<table width="100%" border=1>
<tr>
<td>username: </td>
<td><input type="text" name="username" value="${usersCustom.username }"/></td>
</tr>
<tr>
<td>password: </td>
<td><input type="password" name="password" value="${usersCustom.password }"/></td>
</tr>
<tr>
<td>email address(optional): </td>
<td><input type="text" name="email" value="${usersCustom.email }"/></td>
</tr>
<tr>
<td>city you live: </td>
<td>
<select name="location">
	<c:forEach items="${citiesList }" var="city">
		<option value="${city }">${city }</option>
	</c:forEach>
</select>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="signup"/></td>
</tr>
</table>
</form>
</body>
</html>