<nav>
    <div> 
        <a href="/" class="here">Home</a>
    </div>
</nav>

<%
if(session.getAttribute("username") == null)
	response.sendRedirect("/");
%>
