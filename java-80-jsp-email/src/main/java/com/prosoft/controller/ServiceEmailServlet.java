package com.prosoft.controller;

import com.prosoft.services.ServiceEmail;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServiceEmailServlet")
public class ServiceEmailServlet extends HttpServlet {
    private String user;
    private String pass;
    private String host;
    private String port;

    public void init() {
        ServletContext context = getServletContext();
        pass = context.getInitParameter("pass");
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("address");
        String topic = request.getParameter("topic");
        String text = request.getParameter("text");
        try {
            ServiceEmail.sendEmail(host, port, user, pass, address, topic, text);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}