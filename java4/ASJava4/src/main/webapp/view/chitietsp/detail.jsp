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
    <title>Detaif</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body class="container">
<h1 style="text-align: center">Chi Tiết Sản Phẩm</h1>
<form class="container" action="/chi-tiet-sp/update?id=${chiTietSP.id}" method="post">
    <div class="row">
        <div class="col-3">
            <label class="form-label">Mã Sản Phẩm</label>
            <select name="idSP" class="form-select">
                <c:forEach items="${listSanPham}" var="a">
                    <option value="${a.id}" ${a.id==chiTietSP.idSP?"selected":""}>${a.ma}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-3">
            <label class="form-label">Mã Màu Sắc</label>
            <select name="idMauSac" class="form-select">
                <c:forEach items="${listMauSac}" var="a">
                    <option value="${a.id}" ${a.id==chiTietSP.idMauSac?"selected":""}>${a.ma}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-3">
            <label class="form-label">Mã Nhà Sản Xuất</label>
            <select name="idNsx" class="form-select">
                <c:forEach items="${listNSX}" var="a">
                    <option value="${a.id}" ${a.id==chiTietSP.idNsx?"selected":""}>${a.ma}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-3">
            <label class="form-label">Mã Dòng Sản Phẩm</label>
            <select name="idDongSP" class="form-select">
                <c:forEach items="${listDongSP}" var="a">
                    <option value="${a.id}" ${a.id==chiTietSP.idDongSP?"selected":""}>${a.ma}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <label class="form-label">Năm BH</label>
            <input type="text" class="form-control" name="namBH" value="${chiTietSP.namBH}">
        </div>
        <div class="col-8">
            <label class="form-label">Mô tả</label>
            <input type="text" class="form-control" name="moTa" value="${chiTietSP.moTa}">
        </div>
    </div>
    <div class="row">
        <div class="col-4">
            <label class="form-label">Số Lượng Tồn</label>
            <input type="text" class="form-control" name="soLuongTon" value="${chiTietSP.soLuongTon}">
        </div>
        <div class="col-4">
            <label class="form-label">Giá Nhập</label>
            <input type="text" class="form-control" name="giaNhap" value="${chiTietSP.giaNhap}">
        </div>
        <div class="col-4">
            <label class="form-label">Giá Bán</label>
            <input type="text" class="form-control" name="giaBan" value="${chiTietSP.giaBan}">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
