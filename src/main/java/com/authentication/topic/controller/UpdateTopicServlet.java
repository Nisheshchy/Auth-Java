package com.authentication.topic.controller;

import com.authentication.topic.dao.TopicDAO;
import com.authentication.topic.model.TopicModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/update-topic")
public class UpdateTopicServlet extends HttpServlet {
    TopicDAO topicDAO=new TopicDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        TopicModel topic=topicDAO.getSingleTopic(id);
        req.setAttribute("topic",topic);
        req.getRequestDispatcher("/WEB-INF/topic/updateTopic.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String topic_name=req.getParameter("topic_name");

        boolean isUpdate=topicDAO.updateTopic(id,topic_name);
        if(isUpdate){
            resp.sendRedirect(req.getContextPath()+"/topic-list");
        }else{
            req.setAttribute("error","Unable to update topic");
            req.getRequestDispatcher("/WEB-INF/topic/updateTopic.jsp").forward(req,resp);
        }

    }
}
