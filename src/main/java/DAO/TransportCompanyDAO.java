package DAO;

import Entity.Client;
import Entity.Driver;
import Entity.Transport;
import Entity.TransportCompany;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class TransportCompanyDAO {


        public static void saveTransportCompany(TransportCompany transportCompany) {
            try (Session session = Configuration.Session.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(transportCompany);
                transaction.commit();
            }
        }

        public static void saveOrUpdateTransportCompany(TransportCompany transportCompany) {
            try (Session session = Configuration.Session.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(transportCompany);
                transaction.commit();
            }
        }

        public static void saveTransportCompanies(List<TransportCompany> transportCompanyList) {
            try (Session session = Configuration.Session.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                transportCompanyList.stream().forEach((transportCompany) -> session.save(transportCompany));
                transaction.commit();
            }
        }
        public static TransportCompany getTransportCompany(long id) {
            TransportCompany transportCompany;
            try (Session session = Configuration.Session.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                transportCompany = session.get(TransportCompany.class, id);
                transaction.commit();
            }
            return transportCompany;
        }

        public static void deleteCompany(TransportCompany transportCompany) {
            try (Session session = Configuration.Session.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(transportCompany);
                transaction.commit();
            }
        }
    public static List<TransportCompany> companiesWithNameEqualTo(String name) {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<TransportCompany> cr = cb.createQuery(TransportCompany.class);
            Root<TransportCompany> root = cr.from(TransportCompany.class);

            cr.select(root).where(cb.equal(root.get("name"), name));

            Query<TransportCompany> query = session.createQuery(cr);
            List<TransportCompany> transportCompanies = query.getResultList();
            return transportCompanies;
        }
    }
    public static List<Transport> getTransportCompanyTransports(int id) {
        TransportCompany transportCompany;
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transportCompany = session.createQuery(
                            "select c from TransportCompany c" +
                                    " join fetch c.transports" +
                                    " where c.id = :id",
                            TransportCompany.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return transportCompany.getTransports();
        }
    public static Set<Driver> getTransportCompanyDrivers(int id) {
        TransportCompany transportCompany;
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transportCompany = session.createQuery(
                            "select c from TransportCompany c" +
                                    " join fetch c.drivers" +
                                    " where c.id = :id",
                            TransportCompany.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return transportCompany.getDrivers();
    }
    public static Set<Client> getTransportCompanyClients(int id) {
        TransportCompany transportCompany;
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transportCompany = session.createQuery(
                            "select c from TransportCompany c" +
                                    " join fetch c.clients" +
                                    " where c.id = :id",
                            TransportCompany.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
        }
        return transportCompany.getClients();
    }


    //zad 7 a

    public static List<TransportCompany> TransportCompaniesIncomeFilterBetween(double lowerBound, double upperBound) {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<TransportCompany> cr = cb.createQuery(TransportCompany.class);
            Root<TransportCompany> root = cr.from(TransportCompany.class);

            cr.select(root).where(cb.between(root.get("income"), lowerBound, upperBound));

            Query<TransportCompany> query = session.createQuery(cr);
            List<TransportCompany> transportCompanyList = query.getResultList();
            return transportCompanyList;
        }
    }
    //zad 7 a sorted by name
    public static List<TransportCompany> TransportCompaniesSortedByNameAscending() {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<TransportCompany> cr = cb.createQuery(TransportCompany.class);
            Root<TransportCompany> root = cr.from(TransportCompany.class);
            cr.orderBy(cb.asc(root.get("name")));

            Query<TransportCompany> query = session.createQuery(cr);
            List<TransportCompany> transportCompanies = query.getResultList();
            return transportCompanies;
        }
    }

    public static List<TransportCompany> TransportCompaniesSortedByIncomeAscending() {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<TransportCompany> cr = cb.createQuery(TransportCompany.class);
            Root<TransportCompany> root = cr.from(TransportCompany.class);
            cr.orderBy(cb.asc(root.get("income")));

            Query<TransportCompany> query = session.createQuery(cr);
            List<TransportCompany> transportCompanies = query.getResultList();
            return transportCompanies;
        }
    }
    public static Double incomeForTransportCompaniesBetween(int id,LocalDate upperBound,LocalDate lowerBound) {
        try (Session session = Configuration.Session.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Double> cr = cb.createQuery(Double.class);
            Root<Transport> transportRoot = cr.from(Transport.class);
            Join<TransportCompany, Transport> transports = transportRoot.join("transportCompany");
            cr.where(cb.equal(transportRoot.get("transportCompany"),"transportCompanyId"));

           // cr.select(transports))
            // cr.where(cb.equal(transportRoot.get(transportCompany.id,"transportId")));

            //cr.select(transportRoot).where(cb.greaterThan(transportRoot.get("foundationDate"), localDate));

            //cr.select(cb.sum(root.get("price")));
            Predicate[] predicates = new Predicate[3];
            predicates[0]=cb.equal(transportRoot.get("transportCompany"),id);
            predicates[1]=cb.between(transportRoot.get("dateOfGoing"), lowerBound, upperBound);
            predicates[2]=cb.between(transportRoot.get("dateOfArrival"),lowerBound, upperBound);

            cr.select(cb.sum(transportRoot.get("price")));
            cr.where(predicates);
            Query<Double> query = session.createQuery( cr);
            Double sum = query.getSingleResult();
            return sum;
        }
    }

}


