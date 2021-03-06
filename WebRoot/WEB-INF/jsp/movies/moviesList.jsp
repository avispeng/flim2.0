<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movies List</title>
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
<form name="moviesForm" action="${pageContext.request.contextPath }/movies/queryMovies.action" method="post">
<table width="100%" border=1>
<tr>
	<td>
	Search by name: <input type="text" name="moviesCustom.movieTitle" />
	</td>
	<td>
	<input type="submit" value="search" />
	</td>
</tr>
</table>
Searching Results
<table width="100%" border=1>
<tr>
<th>Movie Title</th>
<th>Rating</th>
<th>Release Date</th>
<th>IMDb Number</th>
<th>Genres</th>
<th>Cast</th>
<th>Also Known as</th>
<th>Languages</th>
<th>Countries</th>
<th>Poster</th>
<th>Summary</th>
<th>Operation</th>
</tr>
<c:forEach items="${moviesList }" var="movie">
<tr>
	<td>${movie.movieTitle }</td>
	<td>
		<c:choose>
		<c:when test="${movie.rating !=null and movie.rating !=0.}">
			${movie.rating }
		</c:when>
		<c:otherwise>
			not available
		</c:otherwise>
		</c:choose>
	</td>
	<td>${movie.releaseDate }</td>
	<td>${movie.imdbId }</td>
	<td>
		<c:if test="${movie.genresArray!=null }">
		<c:forEach items="${movie.genresArray }" var="genre">
			${genre } 
		</c:forEach>
		</c:if>
	</td>
	<td>
	Directors:
		<c:if test="${movie.directorsArray!=null }">
		<c:forEach items="${movie.directorsArray }" var="director">
			${director }
		</c:forEach>
		</c:if><br>
	Writers:
		<c:if test="${movie.writersArray!=null }">
		<c:forEach items="${movie.writersArray }" var="writer">
			${writer }
		</c:forEach>
		</c:if><br>
	Actors:
		<c:if test="${movie.starsArray!=null }">
		<c:forEach items="${movie.starsArray }" var="star">
			${star }
		</c:forEach>
		</c:if>
	</td>
	<td>
		<c:if test="${movie.akaArray!=null }">
		<c:forEach items="${movie.akaArray }" var="aka">
			${aka }
		</c:forEach>
		</c:if>
	</td>
	<td>
		<c:if test="${movie.languagesArray!=null }">
		<c:forEach items="${movie.languagesArray }" var="language">
			${language }
		</c:forEach>
		</c:if>
	</td>
	<td>
		<c:if test="${movie.countriesArray!=null }">
		<c:forEach items="${movie.countriesArray }" var="country">
			${country }
		</c:forEach>
		</c:if>
	</td>
	<td>
		<c:if test="${movie.poster != null }">
		<img src="/pic/${movie.poster }" width=100 height=160 />
		</c:if>
	</td>
	<td>${movie.summary }</td>
	<td><a href="${pageContext.request.contextPath }/movies/getMovie.action?id=${movie.movieId}">Enter</a></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>