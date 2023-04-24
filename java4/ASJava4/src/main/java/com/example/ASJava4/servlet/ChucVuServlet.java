package com.example.ASJava4.servlet;

import com.example.ASJava4.entity.ChucVu;
import com.example.ASJava4.entity.MauSac;
import com.example.ASJava4.entity.NhanVien;
import com.example.ASJava4.repository.ChucVuRepository;
import com.example.ASJava4.repository.MauSacRepository;
import com.example.ASJava4.repository.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/add",
        "/chuc-vu/update",
        "/chuc-vu/detail",
        "/chuc-vu/delete",
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();
    private NhanVienRepository nhanVienRepository=new NhanVienRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/hien-thi")) {
            List<ChucVu> listChucVu = chucVuRepository.getAll();
            request.setAttribute("listChucVu", listChucVu);
            request.getRequestDispatcher("/view/chucvu/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu = chucVuRepository.getById(id);
            request.setAttribute("chucVu", chucVu);
            request.getRequestDispatcher("/view/chucvu/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien=nhanVienRepository.getByIdCV(id);
            nhanVien.setIdCV(null);
            nhanVienRepository.update(nhanVien);
            ChucVu chucVu = chucVuRepository.getById(id);
            chucVuRepository.delete(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu a = new ChucVu();
            a.setMa(ma);
            a.setTen(ten);
            chucVuRepository.add(a);
            response.sendRedirect("/chuc-vu/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu a = chucVuRepository.getById(id);
            a.setMa(ma);
            a.setTen(ten);
            chucVuRepository.update(a);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}
