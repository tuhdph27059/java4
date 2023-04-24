package com.example.ASJava4.servlet;

import com.example.ASJava4.entity.ChiTietSP;
import com.example.ASJava4.entity.MauSac;
import com.example.ASJava4.entity.NSX;
import com.example.ASJava4.repository.ChiTietSPRepository;
import com.example.ASJava4.repository.MauSacRepository;
import com.example.ASJava4.repository.NSXRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {
        "/nsx/hien-thi",
        "/nsx/add",
        "/nsx/update",
        "/nsx/detail",
        "/nsx/delete",
})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepository = new NSXRepository();
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/hien-thi")) {
            List<NSX> listNSX = nsxRepository.getAll();
            request.setAttribute("listNSX", listNSX);
            request.getRequestDispatcher("/view/nsx/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getById(id);
            request.setAttribute("nsx", nsx);
            request.getRequestDispatcher("/view/nsx/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP chiTietSP = chiTietSPRepository.getByIdNsx(id);
            chiTietSP.setIdNsx(null);
            chiTietSPRepository.update(chiTietSP);
            NSX nsx = nsxRepository.getById(id);
            nsxRepository.delete(nsx);
            response.sendRedirect("/nsx/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX a = new NSX();
            a.setMa(ma);
            a.setTen(ten);
            nsxRepository.add(a);
            response.sendRedirect("/nsx/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX a = nsxRepository.getById(id);
            a.setMa(ma);
            a.setTen(ten);
            nsxRepository.update(a);
            response.sendRedirect("/nsx/hien-thi");
        }
    }
}
