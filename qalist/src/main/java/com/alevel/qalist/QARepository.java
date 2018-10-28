package com.alevel.qalist;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QARepository {

    private final DataSource dataSource;

    public QARepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveQuestion(QA entity) throws QAException {
        String insert = "INSERT INTO qalist (question, answer) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, entity.getQuestion());
            preparedStatement.setString(2, entity.getAnswer());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new QAException(e);
        }
    }

    public String getAnswer(String quest) throws QAException {
        String insert = "SELECT answer FROM qalist WHERE question = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, quest);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.first();
            return resultSet.getString("answer");

        } catch (SQLException e) {
            throw new QAException(e);
        }
    }


}
