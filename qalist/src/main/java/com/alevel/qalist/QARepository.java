package com.alevel.qalist;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QARepository {

    private final DataSource dataSource;

    public QARepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void saveQuestion(QA entity) throws QAException{
        String insert = "INSERT INTO qalist (question, answer) VALUE (?, ?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, entity.getQuestion());
            preparedStatement.setString(2, entity.getAnswer());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new QAException(e);
        }
    }

    public String getAnswer(String quest) throws QAException{
        String insert = "SELECT answer FROM qalist WHERE question = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, quest);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                return resultSet.getString("answer");
            } else {
                throw new QAException("No answer found!");
            }

        } catch (SQLException e) {
            throw new QAException(e);
        }
    }


}
