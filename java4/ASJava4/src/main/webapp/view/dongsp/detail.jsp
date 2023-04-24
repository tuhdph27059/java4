<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2023
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body class="container">
<h1 style="text-align: center">Dòng Sản Phẩm</h1>
<form action="/dong-sp/update?id=${dongSP.id}" method="post">
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" name="ma" value="${dongSP.ma}">
        </div>
        <div class="col-4"></div>
    </div>
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten" value="${dongSP.ten}">
        </div>
        <div class="col-4"></div>
    </div>
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
        <div class="col-4"></div>
    </div>
</form>
</body>
</html>
