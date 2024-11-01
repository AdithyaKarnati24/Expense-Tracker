package com.servlet;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        UserDao userDao=new UserDao(HibernateUtil.getSessionFactory());
       User user= userDao.login(email, password);
        HttpSession httpSession=req.getSession();
        if(user==null){

            httpSession.setAttribute("message","Invalid email or password re-enter again");
            resp.sendRedirect("login.jsp");
        }else{
            httpSession.setAttribute("loginUser",user);
            resp.sendRedirect("user/home.jsp");
        }
    }
}
