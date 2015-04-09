<%-- 
    Document   : error
    Created on : Nov 4, 2014, 4:53:07 PM
    Author     : abu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <body>
        <h1>Error!</h1>
        <p>
            <%=request.getAttribute("message")%>
    </body>
</html>
