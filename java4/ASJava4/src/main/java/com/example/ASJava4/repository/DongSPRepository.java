package com.example.ASJava4.repository;

import com.example.ASJava4.entity.DongSP;
import com.example.ASJava4.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {
    public List<DongSP> getAll() {
        List<DongSP> listDongSP = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from DongSP");
            listDongSP = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDongSP;
    }

    public DongSP getById(UUID id2) {
        DongSP dongSP = new DongSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from DongSP where id=:id1");
            query.setParameter("id1", id2);
            dongSP = (DongSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSP;
    }

    public Boolean add(DongSP dongSP) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(dongSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(DongSP dongSP) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(dongSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(DongSP dongSP) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dongSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
