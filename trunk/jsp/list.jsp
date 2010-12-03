<%@ page import = "java.util.List" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "org.hibernate.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>List of slasher films grouped by series:</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>
        <a href="list.jsp">Refresh</a> |
        <a href="add.jsp">Add to a film</a> |
        <a href="home.jsp">Home</a>
        <hr/>
        <%
String lOrderBy = request.getParameter("orderBy") == null ? "Title" : request.getParameter("orderBy");
%>
<table border="1">
<tr>
    <th><% if (lOrderBy.compareTo("Title") != 0) {%>
        <a href=<%=request.getRequestURL() + "?orderBy=Title"%>>order by</a>
        <%}%></th>
	<th></th>
        <th><% if (lOrderBy.compareTo("Gore") != 0) {%>
        <a href=<%=request.getRequestURL() + "?orderBy=Gore"%>>order by</a>
        <%}%></th>
	<th></th>
        <th><% if (lOrderBy.compareTo("Nudity") != 0) {%>
        <a href=<%=request.getRequestURL() + "?orderBy=Nudity"%>>order by</a>
        <%}%></th>
</tr>
<tr>
	<th>Title</th>
	<th>Body Count</th>
	<td>Average <a href="defs.jsp?GoreLevel=null&s=true">Violence</a> of Kills:</td>
	<th>Nudity Shots</th>
	<td>Average Nudity Shot:</td>
</tr>
<% 
// Manager for film seriess.
logic.FilmManager lFilmMan = new logic.FilmManager();

List<access.Film> films = lFilmMan.getAllOrderBy(lOrderBy);
%>
<%
for(access.Film lFilm : films)
{
%>
<tr>
    <td><a href=<%="film.jsp?Title=" + lFilm.getTitle().replaceAll(" ", "+") + "&N="
         + lFilm.getNumberInTheSeries()%>><%=lFilm.getTitle()%></a></td>
    <td><%=lFilmMan.countKills(lFilm.getid())%></td>
    <td><%=lFilmMan.avgKills(lFilm.getid())%></td>
    <td><%=lFilmMan.countNudityShots(lFilm.getid())%></td>
    <td><%=lFilmMan.avgNudityShots(lFilm.getid())%></td>
</tr>
<%
}
%>
</table>
</body>
</html>
