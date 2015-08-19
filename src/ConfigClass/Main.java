package ConfigClass;

import ConfigClass.HinernateUtil.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by Savva on 19.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        System.exit(-1);
    }
}
