<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/28/2023
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
<h1 class="container" style="text-align: center">Nhân Viên</h1>
<form class="container" action="/nhan-vien/update?id=${nhanVien.id}" method="post">
    <div class="row">
        <div class="col-6">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" name="ma" value="${nhanVien.ma}">
        </div>
        <div class="col-6">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten" value="${nhanVien.ten}">
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label class="form-label">Tên Đệm</label>
            <input type="text" class="form-control" name="tenDem" value="${nhanVien.tenDem}">
        </div>
        <div class="col-6">
            <label class="form-label">Họ</label>
            <input type="text" class="form-control" name="ho" value="${nhanVien.ho}">
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <label class="form-label">Giới Tính</label><br>
            <input type="radio" name="gioiTinh" value="Nam" ${nhanVien.gioiTinh == 'Nam' ?"checked":""}>Nam
            <input type="radio" name="gioiTinh" value="Nữ" ${nhanVien.gioiTinh == 'Nữ' ?"checked":""}>Nữ
        </div>
        <div class="col-3">
            <label class="form-label">Ngày Sinh</label>
            <input type="date" class="form-control" name="ngaySinh" value="${ngaySinh}">
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label class="form-label">Địa Chỉ</label>
            <input type="text" class="form-control" name="diaChi" value="${nhanVien.diaChi}">
        </div>
        <div class="col-6">
            <label class="form-label">SĐT</label>
            <input type="text" class="form-control" name="sdt" value="${nhanVien.sdt}">
        </div>
    </div>
    <div class="row">
        <div class="col-2">
            <label class="form-label">Cửa Hàng</label>
            <select class="form-select" name="idCH">
                <c:forEach items="${listCuaHang}" var="a">
                    <option value="${a.id}" ${a.id==nhanVien.idCH?"selected":""}>
                            ${a.ma}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-2">
            <label class="form-label">Chức Vụ</label>
            <select class="form-select" name="idCV">
                <c:forEach items="${listChucVu}" var="a">
                    <option value="${a.id}" ${a.id==nhanVien.idCV?"selected":""}>
                            ${a.ma}
                    </option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <label class="form-label">Mật Khẩu</label>
            <input type="text" class="form-control" name="matKhau" value="${nhanVien.matKhau}">
        </div>
        <div class="col-6">
            <label class="form-label">Trạng Thái</label>
            <input type="text" class="form-control" name="trangThai" value="${nhanVien.trangThai}">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
