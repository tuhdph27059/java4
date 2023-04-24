package com.example.ASJava4.servlet;

import com.example.ASJava4.entity.ChiTietSP;
import com.example.ASJava4.entity.DongSP;
import com.example.ASJava4.repository.ChiTietSPRepository;
import com.example.ASJava4.repository.DongSPRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {
        "/dong-sp/hien-thi",
        "/dong-sp/add",
        "/dong-sp/update",
        "/dong-sp/detail",
        "/dong-sp/delete"
})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepository = new DongSPRepository();
    private ChiTietSPRepository chiTietSPRepository=new ChiTietSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<DongSP> listDongSP = dongSPRepository.getAll();
            request.setAttribute("listDongSP", listDongSP);
            request.getRequestDispatcher("/view/dongsp/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = dongSPRepository.getById(id);
            request.setAttribute("dongSP", dongSP);
            request.getRequestDispatcher("/view/dongsp/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP chiTietSP = chiTietSPRepository.getByIdDongSP(id);
            chiTietSP.setIdDongSP(null);
            chiTietSPRepository.update(chiTietSP);
            DongSP dongSP = dongSPRepository.getById(id);
            dongSPRepository.delete(dongSP);
            response.sendRedirect("/dong-sp/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP();
            dongSP.setMa(ma);
            dongSP.setTen(ten);
            dongSPRepository.add(dongSP);
            response.sendRedirect("/dong-sp/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = dongSPRepository.getById(id);
            dongSP.setMa(ma);
            dongSP.setTen(ten);
            dongSPRepository.update(dongSP);
            response.sendRedirect("/dong-sp/hien-thi");
        }
    }
}
