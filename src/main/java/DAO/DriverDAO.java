package DAO;

import Entity.Driver;
import Entity.Transport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;

import static Configuration.Session.getSessionFactory;

public class DriverDAO {


        public static void saveDriver(Driver driver) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(driver);
                transaction.commit();
            }
        }

        public static void saveOrUpdateDriver(Driver driver) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(driver);
                transaction.commit();
            }
        }

        public static void saveDriver(List<Driver> driver) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                driver.stream().forEach((g) -> session.save(g));
                transaction.commit();
            }
        }

        public static Driver getDriver(int id) {
            Driver driver;
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                driver = session.get(Driver.class, id);
                transaction.commit();
            }
            return driver;
        }

        public static void deleteDriver(Driver driver) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(driver);
                transaction.commit();
            }
        }
        // 7 b
        public static List<Driver> driversFilterForQualifications(boolean canDriveSpecialGoods,boolean canDriveMoreThan12People,boolean canDriveFlamableGoods) {
            try (Session session = Configuration.Session.getSessionFactory().openSession()) {
                CriteriaBuilder cb = session.getCriteriaBuilder();

                CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
                Root<Driver> root = cr.from(Driver.class);

                Predicate[] predicates = new Predicate[3];
                predicates[0] =cb.isNotNull(root.get("canDriveSpecialGoods"));
                predicates[1] =cb.isNotNull(root.get("canDriveMoreThan12People"));
                predicates[2] =cb.isNotNull(root.get("canDriveFlamableGoods"));

                cr.select(root).where(predicates);

                Query<Driver> query = session.createQuery(cr);
                List<Driver> driverList = query.getResultList();
                return driverList;
        }
    }
    public static List<Driver> driversSalaryFilterBetween(double lowerBound, double upperBound) {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);

            cr.select(root).where(cb.between(root.get("salary"), lowerBound, upperBound));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> driverList = query.getResultList();
            return driverList;
        }
    }
    public static List<Driver> driversSortedBySalaryAscending() {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);
            cr.orderBy(cb.asc(root.get("salary")));

            Query<Driver> query = session.createQuery(cr);
            List<Driver> driverList = query.getResultList();
            return driverList;
        }
    }
    public static List<Driver> driversSortedByQualificationsAscending() {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Driver> cr = cb.createQuery(Driver.class);
            Root<Driver> root = cr.from(Driver.class);

            cr.orderBy(
                    cb.asc(root.get("canDriveSpecialGoods")),
                    cb.asc(root.get("canDriveMoreThan12People")),
                    cb.asc(root.get("canDriveFlamableGoods"))
                    );

            Query<Driver> query = session.createQuery(cr);
            List<Driver> driverList = query.getResultList();
            return driverList;
        }

    }
    public static Double DriversEarnedFromTransports(int id) {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<Double> cr = cb.createQuery(Double.class);
            Root<Transport> transportRoot = cr.from(Transport.class);

            Join<Driver, Transport> transports = transportRoot.join("driver");
            cr.where(cb.equal(transportRoot.get("driver"),"driverId"));

            cr.select(cb.sum(transportRoot.get("price")));
            cr.where(cb.equal(transportRoot.get("driver"),id));

            Query<Double> query = session.createQuery(cr);
            Double sum = query.getSingleResult();
            return sum;
        }
    }

}



