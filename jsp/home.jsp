<%@ page import = "java.util.List" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "org.hibernate.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Home</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>
        <a href="home.jsp">Refresh</a>
        <hr/>

<%
// Manager for film seriess.
    logic.IFilmSeriesLogic lFilmSeriesMan = new logic.FilmSeriesManager();
    List<access.FilmSeries> filmSeriess = lFilmSeriesMan.getAll();
 
// Manager for film.
    logic.IFilmLogic lFilmMan = new logic.FilmManager();
    List<access.Film> films = lFilmMan.getAll();
// Manager for weapon.
    logic.WeaponManager lWeaponM = new logic.WeaponManager();
    List<access.Weapon> lWeapons = lWeaponM.getAll();
// Manager.
    logic.CauseOfDeathManager lCauseOfDeathM = new logic.CauseOfDeathManager();
    List<access.CauseOfDeath> lCauseOfDeaths = lCauseOfDeathM.getAll();
// Manager.
    logic.GoreLevelManager lGoreLevelM = new logic.GoreLevelManager();
    List<access.GoreLevel> lGoreLevels = lGoreLevelM.getAll();
// Manager.
    logic.StereotypeManager lStereotypeM = new logic.StereotypeManager();
    List<access.Stereotype> lStereotypes = lStereotypeM.getAll();

%>
<img src="SMDBTitle.jpeg" alt="SMDB: Slasher Movie DataBase"/> <br/>
<%
        String myname = (String)session.getAttribute("username");

        if(myname!=null)
            {
             out.println("Welcome  "+myname+"  , <a href=\"logout.jsp\" >Logout</a>");
            }
        else
            {
            %>
            <form action="checkLogin.jsp">
                <table>
                    <tr>
                        <td> Username  : </td><td> <input name="username" size=15 type="text" /> </td>
                    </tr>
                    <tr>
                        <td> Password  : </td><td> <input name="password" size=15 type="text" /> </td>
                    </tr>
                </table>
                <input type="submit" value="login" />
            </form>
            <%
            }


            %>
<br/>
            Are YOU:
            <ul>
    <li>Looking for a slasher film to watch but can't trust reviews because mostly they are by people that are clearly new to the genre or don't take it seriously?
    </li><li>Wanting to list and read details about the kills and nudity shots in some <a href="film.jsp?Title=Halloween&N=1">random slasher film</a>?
</li><li>Wanting to know which slasher has the <a href="list.jsp?orderBy=Gore">highest body count</a>?
</li><li>Wanting to know which F13 dodged you out the most with the most off screen kills?
</li><li>Wanting to know if <a href="defs.jsp?FilmSeries=Halloween">Michael Myers</a> kills more people with a kitchen knife or his bare hands?
</li><li>Wanting to group every character ever into a small list of <a href="defs.jsp?Stereotype=null&s=true">stereotypes</a> and see which ones die and survive the most?
</li><li>Someone who has seen more films from the 80s than today, even if you weren't alive in them?
</li></ul>If yes to any of those, Start here:
            <ul>
    <li>
        Browse All <a href="defs.jsp?FilmSeries=null&s=true">By Series</a>
    </li>
    <li>
        Slasher Statistics:
        <ul>
            <li>
                 <a href="list.jsp">Films Stats</a>
            </li>
            <li>
                <a href="defs.jsp?Stereotype=null&s=true">Slasher StereoTypes</a>
            </li>
            <li>
                <a href="violence.jsp">Weapon Stats</a>
            </li>
</ul>
    </li>
    <li>
        Contribute to Slasher Database:
        <ul>
            <li>
                <a href="addFilm.jsp">New Film</a>
            </li>
            <li>
                <a href="add.jsp">Add info as you watch a film</a>
            </li>
        </ul>
    </li>
</ul>

</body>
</html>
