<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/14/2023
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Động Vật</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên</th>
        <th scope="col">Tuổi</th>
        <th scope="col">Trạng Thái</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listDongVat}" var="dongvat">
        <tr>
            <td>${dongvat.id}</td>
            <td>${dongvat.ten}</td>
            <td>${dongvat.tuoi}</td>
            <td>${dongvat.trangThai}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
