package com.db;

import com.entity.Expense;
import com.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
        Configuration configuration=new Configuration();
        Properties properties=new Properties();
        properties.setProperty(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        properties.setProperty(Environment.URL,"jdbc:mysql://localhost:3306/expense_tracker");
        properties.setProperty(Environment.USER,"root");
        properties.setProperty(Environment.PASS,"root");
        properties.setProperty(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty(Environment.SHOW_SQL,"true");
        properties.setProperty(Environment.HBM2DDL_AUTO,"update");
       // properties.put(Environment.USE_SECOND_LEVEL_CACHE,true);
      //  properties.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.EhCacheRegionFactory");

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Expense.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory=  configuration.buildSessionFactory(serviceRegistry);
    }
        return sessionFactory;
    }
}
