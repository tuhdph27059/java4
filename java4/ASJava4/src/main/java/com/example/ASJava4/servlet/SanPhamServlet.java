package com.example.ASJava4.servlet;

import com.example.ASJava4.entity.ChiTietSP;
import com.example.ASJava4.entity.SanPham;
import com.example.ASJava4.repository.ChiTietSPRepository;
import com.example.ASJava4.repository.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/update",
        "/san-pham/detail",
        "/san-pham/delete"
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<SanPham> listSanPham = sanPhamRepository.getAll();
            request.setAttribute("listSanPham", listSanPham);
            request.getRequestDispatcher("/view/sanpham/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sp = sanPhamRepository.getById(id);
            request.setAttribute("sanPham", sp);
            request.getRequestDispatcher("/view/sanpham/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP chiTietSP = chiTietSPRepository.getByIdSP(id);
            chiTietSP.setIdSP(null);
            chiTietSPRepository.update(chiTietSP);
            SanPham sp = sanPhamRepository.getById(id);
            sanPhamRepository.delete(sp);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sp = new SanPham();
            sp.setMa(ma);
            sp.setTen(ten);
            sanPhamRepository.add(sp);
            response.sendRedirect("/san-pham/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sp = sanPhamRepository.getById(id);
            sp.setMa(ma);
            sp.setTen(ten);
            sanPhamRepository.update(sp);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }
}
