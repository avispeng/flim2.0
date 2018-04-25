<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${moviesCustom.movieTitle }</title>
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
<table width="100%" border=1>
<tr>
<td>movie title: </td>
<td>${moviesCustom.movieTitle }</td>
</tr>
<tr>
<td>movie rating: </td>
<td>
	<c:choose>
	<c:when test="${moviesCustom.rating !=null and moviesCustom.rating !=0.}">
		${moviesCustom.rating }
	</c:when>
	<c:otherwise>
		not available
	</c:otherwise>
	</c:choose>
</td>
</tr>
<tr>
<td>release date: </td>
<td>${moviesCustom.releaseDate }</td>
</tr>
<tr>
<td>IMDb number: </td>
<td>${moviesCustom.imdbId }</td>
</tr>
<tr>
<td>genres: </td>
<td>
	<c:forEach items="${moviesCustom.genresArray }" var="genre">
		${genre } 
	</c:forEach>
</td>
</tr>
<tr>
<td>poster: </td>
<td>
	<c:if test="${moviesCustom.poster != null }">
	<img src="/pic/${moviesCustom.poster }" width=100 height=160 />
	</c:if>
</td>
</tr>
<tr>
<td>summary: </td>
<td>${moviesCustom.summary }</td>
</tr>
<tr>
<td>your review: </td>
<td>
<c:if test="${reviewsCustom != null }">
<p>title: ${reviewsCustom.reviewTitle }</p>
<p>your rating: ${reviewsCustom.rating }</p>
<span>${reviewsCustom.review }</span>
</c:if>
<br>
<c:if test="${username != null }">
<a href="${pageContext.request.contextPath }/reviews/editReview.action?movieId=${moviesCustom.movieId}&username=${username}">add or edit your review</a>
</c:if>
</td>
</tr>
</table>
<h3>reviews of ${moviesCustom.movieTitle }</h3>
<table width="100%" border=1>
<c:if test="${reviewsCustomList!=null }">
<c:forEach items="${reviewsCustomList }" var="oneReview">
<tr>
<td>${oneReview.username }</td>
<td>
<p>${oneReview.reviewTitle }</p>
<span>${oneReview.review }</span>
</td>
</tr>
</c:forEach>
</c:if>
</table>
</body>
</html>