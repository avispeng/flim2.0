<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert a new movie</title>
</head>
<body>
<!-- display errors if there are any -->
<c:if test="${allErrors != null}">
	<c:forEach items = "${allErrors }" var="error">
	${error.defaultMessage }<br/>
	</c:forEach>
</c:if>
<form id="movieForm" action="${pageContext.request.contextPath }/movies/insertMoviesSubmit.action"
method="post" enctype="multipart/form-data">
<table border="1" width="100%">
<tr>
	<td>Title</td>
	<td><input type="text" name="movieTitle" value="${moviesCustom.movieTitle }"/></td>
</tr>
<tr>
	<td>IMDb number</td>
	<td><input type="text" name="imdbId" value="${moviesCustom.imdbId }"/></td>
<tr>
	<td>Release Date(yyyy-MM-dd)</td>
	<td><input type="text" name="releaseDate" value='<fmt:formatDate value="${moviesCustom.releaseDate }" pattern="yyyy-MM-dd"/>' /></td>
</tr>
<tr>
	<td>Genres</td>
	<td>
		<c:forEach items="${allGenres }" var="genre">
		<input type="checkbox" name="genres_array" value="${genre }"/>${genre }
		</c:forEach>
	</td>
</tr>
<tr>
	<td>Cast(use comma to separate multiple inputs)</td>
	<td>
	Directors:<input type="text" name="directors" value="${moviesCustom.directors }"><br>
	Writers:<input type="text" name="writers" value="${moviesCustom.writers }"><br>
	Stars:<input type="text" name="stars" value="${moviesCustom.stars }"><br>
	</td>
</tr>
<tr>
<td>Also known as:(use comma to separate multiple inputs)</td>
<td><input type="text" name="aka" value="${moviesCustom.aka }"></td>
</tr>
<tr>
<td>Languages:(use comma to separate multiple inputs)</td>
<td><input type="text" name="languages" value="${moviesCustom.languages }"></td>
</tr>
<tr>
<td>Countries:(use comma to separate multiple inputs)</td>
<td><input type="text" name="countries" value="${moviesCustom.countries }"></td>
</tr>
<tr>
	<td>Poster</td>
	<td><input type="file" name="movie_poster" /></td>
</tr>
<tr>
	<td>Summary</td>
	<td><textarea rows="10" cols="40" name="summary">${moviesCustom.summary }</textarea></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="submit" /></td>
</tr>
</table>
</form>
</body>
</html>