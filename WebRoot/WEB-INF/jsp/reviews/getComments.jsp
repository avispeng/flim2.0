<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${reviewsCustom.movieTitle } - ${reviewsCustom.reviewTitle }</title>
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
<form action="${pageContext.request.contextPath }/comments/addComment.action" method="post">
<input type="hidden" name="reviewId" value="${reviewsCustom.reviewId }">
<table width="100%" border=1>
<tr>
<td colspan="2">${reviewsCustom.reviewTitle }</td>
</tr>
<tr>
<td>${reviewsCustom.username }</td><td>${reviewsCustom.timeStamp }</td>
</tr>
<tr>
<td colspan="2"><span>${reviewsCustom.review }</span></td>
</tr>
</table>
<table width="100%" border=1>
<c:if test="${commentsList!=null }">
<c:forEach items="${commentsList }" var="comment">
	<tr>
	<td>${comment.floor }</td>
	<td><a href="${pageContext.request.contextPath }/users/getHomePage.action?id=${comment.userid}">${comment.username }</a></td>
	<td>${comment.timeStamp }</td>
	</tr>
	<tr>
	<td><c:if test="${comment.replyTo!=null }">reply to floor ${comment.replyTo }</c:if></td>
	<td colspan="2">${comment.content }</td>
	</tr>
</c:forEach>
</c:if>

<tr><td colspan="3"><textarea rows="10" cols="40" name="content">${commentsCustom.content }</textarea></td></tr>
<tr><td colspan="3"><input type="submit" value="add comment"/></td></tr>
</table>
</form>
</body>
</html>