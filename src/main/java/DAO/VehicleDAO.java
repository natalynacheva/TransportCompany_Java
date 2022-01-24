package DAO;

import Entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static Configuration.Session.getSessionFactory;

public class VehicleDAO {


        public static void saveVehicle(Vehicle vehicle) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(vehicle);
                transaction.commit();
            }
        }

        public static void saveOrUpdateVehicle(Vehicle vehicle) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(vehicle);
                transaction.commit();
            }
        }

        public static void saveVehicle(List<Vehicle> vehicle) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                vehicle.stream().forEach((g) -> session.save(g));
                transaction.commit();
            }
        }

        public static Vehicle getVehicle(int id) {
            Vehicle vehicle;
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                vehicle = session.get(Vehicle.class, id);
                transaction.commit();
            }
            return vehicle;
        }

        public static void deleteVehicle(Vehicle vehicle) {
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(vehicle);
                transaction.commit();
            }
        }
    }

