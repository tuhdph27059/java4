<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/28/2023
  Time: 1:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cửa Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
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
<h1 class="container" style="text-align: center">Cửa Hàng</h1>
<form class="container" action="/cua-hang/add" method="post">
    <div class="mb-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="ma">
    </div>
    <div class="mb-3">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" name="ten">
    </div>
    <div class="mb-3">
        <label class="form-label">Địa Chỉ</label>
        <input type="text" class="form-control" name="diaChi">
    </div>
    <div class="mb-3">
        <label class="form-label">Thành Phố</label>
        <input type="text" class="form-control" name="thanhPho">
    </div>
    <div class="mb-3">
        <label class="form-label">Quốc Gia</label>
        <input type="text" class="form-control" name="quocGia">
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Mã Cửa Hàng</th>
        <th scope="col">Tên Cửa Hàng</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col">Thành Phố</th>
        <th scope="col">Quốc Gia</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCuaHang}" var="kh">
        <tr>
            <td scope="row">${kh.id}</td>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>
                <a href="/cua-hang/detail?id=${kh.id}" class="btn btn-success">Detail</a>
                <a href="/cua-hang/delete?id=${kh.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
