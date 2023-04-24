package com.example.ASJava4.repository;

import com.example.ASJava4.entity.NSX;
import com.example.ASJava4.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NSXRepository {
    public List<NSX> getAll() {
        List<NSX> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NSX");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public NSX getById(UUID id2){
        NSX nsx=new NSX();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
           Query query=session.createQuery("from NSX where id=:id1");
           query.setParameter("id1",id2);
           nsx= (NSX) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }
    public Boolean add(NSX nsx){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.persist(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean update(NSX nsx){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.merge(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(NSX nsx){
        Transaction transaction=null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction=session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
