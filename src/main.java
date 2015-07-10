import Entity.People;
import Entity.Phone;
import HibernateUtil.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by savva on 07.07.2015.
 */
public class main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();

//        Phone phone = (Phone) session.createCriteria(Phone.class).add(Restrictions.eq("id", 1)).uniqueResult();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Hibernate.initialize(phone.getPeople());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        People people = new People();
//        people.setFirstName("Иванов");
//        people.setLastName("Иван");
//        people.setMiddleName("Иванович");
//        people.setYear(21);
//
//        SQLStore.create(people);

//        SQLStore.delete(4);

        System.exit(-1);
    }
}
