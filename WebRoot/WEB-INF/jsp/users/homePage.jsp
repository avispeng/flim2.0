<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${usersCustom.username }'s home</title>
</head>
<body>
<c:choose>
<c:when test="${username != null }">
current user: ${username },
<a href="${pageContext.request.contextPath }/users/logout.action">logout</a>
</c:when>
<c:otherwise>
<a href="${pageContext.request.contextPath }/users/register.action">signup</a>,
<a href="${pageContext.request.contextPath }/users/login.action">login</a>
</c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath }/movies/queryMovies.action">movies</a>
<table width="100%" border=1>
<tr>
<td>username: </td>
<td>${usersCustom.username }</td>
</tr>
<tr>
<td>email address: </td>
<td><c:if test="${usersCustom.email!=null }">${usersCustom.email }</c:if></td>
</tr>
<tr>
<td>where you live: </td>
<td><c:if test="${usersCustom.location!=null }">${usersCustom.location }</c:if></td>
</tr>
</table>
You have watched...

<c:if test="${reviewsList!=null }">
<c:forEach items="${reviewsList }" var="oneReview">
<table width="100%" border=1>
<tr>
<td colspan="2">
<a href="${pageContext.request.contextPath }/movies/getMovie.action?id=${oneReview.movieId}">${oneReview.movieTitle }</a>
</td>
<td>${oneReview.rating }</td>
</tr>
<tr>
<td>${oneReview.reviewTitle }</td>
<td>${oneReview.timeStamp }</td>
<td>${oneReview.thumbUp }</td>
</tr>
<tr><td colspan="3">${oneReview.review }</td>
</tr>
</table>
</c:forEach>
</c:if>
</body>
</html>