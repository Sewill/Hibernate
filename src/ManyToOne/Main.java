package ManyToOne;

import ManyToOne.Entity.People;
import ManyToOne.Entity.Phone;
import ManyToOne.HibernateUtil.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Savva on 19.08.2015.
 */
public class Main {
    public static void main(String[] args) {
//        fullDB();

//        delete if orphanRemoval true
        Session session = HibernateUtil.getSession();
        List<People> peoples = session.createCriteria(People.class).list();

        if(peoples!=null&&peoples.size()>0){
            People people = peoples.get(0);

            session.beginTransaction();

            session.delete(people);

            session.getTransaction().commit();
        }


        System.exit(-1);
    }

    public static void fullDB() {
        Session session = HibernateUtil.getSession();
        try {

            session.getTransaction().begin();
            for (int i = 0; i < 10; i++) {
                People people = new People(
                        String.valueOf(i),
                        String.valueOf(i),
                        String.valueOf(i),
                        i);
                session.save(people);
                for (int j = 0; j < 3; j++) {
                    Phone phone = new Phone(String.valueOf(i) + "_" + String.valueOf(j), people);
                    session.save(phone);
                }


            }
            session.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
