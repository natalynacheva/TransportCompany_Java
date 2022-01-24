package DAO;

import Entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static Configuration.Session.getSessionFactory;

public class ClientDAO {



        public static void saveClient(Client client) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(client);
                transaction.commit();
            }
        }

        public static void saveOrUpdateClient(Client client) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(client);
                transaction.commit();
            }
        }

        public static void saveClient(List<Client> clients) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                clients.stream().forEach((g) -> session.save(g));
                transaction.commit();
            }
        }

        public static Client getClient(int id) {
            Client client;
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                client = session.get(Client.class, id);
                transaction.commit();
            }
            return client;
        }

        public static void deleteClient (Client client) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(client);
                transaction.commit();
            }
        }
    }