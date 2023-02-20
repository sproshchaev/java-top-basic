package com.prosoft.controller;

import com.prosoft.domain.Card;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

//@WebServlet(name = "cardServlet", urlPatterns = {"/cards"}, loadOnStartup = 1)
public class CardServlet extends HttpServlet {

    private Map<Integer, Card> cardBase = new LinkedHashMap<>();
    private volatile int CARD_ID = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "create":
                this.showCardForm(request, response);
                break;
            case "view":
                this.viewCard(request, response);
                break;
            case "list":
                this.listCards(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "create":
                this.createCard(request, response);
                break;
            case "list":
                response.sendRedirect("cards");
                break;
        }
    }

    private void createCard(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Card card = new Card();
        card.setClientName(request.getParameter("clientName"));
        card.setTopic(request.getParameter("topic"));
        card.setMessage(request.getParameter("message"));
        int id;
        synchronized (this) {
            id = this.CARD_ID++;
            this.cardBase.put(id, card);
        }
        response.sendRedirect("cards?action=view&cardId=" + id);
    }

    private void showCardForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/view/cardForm.jsp").forward(request, response);
    }

    private void viewCard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("cardId");
        Card card = this.getCard(idStr, response);
        if (card == null)
            return;
        request.setAttribute("cardId", idStr);
        request.setAttribute("card", card);
        request.getRequestDispatcher("/WEB-INF/jsp/view/viewCard.jsp").forward(request, response);
    }

    private Card getCard(String idStr, HttpServletResponse response)
            throws IOException {
        if (idStr == null || idStr.length() == 0) {
            response.sendRedirect("cards");
            return null;
        }
        try {
            Card card = this.cardBase.get(Integer.parseInt(idStr));
            if (card == null) {
                response.sendRedirect("cards");
                return null;
            }
            return card;
        } catch (Exception e) {
            response.sendRedirect("cards");
            return null;
        }
    }

    private void listCards(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cardBase", this.cardBase);
        request.getRequestDispatcher("/WEB-INF/jsp/view/listCards.jsp").forward(request, response);
    }

}
