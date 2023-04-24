package com.example.ASJava4.repository;

import com.example.ASJava4.entity.ChucVu;
import com.example.ASJava4.entity.NhanVien;
import com.example.ASJava4.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NhanVien getById(UUID id2) {
        NhanVien nhanVien = new NhanVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien where id=:id1");
            query.setParameter("id1", id2);
            nhanVien = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public NhanVien getByIdCV(UUID id2) {
        NhanVien nhanVien = new NhanVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien where idCV=:id1");
            query.setParameter("id1", id2);
            nhanVien = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public NhanVien getByIdCH(UUID id2) {
        NhanVien nhanVien = new NhanVien();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien where idCH=:id1");
            query.setParameter("id1", id2);
            nhanVien = (NhanVien) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public Boolean add(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            if (nhanVien.getId().equals(null)) {
                return false;
            } else {
                transaction = session.beginTransaction();
                session.merge(nhanVien);
                transaction.commit();
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(NhanVien nhanVien) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
