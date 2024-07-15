package com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages;

public class RussianCommandsText implements Language{

    @Override
    public String startCommand() {
        return """
                Добро пожаловать! Этот бот создан для проверки ваших знаний по Java. Вот список команд, которые вы можете использовать:
                                
                    /startTest - Начать тестирование.
                    /nextQuestion - Получить следующий вопрос.
                    /addQuestion - Добавить свой вопрос.
                    /score - Узнать текущий результат.
                    /end - Завершить тестирование и получить итоговый результат.
                                
                Если у вас есть вопросы или нужна помощь, используйте команду /help. Удачи!""";
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
