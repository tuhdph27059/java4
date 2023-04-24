package com.example.ASJava4.repository;

import com.example.ASJava4.entity.SanPham;
import com.example.ASJava4.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    public List<SanPham> getAll() {
        List<SanPham> listSanPham = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPham ");
            listSanPham = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }

    public SanPham getById(UUID id2) {
        SanPham sp = new SanPham();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPham where id=:id1");
            query.setParameter("id1", id2);
            sp = (SanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

    public Boolean add(SanPham sp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(SanPham sp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(SanPham sp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
