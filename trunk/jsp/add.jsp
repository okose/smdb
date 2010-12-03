<%@ page import = "java.util.List" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "org.hibernate.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Add to a film:</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>
        <a href="add.jsp">Refresh</a> |
        <a href="home.jsp">Home</a>
        <hr/>
<!--                 MAIN FORM. -->
<form action="add.jsp"
 method="POST"><span style="color: rgb(0, 102, 0);">Film we are talking
about:</span>
</form>
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
  <select>
<%for(access.Film lfilm : films)
{%>
  <option><%=lFilmMan.doPrint(lfilm.getid())%></option>
<%}%>
  </select>
  &nbsp;&nbsp;&nbsp; or <a href="addFilm.jsp">add new film</a>
  <table border="1" cellpadding="2" cellspacing="2">
    <tbody>
      <tr>
      </tr>
      <tr>
        <td style="vertical-align: top;"><br/>
<span class="text"><br/>
</span>
        <span style="color: rgb(0, 102, 0);">New Kill:</span><br/>
        <table style="text-align: left; width: 100%;" border="1"
 cellpadding="2" cellspacing="2">
          <tbody>
            <tr>
              <td style="vertical-align: top;"><span
 style="color: rgb(102, 0, 0);">Complete the following
description. Definitions of the words you choose can
be found under.</span><br/>
              <span style="color: rgb(0, 0, 102);"><br/>
              </span>
              <select style="color: rgb(0, 0, 102);" name="Killer">
              <option value="0">the killer</option>
              <option value="1">someone who isn't the killer</option>
              </select>
              <span style="color: rgb(0, 0, 102);">killed off a
character that </span><span style="color: rgb(0, 0, 102);"><br/>
              <select name="IsVictimSexualDuringFilm"
 style="color: rgb(0, 0, 102);">
              <option value="0">was not</option>
              <option value="1">was</option>
              </select>
commiting a sexual act earlier in the film. This happened <br/>
              <select name="IsOffScreen" style="color: rgb(0, 0, 102);">
              <option value="0">on</option>
              <option value="1">off</option>
              </select>
screen, and we <br/>
              <span style="color: rgb(0, 0, 102);"> </span>
              <select name="IsNoBody" style="color: rgb(0, 0, 102);">
              <option value="0">see a</option>
              <option value="1">just assume that the kill happened,
because we don't see a</option>
              </select>
body.<span style="color: rgb(0, 0, 102);"><br/>
I would like to justify my choices, or add a general note to other uses
of the site that says:<br/>
              </span></span><textarea cols="40" rows="5" name="Comment"></textarea><br/>
              <span style="color: rgb(0, 0, 102);"><span
 style="color: rgb(0, 0, 102);"><br/>
              <span style="font-weight: bold;">The kill
occured</span></span></span><span
 style="color: rgb(0, 0, 102); font-weight: bold;"><br/>
              </span><input
 style="color: rgb(0, 0, 102); font-weight: bold;" name="Time"
 value="61" size="3" type="text"/><span
 style="color: rgb(0, 0, 102); font-weight: bold;"> minutes in. The
stereotype of the victim was<br/>
              </span>
              <select name="Stereotype"
 style="color: rgb(0, 0, 102); font-weight: bold;">
<%for(access.Stereotype lObj : lStereotypes)
{%>
  <option><%=lStereotypeM.printNice(lObj.printKey())%></option>
<%}%>
              </select>
              <span style="font-weight: bold;"> </span><span
 style="color: rgb(0, 0, 102); font-weight: bold;">. </span><br
 style="font-weight: bold;"/>
              <span style="color: rgb(0, 0, 102); font-weight: bold;"><span
 style="color: rgb(0, 0, 102);">
              <select name="GoreLevel" style="color: rgb(0, 0, 102);">

<%for(access.GoreLevel lObj : lGoreLevels)
{%>
  <option><%=lGoreLevelM.doPrint(lObj.printKey())%></option>
<%}%>
              </select>
is how gorey it was. The most gorey part of it was when a <br/>
              <select name="Weapon" style="color: rgb(0, 0, 102);">
              <option value="Not Visible">Weapon that we could not see</option>
              <option value="New Weapon">new weapon called:</option>
<%for(access.Weapon lWeapon : lWeapons)
{%>
  <option><%=lWeaponM.doPrint(lWeapon.printKey())%></option>
<%}%>
              </select>
              <input style="color: rgb(0, 0, 102); font-weight: bold;"
 name="NewWeapon"
 value=""
 size="56"/><span style="color: rgb(0, 0, 102); font-weight: bold;"> <br/>
              <select name="CauseOfDeath" style="color: rgb(0, 0, 102);">
              <option value="Null">Did something we couldn not see to</option>
<%for(access.CauseOfDeath lCauseOfDeath : lCauseOfDeaths)
{%>
  <option><%=lCauseOfDeathM.doPrint(lCauseOfDeath.printKey())%></option>
<%}%>
              </select>
their <br/>
              <select name="BodyPart" style="color: rgb(0, 0, 102);">
              <option value="Null">Body part we could not see</option>
              <option>Body</option>
              <option>Head</option>
              <option>Neck</option>
              <option>Eye</option>
              </select>
. <br/>
              <input style="color: rgb(102, 0, 0);" value="Add"
 type="submit"/></span> </span></span></td>
            </tr>
          </tbody>
        </table>
&nbsp; <span style="color: rgb(0, 102, 0);"><br/>
New Femle Nudity
Shot:</span><br/>
        <form action="add.jsp"
 method="POST"><table style="text-align: left; width: 100%;" border="1"
 cellpadding="2" cellspacing="2">
          <tbody>
            <tr>
              <td style="vertical-align: top;"><span
 style="color: rgb(102, 0, 0);"><br/>
              </span><span style="color: rgb(0, 0, 102);"><span
 style="color: rgb(0, 0, 102);"><span style="font-weight: bold;">At</span></span></span><span
 style="color: rgb(0, 0, 102); font-weight: bold;"><br/>
              </span><input
 style="color: rgb(0, 0, 102); font-weight: bold;" name="Time"
 value="20" size="3"/><span
 style="color: rgb(0, 0, 102); font-weight: bold;"> minutes in</span><span
 style="color: rgb(0, 0, 102); font-weight: bold;"><br/>
              </span>
              <select name="Stereotype"
 style="color: rgb(0, 0, 102); font-weight: bold;">
<%for(access.Stereotype lObj : lStereotypes)
{%>
  <option><%=lStereotypeM.printNice(lObj.printKey())%></option>
<%}%>
              </select>
              <span style="font-weight: bold;"> </span><span
 style="color: rgb(0, 0, 102); font-weight: bold;">showed us</span> <br
 style="font-weight: bold;"/>
              <span style="color: rgb(0, 0, 102); font-weight: bold;"><span
 style="color: rgb(0, 0, 102);">
              <select name="Type" style="color: rgb(0, 0, 102);">
              <option>Implied Nudity</option>
              <option>Breasts</option>
              <option>Full Frontal</option>
              </select>
.</span></span><span style="color: rgb(0, 0, 102);"><span
 style="color: rgb(0, 0, 102);"><br/>
              </span></span><span style="color: rgb(0, 0, 102);"><span
 style="color: rgb(0, 0, 102);">I would like to justify my choices, or
add a general note to other uses
of the site that says:</span></span><br/>
              <textarea cols="40" rows="5" name="Comment"></textarea><br/>
              <span style="color: rgb(0, 0, 102); font-weight: bold;"><span
 style="color: rgb(0, 0, 102);"><span
 style="color: rgb(0, 0, 102); font-weight: bold;"> <input
 style="color: rgb(102, 0, 0);" value="Add" type="submit"/></span> </span></span></td>
            </tr>
          </tbody>
        </table>
</form>
        <br/>
        <span style="color: rgb(0, 102, 0);">New Survivor:</span><br/>
<form action="add.jsp"
 method="POST">
        <table style="text-align: left; width: 100%;" border="1"
 cellpadding="2" cellspacing="2">
          <tbody>
            <tr>
              <td style="vertical-align: top;"><span
 style="color: rgb(102, 0, 0);"><br/>
              <select name="Stereotype"
 style="color: rgb(0, 0, 102); font-weight: bold;">
<%for(access.Stereotype lObj : lStereotypes)
{%>
  <option><%=lStereotypeM.printNice(lObj.printKey())%></option>
<%}%>
              </select>
witnessed the killer try to kill them but failed.
              <input style="color: rgb(102, 0, 0);" value="Add"
 type="submit"/></span> </td>
            </tr>
          </tbody>
        </table>

</form>
        <span style="color: rgb(0, 102, 0);"><br/>
New Comment:</span><br/>
<form action="add.jsp" method="POST">
        <table style="text-align: left; width: 100%;" border="1"
 cellpadding="2" cellspacing="2">
          <tbody>
            <tr>
              <td style="vertical-align: top;"><span
 style="color: rgb(102, 0, 0);"></span><span
 style="color: rgb(0, 0, 102);"><span style="color: rgb(0, 0, 102);">A
general note to other uses
of the site about this film at </span></span><span
 style="color: rgb(0, 0, 102); font-weight: bold;"><br/>
              </span><input
 style="color: rgb(0, 0, 102); font-weight: bold;" name="Time"
 value="61" size="3" type="text"/><span
 style="color: rgb(0, 0, 102); font-weight: bold;"> </span><span
 style="color: rgb(0, 0, 102);">minutes in:</span><span
 style="color: rgb(0, 0, 102);"><span style="color: rgb(0, 0, 102);"><br/>
              </span></span><textarea cols="40" rows="5" name="Comment"></textarea><span
 style="color: rgb(0, 0, 102);"><span style="color: rgb(0, 0, 102);"><span
 style="font-weight: bold;"></span></span></span><span
 style="color: rgb(0, 0, 102); font-weight: bold;"><span
 style="color: rgb(0, 0, 102);"><span
 style="color: rgb(0, 0, 102); font-weight: bold;"><br/>
              <input style="color: rgb(102, 0, 0);" value="Add"
 type="submit"/></span> </span></span></td>
            </tr>
          </tbody>
        </table>
</form>
</td>
</tr>
    </tbody>
  </table>



</body>
</html>
