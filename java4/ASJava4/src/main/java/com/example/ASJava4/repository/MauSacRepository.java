package com.example.ASJava4.repository;

import com.example.ASJava4.entity.KhachHang;
import com.example.ASJava4.entity.MauSac;
import com.example.ASJava4.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    public List<MauSac> getAll() {
        List<MauSac> listMauSac = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from MauSac");
            listMauSac = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMauSac;
    }

    public MauSac getById(UUID id2) {
        MauSac mauSac = new MauSac();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from MauSac where id=:id1");
            query.setParameter("id1", id2);
            mauSac = (MauSac) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }

    public Boolean add(MauSac ms) {
//       Transaction Khi add lỗi sẽ không INSERT vào database
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
//            add
            session.persist(ms);
//            commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(MauSac ms) {
//       Transaction Khi add lỗi sẽ không INSERT vào database
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
//            update
            session.merge(ms);
//            commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(MauSac ms) {
//       Transaction Khi add lỗi sẽ không INSERT vào database
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
//            update
            session.delete(ms);
//            commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
