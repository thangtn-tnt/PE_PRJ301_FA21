<%--
    Document   : insert
    Created on : Nov 6, 2021, 2:34:33 PM
    Author     : Trương Nhựt Thăng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
    </head>
    <body>
        <%= request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>
        <h2>Insert</h2>
        <form action="Insert" method="POST">
            <input type="text" name="IDStaff" placeholder="IDStaff" />
            <br>
            <input type="text" name="Fullname" placeholder="Fullname" />
            <br>
            <input type="text" name="Phone" placeholder="Phone" />
            <br>
            <input type="text" name="Date" placeholder="Date" />
            <br>
            <input type="submit" value="Insert" />
            <input type="reset" value="Clear" />
        </form>
    </body>
</html>
