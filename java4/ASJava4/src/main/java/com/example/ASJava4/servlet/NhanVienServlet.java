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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/update",
        "/nhan-vien/detail",
        "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (uri.contains("/hien-thi")) {
            List<NhanVien> listNhanVien = nhanVienRepository.getAll();
            List<CuaHang> listCuaHang = cuaHangRepository.getAll();
            List<ChucVu> listChucVu = chucVuRepository.getAll();

            request.setAttribute("listCuaHang", listCuaHang);
            request.setAttribute("listChucVu", listChucVu);
            request.setAttribute("listNhanVien", listNhanVien);
            request.getRequestDispatcher("/view/nhanvien/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getById(id);
            request.setAttribute("nhanVien", nhanVien);
            String ngaySinh = dateFormat.format(nhanVien.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            List<CuaHang> listCuaHang1 = cuaHangRepository.getAll();
            List<ChucVu> listChucVu1 = chucVuRepository.getAll();
            request.setAttribute("listCuaHang", listCuaHang1);
            request.setAttribute("listChucVu", listChucVu1);
            request.getRequestDispatcher("/view/nhanvien/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getById(id);
            nhanVienRepository.delete(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Đây là ngày sinh: " + ngaySinh);
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            UUID idCH = UUID.fromString(request.getParameter("idCH"));
            UUID idCV = UUID.fromString(request.getParameter("idCV"));
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
            NhanVien nv = new NhanVien();
            nv.setMa(ma);
            nv.setTen(ten);
            nv.setTenDem(tenDem);
            nv.setHo(ho);
            nv.setGioiTinh(gioiTinh);
            nv.setNgaySinh(ngaySinh);
            nv.setDiaChi(diaChi);
            nv.setSdt(sdt);
            nv.setMatKhau(matKhau);
            nv.setIdCH(idCH);
            nv.setIdCV(idCV);
            nv.setTrangThai(trangThai);
            nhanVienRepository.add(nv);
            response.sendRedirect("/nhan-vien/hien-thi");
        } else if (uri.contains("/update")) {

            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Đây là ngày sinh: " + ngaySinh);
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            UUID idCH = UUID.fromString(request.getParameter("idCH"));
            UUID idCV = UUID.fromString(request.getParameter("idCV"));
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
            NhanVien nv = nhanVienRepository.getById(id);
            nv.setMa(ma);
            nv.setTen(ten);
            nv.setTenDem(tenDem);
            nv.setHo(ho);
            nv.setGioiTinh(gioiTinh);
            nv.setNgaySinh(ngaySinh);
            nv.setDiaChi(diaChi);
            nv.setSdt(sdt);
            nv.setMatKhau(matKhau);
            nv.setIdCH(idCH);
            nv.setIdCV(idCV);
            nv.setTrangThai(trangThai);
            nhanVienRepository.update(nv);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}
