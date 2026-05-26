package com.authentication.topic.controller;

import com.authentication.topic.dao.TopicDAO;
import com.authentication.topic.model.TopicModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class AllTopicServlet extends HttpServlet {
    TopicDAO topicDAO=new TopicDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<TopicModel> topicList=topicDAO.getAllTopic();
        req.setAttribute("topics",topicList);
        req.getRequestDispatcher("/WEB-INF/topic/topicList.jsp").forward(req,resp);
    }
}
