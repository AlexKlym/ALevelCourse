package com.alevel.qalist;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/qa")
public class QAServlet extends HttpServlet {

    private ObjectMapper objectMapper;

    private HikariDataSource dataSource;

    private QARepository qaRepository;

    @Override
    public void init() {
        HikariConfig hikariConfig = new HikariConfig("/hikari.properties");
        dataSource = new HikariDataSource(hikariConfig);
        qaRepository = new QARepository(dataSource);
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String question = req.getParameter("answer");
        String answer;

        try {
            answer = qaRepository.getAnswer(question);
            System.out.println(question);
        } catch ( QAException e) {
            resp.sendError(
                    HttpServletResponse.SC_NOT_FOUND,
                    e.getMessage()
            );
            return;
        }
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("application/json;charset=utf8");
        objectMapper.writeValue(resp.getOutputStream(), answer);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        QA qalist = objectMapper.readValue(req.getInputStream(), QA.class);
        String answer;
        try {
            qaRepository.saveQuestion(qalist);
        } catch (QAException e) {
            resp.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
            return;
        }

        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setContentType("application/json;charset=utf8");
    }

    @Override
    public void destroy() {
        dataSource.close();
    }
}
