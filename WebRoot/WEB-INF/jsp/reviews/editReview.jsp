<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit or add your review</title>
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
<form id="editReviewForm" action="${pageContext.request.contextPath }/reviews/editReviewSubmit.action" method="post">
<input type="hidden" name="movieId" value="${reviewsCustom.movieId }" />
<input type="hidden" name="userid" value="${reviewsCustom.userid }" />
<input type="hidden" name="reviewId" value="${reviewsCustom.reviewId }" />
<p><input type="text" name="reviewTitle" value="${reviewsCustom.reviewTitle }"/></p>
<select name="rating">
	<c:forEach items="${ratings }" var="rating">
		<c:choose>
		<c:when test="${rating == reviewsCustom.rating }">
		<option value="${rating}" selected >${rating}</option>
		</c:when>
		<c:otherwise>
		<option value="${rating}">${rating}</option>
		</c:otherwise>
		</c:choose>
	</c:forEach>
</select><br>
<textarea rows="10" cols="40" name="review">${reviewsCustom.review }</textarea>
<input type="submit" value="submit"/>
</form>
</body>
</html>