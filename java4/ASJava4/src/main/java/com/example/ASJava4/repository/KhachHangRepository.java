package com.example.ASJava4.repository;

import com.example.ASJava4.entity.KhachHang;
import com.example.ASJava4.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {
    //    Hàm thực hiện truy vấn
    public List<KhachHang> getAll() {
        List<KhachHang> listKhachHang = new ArrayList<>();
//        Mở Session
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Truy vấn trên hql
            Query query = session.createQuery("from KhachHang");
            listKhachHang = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    //    Detail
    public KhachHang getById(UUID id2) {
        KhachHang khachHang = new KhachHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from KhachHang where id=:id1");
            query.setParameter("id1", id2);
            khachHang = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    //    add
    public Boolean add(KhachHang khachHang) {
//       Transaction Khi add lỗi sẽ không INSERT vào database
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
//            update
            session.persist(khachHang);
//            commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //    update
    public Boolean update(KhachHang khachHang) {
//       Transaction Khi add lỗi sẽ không INSERT vào database
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
//            update
            session.merge(khachHang);
//            commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //    delete
    public Boolean delete(KhachHang khachHang) {
//       Transaction Khi add lỗi sẽ không INSERT vào database
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
//            delete
            session.delete(khachHang);
//            commit
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
