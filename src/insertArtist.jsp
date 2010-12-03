<%@ page import = "businessLayer.ArtistManager" %>
<%@ page import = "entities.artist.iArtistService" %>
<%@ page import = "entities.artist.Artist" %>
<%@ page import = "java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>YassTunes Application</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
</head>
<body>
<h1>YassTunes Application</h1>
<h2>Insert Artist:</h2>

<form method="post" action="insertArtist.jsp">
<input type="text" name="artistName" />
<input type="text" name="artistGender" />
<input type="text" name="artistDescription" />
<input type="submit" value="submit" />
</form>

<%
	if (request.getParameter("artistName") != null)
	{
		iArtistService ser = new ArtistManager();
		ser.addArtist("artistName", "artistGender", "artistDescription");
%>
<table border="1">
<tr>
	<th>Artist ID</th>
	<th>Artist Name</th>
	<th>Artist Gender</th>
	<th>Artist Description</th>
</tr>
<% 
	iArtistService ser = new ArtistManager();
	List<Artists> art = ser.fetchAllArtists();
	
	
	for(Artists artist : art)
	{
%>
<tr>
	<td><%=artist.getArtistId()%></td>
	<td><%=artist.getArtistName()%></td>
	<td><%=artist.getArtistGender().getBorrowDate()%></td>
	<td><%=artist.getArtistDescription()%></td>
</tr>
<%
	}
%>
</table>
<p>
<a href="home.jsp" title="Back to homepage">Back to homepage</a>
</p>
</body>
</html>