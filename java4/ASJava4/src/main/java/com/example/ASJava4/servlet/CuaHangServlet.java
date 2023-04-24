package com.example.ASJava4.servlet;

import com.example.ASJava4.entity.ChucVu;
import com.example.ASJava4.entity.CuaHang;
import com.example.ASJava4.entity.NhanVien;
import com.example.ASJava4.repository.ChucVuRepository;
import com.example.ASJava4.repository.CuaHangRepository;
import com.example.ASJava4.repository.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/add",
        "/cua-hang/update",
        "/cua-hang/detail",
        "/cua-hang/delete",
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/hien-thi")) {
            List<CuaHang> listCuaHang = cuaHangRepository.getAll();
            request.setAttribute("listCuaHang", listCuaHang);
            request.getRequestDispatcher("/view/cuahang/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getById(id);
            request.setAttribute("cuaHang", cuaHang);
            request.getRequestDispatcher("/view/cuahang/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getByIdCH(id);
            nhanVien.setIdCH(null);
            nhanVienRepository.update(nhanVien);
            CuaHang cuaHang = cuaHangRepository.getById(id);
            cuaHangRepository.delete(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang a = new CuaHang();
            a.setMa(ma);
            a.setTen(ten);
            a.setDiaChi(diaChi);
            a.setQuocGia(quocGia);
            a.setThanhPho(thanhPho);
            cuaHangRepository.add(a);
            response.sendRedirect("/cua-hang/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang a = cuaHangRepository.getById(id);
            a.setMa(ma);
            a.setTen(ten);
            a.setDiaChi(diaChi);
            a.setQuocGia(quocGia);
            a.setThanhPho(thanhPho);
            cuaHangRepository.update(a);
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }
}
