package Configuration;
import Entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Session {

        private static SessionFactory sessionFactory;

        public static SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Goods.class);
                configuration.addAnnotatedClass(Driver.class);
                configuration.addAnnotatedClass(Transport.class);
                configuration.addAnnotatedClass(Vehicle.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(TransportCompany.class);
                ServiceRegistry serviceRegistry
                        = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }

            return sessionFactory;
        }
}
