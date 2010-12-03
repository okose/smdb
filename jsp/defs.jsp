<%@ page import = "java.util.List" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "org.hibernate.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>SMDB Definitions</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>
        <a href=<%=request.getRequestURL() + "?" + request.getQueryString()%>>Refresh</a> |
        <a href="add.jsp">Add to a film</a> |
        <a href="home.jsp">Home</a>
        <hr/>

<table border="1">
<tr>
	<th>Concept</th>
	<th>Definition</th>
</tr>
<% 
// Managers.
logic.GoreLevelManager lGMan = new logic.GoreLevelManager();
List<access.GoreLevel> ds = lGMan.getAll();
logic.StereotypeManager lStereotypeMan = new logic.StereotypeManager();
List<access.Stereotype> lStereotypes = lStereotypeMan.getAll();
logic.NudityShotManager lNudityShotMan = new logic.NudityShotManager();
List<access.NudityShot> lNudityShots = lNudityShotMan.getAll();
logic.FilmSeriesManager lFilmSeriesMan = new logic.FilmSeriesManager();
List<access.FilmSeries> lFilmSeriess = lFilmSeriesMan.getAll();
String lShowAllForCategory = request.getParameter("s");
%>
<%for(access.GoreLevel lObj : ds)
{
    // Needs the null check or we may get an error when not used in url.
String lQ = request.getParameter("GoreLevel");
if (lQ != null && (lObj.getTitle().compareTo(lQ) == 0 || Boolean.parseBoolean(lShowAllForCategory)))
    {%>
<tr><td><a href=<%=request.getRequestURL() + "?GoreLevel=" + lObj.getTitle().replaceAll(" ", "+")%>><%=lObj.getTitle()%></a></td></tr>
<%}}%>
<%for(access.Stereotype lObj : lStereotypes)
{
String lQ = request.getParameter("Stereotype");
if (lQ != null && (lObj.getTitle().compareTo(lQ) == 0 || Boolean.parseBoolean(lShowAllForCategory)))
    {%>
<tr><td> <a href=<%=request.getRequestURL() + "?Stereotype=" + lObj.getTitle().replaceAll(" ", "+")%>><%=lObj.getTitle()%></a></td>
<td><%=lObj.getDescriptionShort()%> <br/> <%=lObj.getDescriptionLong()%></td></tr>
<%}}%>
<%for(access.FilmSeries lObj : lFilmSeriess)
{
String lQ = request.getParameter("FilmSeries");
if (lQ != null && (lObj.getTitle().compareTo(lQ) == 0 || Boolean.parseBoolean(lShowAllForCategory)))
    {%>
<tr><td>Series: <br/>
        <a href=<%=request.getRequestURL() + "?FilmSeries=" + lObj.getTitle().replaceAll(" ", "+")%>>
            <%=lObj.getTitle()%></a></td>
<td>The films in this series are:
    <%for(access.Film lFilm : lFilmSeriesMan.getFilms(lObj.getTitle()))
{
%>
    <br/> <%=lFilm.getNumberInTheSeries()%>,
     <a href=<%="film.jsp?Title=" + lFilm.getTitle().replaceAll(" ", "+") + "&N="
         + lFilm.getNumberInTheSeries()%>><%=lFilm.getTitle()%></a>
    <%}%>
    <br /> <br/>
    The killer is: <%=lObj.getKiller()%> <br/>
    Years range: <%=lFilmSeriesMan.getYearRange(lObj.getTitle())%><br/>
    The dominant theme seems to be: <%=lObj.getDominantTheme()%> <br/>
    Watching all the films back to back takes: <%=lFilmSeriesMan.countRuntime(lObj.getTitle())%> Minutes</td></tr>
<%}}%>
</table>
<a href=<%=request.getRequestURL() + "?" + request.getQueryString() + "&s=true"%>>Show all for this category.</a>
</body>
</html>
