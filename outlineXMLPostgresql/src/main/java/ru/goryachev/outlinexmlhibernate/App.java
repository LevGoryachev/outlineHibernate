package ru.goryachev.outlinexmlhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.goryachev.outlinexmlhibernate.entities.People;

public class App {
    public static void main(String[] args) {
        Configuration hibernateConfiguration = new Configuration();
        hibernateConfiguration.configure();
        hibernateConfiguration.addAnnotatedClass(People.class);

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(hibernateConfiguration.getProperties());

        SessionFactory sessionFactory = hibernateConfiguration.buildSessionFactory(registryBuilder.build());

        //usage:
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new People("Ivan", 25));
        transaction.commit();
        session.close();
    }
}
