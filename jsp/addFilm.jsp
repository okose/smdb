<%@ page import = "java.util.List" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "org.hibernate.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Add film:</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
    <body>
        <a href="addFilm.jsp">Refresh</a> |
        <a href="add.jsp">Add to a film</a> | 
        <a href="home.jsp">Home</a>
        <hr/>
<!--                 MAIN FORM. -->
<form action="add.jsp"
 method="POST">
</form>
<%
/** This whole thing assumes you never want to add a series with no films.
TODO: allow user to not put in some info. */
// Manager for film seriess.
    logic.IFilmSeriesLogic lFilmSeriesMan = new logic.FilmSeriesManager();

// Manager for film.
    logic.IFilmLogic lFilmMan = new logic.FilmManager();

// Get lists
    List<access.Film> films = lFilmMan.getAll();
    List<access.FilmSeries> filmSeriess = lFilmSeriesMan.getAll();

%>
&nbsp;
<span style="color: rgb(0, 102, 0);"><br/>
New Film/ Update Film:<br/></span>
<span class="text">  * means non optional field.<br/>
</span>
<form action="addFilm.jsp"
 method="POST">
  <table border="1" cellpadding="2" cellspacing="2">
    <tbody>
      <tr>
      </tr>
      <tr>
      </tr>
      <tr>
        <td style="vertical-align: top;">
        <div style="text-align: left;"><span
 style="color: rgb(0, 102, 0);"></span>Name*: <input
 style="color: rgb(0, 0, 102); font-weight: bold;" name="Title" size="30"/><br/>
Film Series*:<span style="color: rgb(0, 102, 0);"></span>

<select name="FilmSeries">
        <option>Its own new series</option>

<%
for(access.FilmSeries lfilmSeries : filmSeriess)
{
%>
  <option><%=lFilmSeriesMan.doPrint(lfilmSeries.getTitle())%></option>
<%
}
%>
        </select>
        <br/>
Number in the series*: <input value="1"
 style="color: rgb(0, 0, 102); font-weight: bold;" name="NumberInTheSeries" size="2"/><br/>
        </div>
        <div style="text-align: left;">Year: <input value="1982"
 style="color: rgb(0, 0, 102); font-weight: bold;" name="Year" size="4"/><br/>
        </div>
Runtime: <input value="96"
 style="color: rgb(0, 0, 102); font-weight: bold;" name="Runtime"
 size="3" /><br/>
Plot follows on from number: <input value="0"
 style="color: rgb(0, 0, 102); font-weight: bold;" name="PlotIsSequelTo"
 size="2" /><br/>
        <br/>
Fektime: <input value="60"
 style="color: rgb(0, 0, 102); font-weight: bold;"
 name="FEKTime" size="3" /><br/>
Most Talked About Scene:<br/>
        <textarea name="MostFuckedUpMoment" rows="5" cols="40"></textarea><br/>
        <br/>
        <span style="color: rgb(0, 0, 102); font-weight: bold;"><span
 style="color: rgb(0, 0, 102);"><span
 style="color: rgb(0, 0, 102); font-weight: bold;">
<input style="color: rgb(102, 0, 0);" value="Add" type="submit" /></span></span></span><br/>
        <span style="color: rgb(0, 0, 102); font-weight: bold;"> </span></td>
      </tr>
    </tbody>
  </table>
</form>

<%
if (request.getParameter("Title") != null)
    {
    // Add the new film. TODO: updating.
    access.FilmKey lFilmKey = new access.FilmKey();
    lFilmKey.setTitle(request.getParameter("Title"));
    lFilmKey.setNumberInTheSeries(new Integer(request.getParameter("NumberInTheSeries")));
    lFilmMan.insert(lFilmKey);
    // Check if they have left the series as a new one.
        String lFS = request.getParameter("FilmSeries");
        if (lFS.compareTo("Its own new series") == 0)
            {
            lFS = request.getParameter("Title");
            lFilmSeriesMan.insert(lFS);
            }    // Using the same title as first film.

    // Add to the series specified.
        lFilmSeriesMan.addFilm(lFS, lFilmKey);
    }
%>

<span style="color: rgb(0, 102, 0);"><br/>
Definitions:</span><br/>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
 cellspacing="2">
  <tbody>
    <tr>
      <td style="vertical-align: top;">Fektime:</td><td> {Final Girl Engages
Killer time} Time at which the final girl (or their potential lover in rare
occasions) meet the killer face to face knowing he is trying
to kill them and knowing he has killed friends of theirs. Almost always
ridiculously close to 60 minutes in. Almost always is the only one left
alive at this point appart from the potential lover and sherif. </td>
    </tr>
    <tr>
      <td style="vertical-align: top;">Most Talked About Scene:</td><td>
      Write a concise description about the scene or idea that you think will stick in the average viewers mind the most for being the most horrific.
  </td></tr>
  </tbody>
</table>
<br/>
<br/>

</body>
</html>