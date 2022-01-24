package DAO;

import Entity.Transport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static Configuration.Session.getSessionFactory;

public class TransportDAO {

        public static void saveTransport(Transport transport) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(transport);
                transaction.commit();
            }
        }

        public static void saveOrUpdateTransport(Transport transport) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(transport);
                transaction.commit();
            }
        }

        public static void saveTransport(List<Transport> transports) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                transports.stream().forEach((g) -> session.save(g));
                transaction.commit();
            }
        }

        public static Transport getTransport(int id) {
            Transport transport;
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                transport = session.get(Transport.class, id);
                transaction.commit();
            }
            return transport;
        }

        public static void deleteTransport(Transport transport) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(transport);
                transaction.commit();
            }
        }
    public static List<Transport> TransportsSortedByEndDestinationAscending() {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Transport> cr = cb.createQuery(Transport.class);
            Root<Transport> root = cr.from(Transport.class);
            cr.orderBy(cb.asc(root.get("endingDestination")));

            Query<Transport> query = session.createQuery(cr);
            List<Transport> transports = query.getResultList();
            return transports;
        }
    }
    public static List<Transport> TransportsSortedByStartDestinationAscending() {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Transport> cr = cb.createQuery(Transport.class);
            Root<Transport> root = cr.from(Transport.class);
            cr.orderBy(cb.asc(root.get("startingDestination")));

            Query<Transport> query = session.createQuery(cr);
            List<Transport> transports = query.getResultList();
            return transports;
        }
    }
    public static List<Transport> TransportsFrom(String startingDestination) {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Transport> cr = cb.createQuery(Transport.class);
            Root<Transport> root = cr.from(Transport.class);

            cr.select(root).where(cb.equal(root.get("startingDestination"), startingDestination));

            Query<Transport> query = session.createQuery(cr);
            List<Transport> transports = query.getResultList();
            return transports;
        }
    }
    public static List<Transport> TransportsTo(String endingDestination) {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Transport> cr = cb.createQuery(Transport.class);
            Root<Transport> root = cr.from(Transport.class);

            cr.select(root).where(cb.equal(root.get("endingDestination"), endingDestination));

            Query<Transport> query = session.createQuery(cr);
            List<Transport> transports = query.getResultList();
            return transports;
        }
    }
        public static Long CheckUpForTransports() {
            try (Session session = Configuration.Session.getSessionFactory().openSession()) {
                CriteriaBuilder cb = session.getCriteriaBuilder();
                CriteriaQuery<Long> cr = cb.createQuery(Long.class);

                cr.select(cb.count(cr.from(Transport.class)));
                return session.createQuery(cr).getSingleResult();
            }

        }
    public static Double CheckSumPrices() {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Double> cr = cb.createQuery(Double.class);
            Root<Transport> root = cr.from(Transport.class);
            cr.select(cb.sum(root.get("price")));

            Query<Double> query = session.createQuery(cr);
            Double sum = query.getSingleResult();
            return sum;
        }
    }
    }



