<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/28/2023
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
<h1 class="container" style="text-align: center">Khách Hàng</h1>
<form class="container" action="/khach-hang/update?id=${khachHang.id}" method="post">
    <div class="mb-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="ma" value="${khachHang.ma}">
    </div>
    <div class="row">
        <div class="col-4">
            <label class="form-label">Họ</label>
            <input type="text" class="form-control" name="ho" value="${khachHang.ho}">
        </div>
        <div class="col-4">
            <label class="form-label">Tên Đệm</label>
            <input type="text" class="form-control" name="tenDem" value="${khachHang.tenDem}">
        </div>
        <div class="col-4">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten" value="${khachHang.ten}">
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <label class="form-label">Ngày Sinh</label>
            <input type="date" class="form-control" name="ngaySinh" value="${ngaySinh}">
        </div>
        <div class="col-4">
            <label class="form-label">SĐT</label>
            <input type="text" class="form-control" name="sdt" value="${khachHang.sdt}">
        </div>
        <div class="col-4">
            <label class="form-label">Địa Chỉ</label>
            <input type="text" class="form-control" name="diaChi" value="${khachHang.diaChi}">
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <label class="form-label">Thành Phố</label>
            <input type="text" class="form-control" name="thanhPho" value="${khachHang.thanhPho}">
        </div>
        <div class="col-4">
            <label class="form-label">Quốc Gia</label>
            <input type="text" class="form-control" name="quocGia" value="${khachHang.quocGia}">
        </div>
        <div class="col-4">
            <label class="form-label">Mật Khẩu</label>
            <input type="text" class="form-control" name="matKhau" value="${khachHang.matKhau}">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
