<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/28/2023
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chức Vụ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <nav class="nav">
        <a class="nav-link" href="/khach-hang/hien-thi">Khách Hàng</a>
        <a class="nav-link" href="/nhan-vien/hien-thi">Nhân Viên</a>
        <a class="nav-link" href="/san-pham/hien-thi">Sản Phẩm</a>
        <a class="nav-link" href="/mau-sac/hien-thi">Màu sắc</a>
        <a class="nav-link" href="/nsx/hien-thi">Nhà Sản Xuất</a>
        <a class="nav-link" href="/dong-sp/hien-thi">Dòng Sản Phẩm</a>
        <a class="nav-link" href="/chi-tiet-sp/hien-thi">Chi Tiết Sản Phẩm</a>
        <a class="nav-link" href="/chuc-vu/hien-thi">Chức Vụ</a>
        <a class="nav-link" href="/cua-hang/hien-thi">Cửa Hàng</a>
    </nav>
</div>
<h1 class="container" style="text-align: center">Chức Vụ</h1>
<form class="container" action="/chuc-vu/add" method="post">
    <div class="mb-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="ma">
    </div>
    <div class="mb-3">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" name="ten">
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Mã Chức Vụ</th>
        <th scope="col">Tên Chức Vụ</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listChucVu}" var="kh">
        <tr>
            <td scope="row">${kh.id}</td>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>
                <a href="/chuc-vu/detail?id=${kh.id}" class="btn btn-success">Detail</a>
                <a href="/chuc-vu/delete?id=${kh.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
