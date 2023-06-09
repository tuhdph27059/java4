<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 22/01/2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header class="container"><h3 style="text-align: center;margin-top:15px;">Sửa thông tin Sinh Viên</h3>
</header>
<main class="container">
    <section>
        <form action="/sinh-vien/update" method="post">
            <div class="row mt-4">
                <div class="col-6">
                    <label>Mã sinh viên</label>
                    <input type="text" class="form-control" value="${sinhVien.maSV}" name="mssv"/>
                </div>
                <div class="col-6">
                    <label>Tên sinh viên</label>
                    <input type="text" class="form-control" value="${sinhVien.tenSV}" name="tenSV"/>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-6">
                    <label>Tuổi </label>
                    <input type="text" class="form-control" value="${sinhVien.tuoi}" name="tuoi"/>
                </div>
                <div class="col-6">
                    <label>Giới tính </label>
                    <input type="radio" name="gioiTinh" value="true" ${sinhVien.gioiTinh == true ?"checked":""}>Nam
                    <input type="radio" name="gioiTinh" value="false" ${sinhVien.gioiTinh == false ?"checked":""}>Nữ
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-12">
                    <label>Địa chỉ </label>
                    <input type="text" class="form-control" value="${sinhVien.diaChi}" name="diaChi"/>
                </div>
            </div>
            <div class="row mt-4" style="justify-content: center">
                <button class="btn btn-primary col-1 m-3" type="submit">
                    Update
                </button>
            </div>
        </form>
    </section>

</main>
<footer><p style="text-align: center;">HangNT169</p></footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
