package db;

import models.Guitar;
import models.Guitarist;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getAll(String className){
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from " + className;
            results = session.createQuery(hql).list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Guitar> getGuitars(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Guitar> guitars = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Guitar WHERE guitarist_id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            guitars = query.list();
            transaction.commit();

        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return guitars;
    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void update(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Guitarist> getGuitarists(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Guitarist> guitarists = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from Guitarist WHERE guitar_id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            guitarists = query.list();
            transaction.commit();

        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return guitarists;
    }

//    public static void deleteById(String className, int id){
//        session = HibernateUtil.getSessionFactory().openSession();
//        try{
//            transaction = session.beginTransaction();
//            String hql = "delete from " + className + " where id = "+ id;
//            Query query = session.createQuery(hql);
//            query.setInteger("id", id);
//            query.executeUpdate();
//            transaction.commit();
//        } catch (HibernateException ex) {
//            transaction.rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }

    public static Object getObjectById(String className, int id){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Object> results = null;
        try {
            transaction = session.beginTransaction();
            String hql = "from " + className + " WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            results = query.list ();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results.get(0);
    }

}
