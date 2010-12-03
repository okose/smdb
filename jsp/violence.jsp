<%@ page import = "java.util.List" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "org.hibernate.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>SMDB Stats</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>
        <a href="violence.jsp">Refresh</a> |
        <a href="addFilm.jsp">Add a new film</a> |
        <a href="home.jsp">Home</a>
        <hr/>
<table border="1">
<tr>
	<th>Weapon</th>
	<th>Kills</th>
</tr>
<%
// Manager for film seriess.
logic.WeaponManager lWeaponMan = new logic.WeaponManager();

List<access.Weapon> objs = lWeaponMan.getAll();
%>
<%
for(access.Weapon lSubs : objs)
{
%>
<tr>
    <td><%=lSubs.getTitle()%></td>
    <td><%/*lWeaponMan.countKills(lSubs.getTitle())*/%></td>
</tr>
<%
}
%>
</table>
</body>
</html>
