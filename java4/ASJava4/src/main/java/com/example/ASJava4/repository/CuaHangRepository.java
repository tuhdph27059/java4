package com.example.ASJava4.repository;

import com.example.ASJava4.entity.ChucVu;
import com.example.ASJava4.entity.CuaHang;
import com.example.ASJava4.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    public List<CuaHang> getAll() {
        List<CuaHang> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CuaHang");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public CuaHang getById(UUID id2) {
        CuaHang cuaHang = new CuaHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from CuaHang where id=:id1");
            query.setParameter("id1", id2);
            cuaHang = (CuaHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuaHang;
    }

    public Boolean add(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(CuaHang cuaHang) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
