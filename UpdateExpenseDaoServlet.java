package com.servlet;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;
import com.entity.Expense;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updateExpense")
public class UpdateExpenseDaoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String description = req.getParameter("description");
        String price = req.getParameter("price");


        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("loginUser");

        Expense expense = new Expense(title, date, time, description, price, user);
        expense.setId(id);
        ExpenseDao expenseDao =new ExpenseDao(HibernateUtil.getSessionFactory());
        boolean b = expenseDao.updateExpense(expense);
        if (b==true) {
            httpSession.setAttribute("message", "Updated Expenses successfully...");
            resp.sendRedirect("user/view_expense.jsp");
        } else {
            httpSession.setAttribute("message", "something went wrong, try again...");
            resp.sendRedirect("user/view_expense.jsp");
        }
    }
}
