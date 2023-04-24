package com.example.ASJava4.servlet;

import com.example.ASJava4.entity.ChiTietSP;
import com.example.ASJava4.entity.MauSac;
import com.example.ASJava4.repository.ChiTietSPRepository;
import com.example.ASJava4.repository.MauSacRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "mauSacServlet", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/add",
        "/mau-sac/update",
        "/mau-sac/detail",
        "/mau-sac/delete",
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<MauSac> listMauSac = mauSacRepository.getAll();
            request.setAttribute("listMauSac", listMauSac);
            request.getRequestDispatcher("/view/mausac/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getById(id);
            request.setAttribute("mauSac", mauSac);
            request.getRequestDispatcher("/view/mausac/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP chiTietSP = chiTietSPRepository.getByIdMauSac(id);
                chiTietSP.setIdMauSac(null);
                chiTietSPRepository.update(chiTietSP);
                MauSac mauSac = mauSacRepository.getById(id);
                mauSacRepository.delete(mauSac);
                response.sendRedirect("/mau-sac/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac mauSac = new MauSac();
            mauSac.setMa(ma);
            mauSac.setTen(ten);
            mauSacRepository.add(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac mauSac = mauSacRepository.getById(id);
            mauSac.setMa(ma);
            mauSac.setTen(ten);
            mauSacRepository.update(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }
}
