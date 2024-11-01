package com.servlet;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fullName = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String about = req.getParameter("about");

        User user = new User(fullName, email, password, about);
        UserDao userDao = new UserDao(HibernateUtil.getSessionFactory());
        boolean b = userDao.saveUser(user);
        HttpSession httpSession =req.getSession();
        if (b) {
            httpSession.setAttribute("message","Registered successfully...");
            resp.sendRedirect("register.jsp");
        } else {
            httpSession.setAttribute("message","Something went wrong, try again...");
            resp.sendRedirect("register.jsp");
        }
    }
}
