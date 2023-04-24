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
    <title>Chi Tiết Sản Phẩm</title>
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
<h1 class="container" style="text-align: center">Chi Tiết Sản Phẩm</h1>
<form class="container" action="/chi-tiet-sp/add" method="post">
    <div class="row">
        <div class="col-3">
            <label class="form-label">Mã Sản Phẩm</label>
            <select name="idSP" class="form-select">
                <c:forEach items="${listSanPham}" var="a">
                    <option value="${a.id}">${a.ma}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-3">
            <label class="form-label">Mã Màu Sắc</label>
            <select name="idMauSac" class="form-select">
                <c:forEach items="${listMauSac}" var="a">
                    <option value="${a.id}">${a.ma}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-3">
            <label class="form-label">Mã Nhà Sản Xuất</label>
            <select name="idNsx" class="form-select">
                <c:forEach items="${listNSX}" var="a">
                    <option value="${a.id}">${a.ma}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-3">
            <label class="form-label">Mã Dòng Sản Phẩm</label>
            <select name="idDongSP" class="form-select">
                <c:forEach items="${listDongSP}" var="a">
                    <option value="${a.id}">${a.ma}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <label class="form-label">Năm BH</label>
            <input type="text" class="form-control" name="namBH">
        </div>
        <div class="col-8">
            <label class="form-label">Mô tả</label>
            <input type="text" class="form-control" name="moTa">
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <label class="form-label">Số Lượng Tồn</label>
            <input type="text" class="form-control" name="soLuongTon">
        </div>
        <div class="col-4">
            <label class="form-label">Giá Nhập</label>
            <input type="text" class="form-control" name="giaNhap">
        </div>
        <div class="col-4">
            <label class="form-label">Giá Bán</label>
            <input type="text" class="form-control" name="giaBan">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table table-hover table-bordered">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Mã Sản Phẩm</th>
        <th scope="col">Mã Nhà Sản Xuất</th>
        <th scope="col">Mã Màu Sắc</th>
        <th scope="col">Mã Dòng Sản Phẩm</th>
        <th scope="col">Năm BH</th>
        <th scope="col">Mô Tả</th>
        <th scope="col">Số Lượng Tồn</th>
        <th scope="col">Giá Nhập</th>
        <th scope="col">Giá Bán</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listThiTietSP}" var="a">
        <tr>
            <td scope="row">${a.id}</td>
            <c:forEach items="${listSanPham}" var="sp">
                <c:if test="${sp.id==a.idSP}">
                    <td>${sp.ma}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${listNSX}" var="nsx">
                <c:if test="${nsx.id==a.idNsx}">
                    <td>${nsx.ma}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${listMauSac}" var="ms">
                <c:if test="${ms.id==a.idMauSac}">
                    <td>${ms.ma}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${listDongSP}" var="dsp">
                <c:if test="${dsp.id==a.idDongSP}">
                    <td>${dsp.ma}</td>
                </c:if>
            </c:forEach>
            <td>${a.namBH}</td>
            <td>${a.moTa}</td>
            <td>${a.soLuongTon}</td>
            <td>${a.giaNhap}</td>
            <td>${a.giaBan}</td>
            <td>
                <a href="/chi-tiet-sp/detail?id=${a.id}" class="btn btn-success">Detail</a>
                <a href="/chi-tiet-sp/delete?id=${a.id}" class="btn btn-danger">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
