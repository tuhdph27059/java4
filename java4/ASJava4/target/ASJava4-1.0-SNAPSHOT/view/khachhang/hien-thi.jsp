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
    <title>Khách Hàng</title>
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
<h1 class="container" style="text-align: center">Khách Hàng</h1>
<form class="container" action="/khach-hang/add" method="post">
    <div class="mb-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="ma">
    </div>
    <div class="row">
        <div class="col-4">
            <label class="form-label">Họ</label>
            <input type="text" class="form-control" name="ho">
        </div>
        <div class="col-4">
            <label class="form-label">Tên Đệm</label>
            <input type="text" class="form-control" name="tenDem">
        </div>
        <div class="col-4">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten">
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <label class="form-label">Ngày Sinh</label>
            <input type="date" class="form-control" name="ngaySinh">
        </div>
        <div class="col-4">
            <label class="form-label">SĐT</label>
            <input type="text" class="form-control" name="sdt">
        </div>
        <div class="col-4">
            <label class="form-label">Địa Chỉ</label>
            <input type="text" class="form-control" name="diaChi">
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <label class="form-label">Thành Phố</label>
            <input type="text" class="form-control" name="thanhPho">
        </div>
        <div class="col-4">
            <label class="form-label">Quốc Gia</label>
            <input type="text" class="form-control" name="quocGia">
        </div>
        <div class="col-4">
            <label class="form-label">Mật Khẩu</label>
            <input type="text" class="form-control" name="matKhau">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Tên Đệm</th>
        <th scope="col">Họ</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">SĐT</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col">Thành Phố</th>
        <th scope="col">Quốc Gia</th>
        <th scope="col">Mật Khẩu</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKhachHang}" var="kh">
        <tr>
            <td scope="row">${kh.id}</td>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.tenDem}</td>
            <td>${kh.ho}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.thanhPho}</td>
            <td>${kh.quocGia}</td>
            <td>${kh.matKhau}</td>
            <td>
                <a href="/khach-hang/detail?id=${kh.id}" class="btn btn-success">Detail</a>
                <a href="/khach-hang/remove?id=${kh.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
