package com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages;

public class RomanianCommandsText implements Language{

    @Override
    public String startCommand() {
        return "Bun venit! Acest bot este conceput pentru a vă testa cunoștințele de Java. Iată o listă de comenzi pe care le puteți folosi:\n" +
                "\n" +
                "    /startTest - Începeți testul.\n" +
                "    /nextQuestion - Obțineți următoarea întrebare.\n" +
                "    /addQuestion - Adăugați propria întrebare.\n" +
                "    /score - Verificați scorul curent.\n" +
                "    /end - Încheiați testul și obțineți rezultatul final.\n" +
                "\n" +
                "Dacă aveți întrebări sau aveți nevoie de ajutor, folosiți comanda /help. Mult succes!";
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
