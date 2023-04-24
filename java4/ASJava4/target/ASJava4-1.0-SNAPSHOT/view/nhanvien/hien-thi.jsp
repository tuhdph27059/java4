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
    <title>Nhân Viên</title>
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
<h1 class="container" style="text-align: center">Nhân Viên</h1>
<form class="container" action="/nhan-vien/add" method="post">
    <div class="row">
        <div class="col-6">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" name="ma">
        </div>
        <div class="col-6">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten">
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label class="form-label">Tên Đệm</label>
            <input type="text" class="form-control" name="tenDem">
        </div>
        <div class="col-6">
            <label class="form-label">Họ</label>
            <input type="text" class="form-control" name="ho">
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <label class="form-label">Giới Tính</label><br>
            <input type="radio" name="gioiTinh" value="Nam" checked/>Nam
            <input type="radio" name="gioiTinh" value="Nữ"/>Nữ
        </div>
        <div class="col-3">
            <label class="form-label">Ngày Sinh</label>
            <input type="date" class="form-control" name="ngaySinh">
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label class="form-label">Địa Chỉ</label>
            <input type="text" class="form-control" name="diaChi">
        </div>
        <div class="col-6">
            <label class="form-label">SĐT</label>
            <input type="text" class="form-control" name="sdt">
        </div>
    </div>
    <div class="row">
        <div class="col-2">
            <label class="form-label">Cửa Hàng</label>
            <select class="form-select" name="idCH">
                <c:forEach items="${listCuaHang}" var="a">
                    <option value="${a.id}">${a.ma}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-2">
            <label class="form-label">Chức Vụ</label>
            <select class="form-select" name="idCV">
                <c:forEach items="${listChucVu}" var="a">
                    <option value="${a.id}">${a.ma}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label class="form-label">Mật Khẩu</label>
            <input type="text" class="form-control" name="matKhau">
        </div>
        <div class="col-6">
            <label class="form-label">Trạng Thái</label>
            <input type="text" class="form-control" name="trangThai">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Tên Đệm</th>
        <th scope="col">Họ</th>
        <th scope="col">Giới Tính</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col">SĐT</th>
        <th scope="col">Mật Khẩu</th>
        <th scope="col">Mã Cửa Hàng</th>
        <th scope="col">Mã Chức Vụ</th>
        <th scope="col">Trạng Thái</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNhanVien}" var="kh">
        <tr>
            <td scope="row">${kh.id}</td>
            <td>${kh.ma}</td>
            <td>${kh.ten}</td>
            <td>${kh.tenDem}</td>
            <td>${kh.ho}</td>
            <td>${kh.gioiTinh}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.diaChi}</td>
            <td>${kh.sdt}</td>
            <td>${kh.matKhau}</td>
            <c:forEach items="${listCuaHang}" var="a">
                <c:if test="${a.id==kh.idCH}">
                    <td>${a.ma}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${listChucVu}" var="a">
                <c:if test="${a.id==kh.idCV}">
                    <td>${a.ma}</td>
                </c:if>
            </c:forEach>
            <td>
                <c:if test="${kh.trangThai==0}">Failed</c:if>
                <c:if test="${kh.trangThai==1}">Passed</c:if>
            <td>
                <a href="/nhan-vien/detail?id=${kh.id}" class="btn btn-success">Detail</a>
                <a href="/nhan-vien/delete?id=${kh.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
