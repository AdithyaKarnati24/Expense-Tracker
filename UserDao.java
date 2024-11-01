package com.dao;

import com.db.HibernateUtil;
import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDao {
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean saveUser(User user) {
        boolean f = false;

            try {
                session = sessionFactory.openSession();
                transaction = session.beginTransaction();
                session.save(user);
                transaction.commit();
                f = true;

            } catch (Exception e) {
                if(transaction!=null) {
                    f = false;
                    e.printStackTrace();
                }
        }
        return f;
    }
    public User login(String email, String password){
        User user=null;
      session=  sessionFactory.openSession();
      Query query = session.createQuery("from User where email=:em and password=:pw");
      query.setParameter("em",email);
      query.setParameter("pw", password);
      user=(User)query.uniqueResult();


        return user;
    }
}
