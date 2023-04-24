package com.example.ASJava4.servlet;

import com.example.ASJava4.entity.KhachHang;
import com.example.ASJava4.repository.KhachHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/update",
        "/khach-hang/detail",
        "/khach-hang/remove"
})
public class KhachHangServlet extends HttpServlet {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    List<KhachHang> listKhachHang = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<KhachHang> listKhachHang = khachHangRepository.getAll();
            request.setAttribute("listKhachHang", listKhachHang);
            request.getRequestDispatcher("/view/khachhang/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.getById(id);
            request.setAttribute("khachHang", khachHang);
            String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/view/khachhang/detail.jsp").forward(request, response);
        } else if (uri.contains("/remove")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang kh = khachHangRepository.getById(id);
            khachHangRepository.delete(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang khachHang = new KhachHang();
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            khachHangRepository.add(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            KhachHang kh = khachHangRepository.getById(id);
            kh.setTen(ten);
            kh.setMa(ma);
            kh.setTenDem(tenDem);
            kh.setHo(ho);
            kh.setNgaySinh(ngaySinh);
            kh.setSdt(sdt);
            kh.setDiaChi(diaChi);
            kh.setQuocGia(quocGia);
            kh.setThanhPho(thanhPho);
            kh.setMatKhau(matKhau);
            khachHangRepository.update(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }
}
