package peaksoft.dao;

import org.hibernate.Session;
import peaksoft.entity.Workers;
import peaksoft.util.HibernateUtil;

import java.util.List;

public class DaoWorkersImpl implements DaoWorkers {
    @Override
    public void createTable() {
        try {
            Session session = HibernateUtil.setUp().openSession();
            session.beginTransaction();
            session.getTransaction().commit();
            System.out.println("Create table Successfully");
            session.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void saveWorkers(String name, String surname, byte age) {
        Workers workers = new Workers(name,surname,age);
        Session session = HibernateUtil.setUp().openSession();
        session.beginTransaction();
        session.save(workers);
        session.getTransaction().commit();
        System.out.println("Added user successfully");
        session.close();

    }

    @Override
    public List<Workers> getAllWorkers() {

        List<Workers> list1 = null;
        try {
            Session session = HibernateUtil.setUp().openSession();
            session.beginTransaction();
            List<Workers> list = session.createQuery("from Workers ").getResultList();
            session.getTransaction().commit();
            list1 = list.stream().filter((x) -> x.getAge() > 20).filter((n)->n.getName().equals("Aza")).toList();
            System.out.println("All Аза big from 20 year ");
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list1;
    }

    @Override
    public void updateAllWorkers() {

        try {
            Session session = HibernateUtil.setUp().openSession();
            session.beginTransaction();
            session.createSQLQuery( "update workers set age = 18 where name = 'Aza'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("update all Aza age successfully");

            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Workers> deleteAllWorkers() {
        List<Workers> list1 = null;
        try {
            Workers workers = new Workers();
            Session session = HibernateUtil.setUp().openSession();
            session.beginTransaction();
            List<Workers> list = session.createQuery("from Workers ").getResultList();
            list1 = list.stream().filter((x) -> x.getAge() > 20).toList();
            if (workers.getAge() > 20) {
                list1.remove(1);
            }
            session.getTransaction().commit();

            System.out.println("delete all workers big from 20 year");
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list1;
    }

    @Override
    public List<Workers> getRemainderWorkers() {
          Session session = HibernateUtil.setUp().openSession();
          session.beginTransaction();
          List<Workers> list = session.createQuery("from Workers ").getResultList();
        List<Workers> list1 = list.stream().toList();
        session.getTransaction().commit();
        session.close();
        return list1;
    }
}
