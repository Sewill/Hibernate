import ManyToOne.HibernateUtil.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


/**
 * Created by savva on 08.07.2015.
 */
public class SQLStore {
    public static void create(Object o)
    {
        try {
            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Object o){
        try {
            Session session = HibernateUtil.getSession();

            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        try {
            Session session = HibernateUtil.getSession();

            String stringQuery = "delete from People where id = :id";
            Query query = session.createQuery(stringQuery);
            query.setParameter("id", id);
            query.executeUpdate();

            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> getList(){
        Session session = HibernateUtil.getSession();

//        People people = null;
//        List<People> peoples = session.createCriteria(People.class)
//                .add(Restrictions.eq("id", id)).list();
//        if(peoples!=null&&peoples.size()==1)
//        {
//            people = peoples.get(0);
//        }

return null;
    }
}
