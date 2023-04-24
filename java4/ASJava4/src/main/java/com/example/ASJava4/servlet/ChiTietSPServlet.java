package com.example.ASJava4.servlet;

import com.example.ASJava4.entity.*;
import com.example.ASJava4.repository.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSPServlet", value = {
        "/chi-tiet-sp/hien-thi",
        "/chi-tiet-sp/add",
        "/chi-tiet-sp/update",
        "/chi-tiet-sp/detail",
        "/chi-tiet-sp/delete",
})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private NSXRepository nsxRepository = new NSXRepository();
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/hien-thi")) {
            List<ChiTietSP> listThiTietSP = chiTietSPRepository.getAll();
            List<SanPham> listSanPham = sanPhamRepository.getAll();
            List<MauSac> listMauSac = mauSacRepository.getAll();
            List<NSX> listNSX = nsxRepository.getAll();
            List<DongSP> listDongSP = dongSPRepository.getAll();
            request.setAttribute("listThiTietSP", listThiTietSP);
            request.setAttribute("listSanPham", listSanPham);
            request.setAttribute("listMauSac", listMauSac);
            request.setAttribute("listNSX", listNSX);
            request.setAttribute("listDongSP", listDongSP);
            request.getRequestDispatcher("/view/chitietsp/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP chiTietSP = chiTietSPRepository.getById(id);
            request.setAttribute("chiTietSP", chiTietSP);

            List<SanPham> listSanPham = sanPhamRepository.getAll();
            List<MauSac> listMauSac = mauSacRepository.getAll();
            List<NSX> listNSX = nsxRepository.getAll();
            List<DongSP> listDongSP = dongSPRepository.getAll();

            request.setAttribute("listSanPham", listSanPham);
            request.setAttribute("listMauSac", listMauSac);
            request.setAttribute("listNSX", listNSX);
            request.setAttribute("listDongSP", listDongSP);
            request.getRequestDispatcher("/view/chitietsp/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP chiTietSP = chiTietSPRepository.getById(id);
            chiTietSPRepository.delete(chiTietSP);
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            UUID idSP = UUID.fromString(request.getParameter("idSP"));
            UUID idMauSac = UUID.fromString(request.getParameter("idMauSac"));
            UUID idNsx = UUID.fromString(request.getParameter("idNsx"));
            UUID idDongSP = UUID.fromString(request.getParameter("idDongSP"));
            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            Integer giaNhap = Integer.parseInt(request.getParameter("giaNhap"));
            Integer giaBan = Integer.parseInt(request.getParameter("giaBan"));
            ChiTietSP a = new ChiTietSP();
            a.setIdSP(idSP);
            a.setIdNsx(idNsx);
            a.setIdMauSac(idMauSac);
            a.setIdDongSP(idDongSP);
            a.setNamBH(namBH);
            a.setMoTa(moTa);
            a.setGiaBan(giaBan);
            a.setGiaNhap(giaNhap);
            a.setSoLuongTon(soLuongTon);
            chiTietSPRepository.add(a);
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            UUID idSP = UUID.fromString(request.getParameter("idSP"));
            UUID idMauSac = UUID.fromString(request.getParameter("idMauSac"));
            UUID idNsx = UUID.fromString(request.getParameter("idNsx"));
            UUID idDongSP = UUID.fromString(request.getParameter("idDongSP"));
            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            Integer giaNhap = Integer.parseInt(request.getParameter("giaNhap"));
            Integer giaBan = Integer.parseInt(request.getParameter("giaBan"));
            ChiTietSP a = chiTietSPRepository.getById(id);
            a.setIdSP(idSP);
            a.setIdNsx(idNsx);
            a.setIdMauSac(idMauSac);
            a.setIdDongSP(idDongSP);
            a.setNamBH(namBH);
            a.setMoTa(moTa);
            a.setGiaBan(giaBan);
            a.setGiaNhap(giaNhap);
            a.setSoLuongTon(soLuongTon);
            chiTietSPRepository.update(a);
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        }
    }
}
