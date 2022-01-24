package DAO;

import Entity.Goods;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static Configuration.Session.getSessionFactory;

public class GoodsDAO {

    public static void saveGoods(Goods goods) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(goods);
            transaction.commit();
        }
    }

    public static void saveOrUpdateGoods(Goods goods) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(goods);
            transaction.commit();
        }
    }

    public static void saveGoods(List<Goods> goods) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            goods.stream().forEach((g) -> session.save(g));
            transaction.commit();
        }
    }

    public static Goods getGoods(int id) {
        Goods goods;
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            goods = session.get(Goods.class, id);
            transaction.commit();
        }
        return goods;
    }

    public static void deleteCompany(Goods goods) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(goods);
            transaction.commit();
        }
    }
}
