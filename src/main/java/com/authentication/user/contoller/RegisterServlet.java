package com.authentication.user.contoller;

import com.authentication.user.dao.UserDAO;
import com.authentication.user.model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserDAO userDao=new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        String salt=BCrypt.gensalt(12);
        String hashPassword=BCrypt.hashpw(password,salt);

        UserModel user=new UserModel();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(hashPassword);


        if(name.isEmpty()||email.isEmpty()||password.isEmpty()){
            req.setAttribute("error","Please fill all the fields");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req,resp);
            return;
        }

        boolean isEmailExist=userDao.isEmailExist(email);
        if(isEmailExist){
            req.setAttribute("error","Email already exists");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req,resp);
            return;
        }

        boolean insertUser=userDao.insertUser(user);
        if(insertUser){
            resp.sendRedirect(req.getContextPath() + "/login");
        }else{
            req.setAttribute("error","Failed to register user");
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req,resp);
        }
    }
}
