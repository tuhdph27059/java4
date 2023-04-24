<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/28/2023
  Time: 11:47 PM
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
<h1 class="container" style="text-align: center">Chức Vụ</h1>
<form class="container" action="/chuc-vu/update?id=${chucVu.id}" method="post">
    <div class="mb-3">
        <label class="form-label">Mã</label>
        <input type="text" class="form-control" name="ma" value="${chucVu.ma}">
    </div>
    <div class="mb-3">
        <label class="form-label">Tên</label>
        <input type="text" class="form-control" name="ten" value="${chucVu.ten}">
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
</body>
</html>
