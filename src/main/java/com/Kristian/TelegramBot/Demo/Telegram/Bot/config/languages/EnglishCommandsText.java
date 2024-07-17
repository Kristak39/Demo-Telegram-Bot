package com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages;

public class EnglishCommandsText implements Language{

    @Override
    public String startCommand() {
        return """
                Welcome! This bot is designed to test your Java knowledge. Here is a list of commands you can use:
                                
                    /quiz - get quiz.
                    
                    /ru - switch language to Russian
                    /ro - switch language to Romanian
                    /en - switch language to English          
                    
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
