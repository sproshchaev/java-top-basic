package com.prosoft.controller;

import com.prosoft.domain.Story;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.Month;
import java.time.MonthDay;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

@WebServlet(name = "storyServlet", urlPatterns = "/list")
public class StoryServlet extends HttpServlet {

    private static final SortedSet<Story> STORIES = new TreeSet<Story>() {
        {
            add(new Story("News1", "Basketball", "Ivanov", "Sport", MonthDay.of(Month.JULY, 14), Instant.parse("2018-07-15T08:13:45Z")));
            add(new Story("News2", "Fish", null, "Food", MonthDay.of(Month.JULY, 13), Instant.parse("2018-07-16T08:17:45Z")));
            add(new Story("News3", "New president", "Petrov", "Politics", MonthDay.of(Month.JULY, 15), Instant.parse("2018-07-15T08:45:45Z")));
        }
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("empty") != null) {
            request.setAttribute("stories", Collections.<Story>emptySet());
        } else {
            request.setAttribute("stories", STORIES);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/view/list.jsp").forward(request, response);
    }

}
