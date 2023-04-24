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

public class ChucVuRepository {
    public List<ChucVu> getAll() {
        List<ChucVu> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChucVu");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ChucVu getById(UUID id2) {
        ChucVu chucVu = new ChucVu();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChucVu where id=:id1");
            query.setParameter("id1", id2);
            chucVu = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVu;
    }

    public Boolean add(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
