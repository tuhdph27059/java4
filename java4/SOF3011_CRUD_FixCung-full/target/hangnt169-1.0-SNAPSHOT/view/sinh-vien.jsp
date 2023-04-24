<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/01/2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header class="container"><h3 style="text-align: center;margin-top:15px;">Quản Lý Sinh Viên</h3>
</header>
<main class="container">
    <section>
        <a href="/sinh-vien/view-add" class="btn btn-success " tabindex="-1" role="button"
           aria-disabled="true">Add</a>
    </section>
    <section>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã sinh viên</th>
                <th scope="col">Tên sinh viên</th>
                <th scope="col">Tuổi</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Giới tinh</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <%--            for(SinhVien sv:lists)--%>
            <c:forEach items="${sinhViens}" var="sv">
                <tr>
                    <td>${sv.maSV}</td>
                    <td>${sv.tenSV}</td>
                    <td>${sv.tuoi}</td>
                    <td>${sv.diaChi}</td>
                    <td>
                        <c:if test="${sv.gioiTinh == 'true'}">Nam</c:if>
                        <c:if test="${sv.gioiTinh == 'false'}">Nữ</c:if>
                    </td>
                    <td>
                        <a href="/sinh-vien/detail?mssv=${sv.maSV}" class="btn btn-primary " tabindex="-1" role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/sinh-vien/delete?mssv=${sv.maSV}" class="btn btn-danger " tabindex="-1" role="button"
                           aria-disabled="true">Delete</a>
                        <a href="/sinh-vien/view-update?mssv=${sv.maSV}" class="btn btn-success " tabindex="-1"
                           role="button"
                           aria-disabled="true">Update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
<footer><p style="text-align: center;">HangNT169</p></footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
