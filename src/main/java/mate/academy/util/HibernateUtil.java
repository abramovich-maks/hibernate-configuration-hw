package mate.academy.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory INSTANCE = initSessionFactory();

    private HibernateUtil() {
    }

    private static SessionFactory initSessionFactory() {
        return new Configuration().configure()
                .setProperty("hibernate.connection.url", System.getenv("DB_URL"))
                .setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"))
                .setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"))
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return INSTANCE;
    }
}
