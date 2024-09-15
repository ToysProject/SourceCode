<%-- 
    Document   : CustomeAccountView
    Created on : Sep 12, 2024, 3:38:20 PM
    Author     : Alex
--%>
<%@page import="Backend.CustomerDataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <%
    HttpSession ses2 = request.getSession();
    CustomerDataModel customer = (CustomerDataModel) ses2.getAttribute("customer");
    %>
    <h1>Hello <%=customer.getFirstName()%>!</h1>
    </body>
</html>
