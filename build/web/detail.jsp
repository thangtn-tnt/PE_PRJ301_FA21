<%--
    Document   : detail
    Created on : Nov 6, 2021, 2:34:40 PM
    Author     : Trương Nhựt Thăng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>
    </head>
    <body>

        <%= session.getAttribute("name") != null ? session.getAttribute("name") : ""%>
        <br>
        <%= request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>
        <br>
        <h2>Detail</h2>
        <table border="1" cellpadding="10">
            <thead>
                <tr>
                    <th>IDStaff</th>
                    <th>Fullname</th>
                    <th>Phone</th>
                    <th>Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="x">
                    <tr>
                        <td>${x.id}</td>
                        <td>${x.name}</td>
                        <td>${x.phone}</td>
                        <td>${x.date}</td>
                        <td><a href="Delete?id=${x.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="insert.jsp"><input type="button" value="Return insert"></a>
    </body>
</html>
