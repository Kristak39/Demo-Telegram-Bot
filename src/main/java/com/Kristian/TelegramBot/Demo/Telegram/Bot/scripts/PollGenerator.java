package com.Kristian.TelegramBot.Demo.Telegram.Bot.scripts;

import com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages.ChoseLanguage;
import com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages.Language;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.List;

public class PollGenerator {

    public static SendPoll pollGenerator(Long chatID,ChoseLanguage userLanguage) {
        String url = "jdbc:mysql://localhost:3306/TelegramBotData";
        String username = "root";
        String password = "20101234";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        int rowCount = 1;

        String lang = userLanguage.equals(ChoseLanguage.ROMANIAN) ? "RO":
                      userLanguage.equals(ChoseLanguage.ENGLISH) ? "EN" : "RU";


        SendPoll poll = new SendPoll();
        poll.setType("quiz");
        poll.setChatId(String.valueOf(chatID));
        List <String> options = new ArrayList<>();


            try {
                // 1. Установите соединение с базой данных
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection to MySQL has been established.");

                // 2. Создайте объект Statement для выполнения SQL-запроса
                statement = connection.createStatement();

                // 3. Выполните SQL-запрос для подсчета строк
                String sql = String.format("SELECT COUNT(*) FROM Poll_%s", lang);  // Измените на вашу таблицу
                resultSet = statement.executeQuery(sql);

                // 4. Обработайте результат запроса
                if (resultSet.next()) {
                    rowCount = resultSet.getInt(1);
                    System.out.println("Number of rows in the table: " + rowCount);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                // 5. Закройте все ресурсы
                try {
                    if (resultSet != null) resultSet.close();
                    if (statement != null) statement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        int random = (int) ((Math.random() * rowCount) + 1);

        try {
            // 1. Установите соединение с базой данных
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to MySQL has been established.");

            // 2. Создайте объект Statement для выполнения SQL-запроса
            statement = connection.createStatement();


            // 3. Выполните SQL-запрос
            String sql = String.format("SELECT * FROM Poll_%s WHERE id=%d", lang, random);  // Измените на вашу таблицу
            resultSet = statement.executeQuery(sql);

            // 4. Обработайте результаты запроса
            while (resultSet.next()) {
                poll.setQuestion(resultSet.getString("Question"));
                poll.setCorrectOptionId(resultSet.getInt("CorrectOption"));
                options.add(resultSet.getString("Option1"));
                options.add(resultSet.getString("Option2"));
                options.add(resultSet.getString("Option3"));
                options.add(resultSet.getString("Option4"));
                poll.setOptions(options);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // 5. Закройте все ресурсы
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return poll;
    }

}


