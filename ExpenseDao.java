package com.dao;

import com.entity.Expense;
import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public ExpenseDao(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }

    public boolean saveExpense(Expense expense) {
        boolean f = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(expense);
            transaction.commit();
            f = true;

        } catch (Exception exception) {
            if (transaction != null) {
                f = false;
                exception.printStackTrace();
            }
        }
        return f;
    }
    public List<Expense> getAllExpenses(User user){
        List<Expense> list=new ArrayList();
        try {
            session=sessionFactory.openSession();
            Query query =session.createQuery("from Expense where user=:user");
            query.setParameter("user",user);
             list =query.list();

        }catch (Exception exception){
            exception.printStackTrace();
        }
        return list;
    }

    public Expense getExpenseById(int id){

        Expense expense=null;
        try{
            session=sessionFactory.openSession();
            Query query=session.createQuery("from Expense where id=:id");
            query.setParameter("id",id);
            expense=(Expense) query.uniqueResult();

        }catch (Exception exception){
            exception.printStackTrace();
        }

        return expense;
    }
    public boolean updateExpense(Expense expense) {
        boolean f = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(expense);
            transaction.commit();
            f = true;

        } catch (Exception exception) {
            if (transaction != null) {
                f = false;
                exception.printStackTrace();
            }
        }
        return f;
    }

    public boolean deleteExpense(int id){
        boolean f=false;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
           Expense expense= session.get(Expense.class, id);
           session.delete(expense);
           transaction.commit();
           f=true;



        }catch (Exception exception){
            f=false;
            exception.printStackTrace();
        }
        return f;
    }


}
