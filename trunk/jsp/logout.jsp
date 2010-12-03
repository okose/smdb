<%

     String username=(String)session.getAttribute("username");
    if(username!=null)
        {
           out.println(username+" loged out, <a href=\"home.jsp\">Back</a>");
            session.removeAttribute("username");

        }
     else
         {
         out.println("You are already not logged in <a href=\"home.jsp\">Back</a>");
     }



%> 