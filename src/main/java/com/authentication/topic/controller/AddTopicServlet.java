package com.authentication.topic.controller;

import com.authentication.topic.dao.TopicDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add-topic")
public class AddTopicServlet extends HttpServlet {
    TopicDAO topicDAO=new TopicDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/topic/addTopic.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  name=req.getParameter("topic_name");
        if(name==null){
            req.setAttribute("error","Please fill all the fields");
            req.getRequestDispatcher("/WEB-INF/topic/addTopic.jsp").forward(req,resp);
        }
        if(topicDAO.addTopic(name)){
            resp.sendRedirect(req.getContextPath()+"/topic-list");
        }else{
            req.setAttribute("error","Unable add topic");
            req.getRequestDispatcher("/WEB-INF/topic/addTopic.jsp").forward(req,resp);
        }
    }
}
