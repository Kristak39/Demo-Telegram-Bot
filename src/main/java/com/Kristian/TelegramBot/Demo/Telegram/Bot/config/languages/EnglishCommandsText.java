package com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages;

public class EnglishCommandsText implements Language{

    @Override
    public String startCommand() {
        return """
                Welcome! This bot is designed to test your Java knowledge. Here is a list of commands you can use:
                                
                    /startTest - Start the test.
                    /nextQuestion - Get the next question.
                    /addQuestion - Add your own question.
                    /score - Check your current score.
                    /end - End the test and get the final result.
                                
                If you have any questions or need help, use the /help command. Good luck!""";
    }

    @Override
    public String quizStartCommand() {
        return "";
    }

    @Override
    public String addQuizStartCommand() {
        return "";
    }

    @Override
    public String scoreCommand() {
        return "";
    }

    @Override
    public String settingsCommand() {
        return "";
    }

    @Override
    public String helpCommand() {
        return "";
    }
}
