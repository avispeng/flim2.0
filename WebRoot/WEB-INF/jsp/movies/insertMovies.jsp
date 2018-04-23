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
<%-- 		<form:checkbox path="genresArray" value="drama" />drama<br/>
		<form:checkbox path="genresArray" value="comedy" />comedy<br/>
		<form:checkbox path="genresArray" value="action" />action<br/>
		<form:checkbox path="genresArray" value="crime" />crime<br/>
		<form:checkbox path="genresArray" value="romance" />romance<br/>
		<form:checkbox path="genresArray" value="lgbt" />LGBT<br/>
		<form:checkbox path="genresArray" value="scifi" />Sci-Fi<br/>
		<form:checkbox path="genresArray" value="thriller" />thriller<br/>
		<form:checkbox path="genresArray" value="mystery" />mystery<br/>
		<form:checkbox path="genresArray" value="fantasy" />fantasy<br/>
		<form:checkbox path="genresArray" value="animation" />animation<br/>
		<form:checkbox path="genresArray" value="adventure" />adventure<br/> --%>
<%-- 		<form:checkboxes items="${allGenres }" path="genres_array" /> --%>
		<c:forEach items="${allGenres }" var="genre">
		<input type="checkbox" name="genres_array" value="${genre }"/>${genre }
		</c:forEach>
	</td>
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