package com.servlet;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));

        ExpenseDao expenseDao=new ExpenseDao(HibernateUtil.getSessionFactory());
      boolean b=  expenseDao.deleteExpense(id);
        HttpSession httpSession= req.getSession();
        if(b){
            httpSession.setAttribute("message","Deleted successfully...");
            resp.sendRedirect("user/view_expense.jsp");
        }else {
            httpSession.setAttribute("message","Something went wrong, try again...");
            resp.sendRedirect("user/view_expense.jsp");
        }

    }
}
