package com.example.ASJava4.repository;

import com.example.ASJava4.entity.ChiTietSP;
import com.example.ASJava4.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    public List<ChiTietSP> getAll() {
        List<ChiTietSP> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSP");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ChiTietSP getByIdSP(UUID id2) {
        ChiTietSP chiTietSP = new ChiTietSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSP where idSP=:id1");
            query.setParameter("id1", id2);
            chiTietSP = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }

    public ChiTietSP getByIdNsx(UUID id2) {
        ChiTietSP chiTietSP = new ChiTietSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSP where idNsx=:id1");
            query.setParameter("id1", id2);
            chiTietSP = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }

    public ChiTietSP getByIdMauSac(UUID id2) {
        ChiTietSP chiTietSP = new ChiTietSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSP where idMauSac=:id1");
            query.setParameter("id1", id2);
            chiTietSP = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }

    public ChiTietSP getByIdDongSP(UUID id2) {
        ChiTietSP chiTietSP = new ChiTietSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSP where idDongSP=:id1");
            query.setParameter("id1", id2);
            chiTietSP = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }


    public ChiTietSP getById(UUID id2) {
        ChiTietSP chiTietSP = new ChiTietSP();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSP where id=:id1");
            query.setParameter("id1", id2);
            chiTietSP = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }

    public Boolean add(ChiTietSP sp) {
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

    public Boolean update(ChiTietSP sp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            if (sp.getId().equals(null)) {
                return false;
            } else {
                transaction = session.beginTransaction();
                session.merge(sp);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(ChiTietSP sp) {
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
