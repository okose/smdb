<%@ page import = "java.util.List" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "org.hibernate.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>SMDB - Single Film Page</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>
        <a href="film.jsp">Refresh</a> |
        <a href="add.jsp">Add to a film</a> |
        <a href="home.jsp">Home</a>
        <hr/>
<%

logic.FilmManager lFilmMan = new logic.FilmManager();
logic.KillManager lKillMan = new logic.KillManager();
String lLoadError = "";
// Have to init.
access.FilmKey lKey = new access.FilmKey();
if (request.getParameter("N") != null && request.getParameter("Title") != null)
    lKey = new access.FilmKey(Integer.parseInt(request.getParameter("N")), request.getParameter("Title"));
access.Film lFilm = lFilmMan.getSpecific(lKey);
//lLoadError = "No film by that title.   error code:" + e.toString(); }
%>
<%=lLoadError%>
<h1><%=lFilmMan.printTitle(lKey)%></h1>

<table cellspacing="20">
<tr>
    <td>Released <i><%=lFilm.getYear()%></i></td>
    <td>Runtime <i><%=lFilm.getRuntime()%></i> Min</td>
    <td>Number <i><%=lFilm.getNumberInTheSeries()%></i> in <a href=<%="defs.jsp?FilmSeries=" + lFilm.getFilmSeries().getTitle().replaceAll(" ", "+")%>>the series</a>.</td>
</tr>
</table>
<h2>Kill Table</h2>
Total: <%=lFilmMan.countKills(lKey)%> <br />
Contains <%=lFilmMan.isHighGore(lKey)? "" : "NO "%><a href="defs.jsp?GoreLevel=High">High</a> gore kills.
<table cellspacing="20">
<tr>
	<th>Time</th>
	<th>Victim</th>
	<th>Gore</th>
	<th>Kill Story</th>
</tr>
<%
for(access.Kill lKill : lFilmMan.getKills(lKey))
{
%>
<tr>
    <td><%=lKill.getTime()%> Min</td>
    <!-- The replace is just to format no spaces in the url (GET uses + instead). -->
    <td><a href=<%="defs.jsp?Stereotype=" + lKill.getStereotype().getTitle().replaceAll(" ", "+")%>>
        <%=lKill.getStereotype().getTitle()%></a></td>
    
    <td><a href=<%="defs.jsp?GoreLevel=" + lKill.getGoreLevel().getTitle().replaceAll(" ", "+")%>><%=lKill.getGoreLevel().getTitle()%></a></td>
    <td><%=lKill.isIsNoBody()? "We assume (because you don't get to see the body) that": ""%>
        <%=lKill.isIsNotByKillerDirectly()? "someone": "the killer "%>
        <%=lKill.getCauseOfDeath().getTitle().toLowerCase()%>
        the victim's <%=lKill.getBodyPart().getTitle().toLowerCase()%>
        with a <%=lKill.getWeapon().getTitle().toLowerCase()%>.
        <%=lKill.isIsOffScreen()? "It sucked, because the kill occured off screen.": ""%></td>
</tr>
<%
}
%>
</table>


<h2>Nudity Shots</h2>
Total: <%=lFilmMan.countNudityShots(lKey)%> <br />
Contains <%=lFilmMan.isFullFrontal(lKey)? "" : "NO "%><a href="defs.jsp?NudityShot=Full+Frontal">Full Frontal</a> nudity.
<table cellspacing="20">
<tr>
	<th>Time</th>
	<th>Victim</th>
	<th>How much is revealed</th>
</tr>
<%
for(access.NudityShot lKill : lFilmMan.getNudityShots(lKey))
{
%>
<tr>
    <td><%=lKill.getTime()%> Min</td>
    <td><a href=<%="defs.jsp?Stereotype=" + lKill.getStereotype().getTitle().replaceAll(" ", "+")%>>
        <%=lKill.getStereotype().getTitle()%></a></td>
    <td><a href=<%="defs.jsp?NudityShot=" + lKill.getType().replaceAll(" ", "+")%>><%=lKill.getType()%></a></td>
</tr>
<%
}
%>
</table>
<h2>Survivors</h2>
Characters who faced the killer but did not die. <br/>
Total: <%=lFilmMan.countSurvivals(lKey)%>
<table cellspacing="20">
<%
for(access.Survival lKill : lFilmMan.getSurvivals(lKey))
{
%>
<tr>
    <td><a href=<%="defs.jsp?Stereotype=" + lKill.getStereotype().getTitle().replaceAll(" ", "+")%>>
        <%=lKill.getStereotype().getTitle()%></a></td>
</tr>
<%
}
%>
</table>

<h2>Cliches</h2>
<a href=<%="defs.jsp?Stereotype=Final+Girl"%>>Final girl</a> meets the killer at <%=lFilm.getFEKTime()%> / <%=lFilm.getRuntime()%> Mins in. <br/>
<%=lFilmMan.countVictimSexualDuringFilms(lKey)%> people have sex and die. <br/>
<%=lFilm.getPlotIsSequelTo() > 0 ? "The plot follows on from the " + lFilm.getPlotIsSequelTo() + "th film." : "It's a new plot not a sequel like the cliche."%> <br/>
<%=lFilm.getMostFuckedUpMoment().length() > 1 ? "One might say the most memorably horrific part of the film was " + lFilm.getMostFuckedUpMoment(): ""%> <br/>


</body>
</html>
