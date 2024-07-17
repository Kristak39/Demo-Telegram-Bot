package com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages;

public class RomanianCommandsText implements Language{

    @Override
    public String startCommand() {
        return """
                Bun venit! Acest bot este conceput pentru a vă testa cunoștințele de Java. Iată o listă de comenzi pe care le puteți folosi:
                
                    /quiz - obține chestionar
                    
                    /ru - schimbă limba în rusă
                    /ro - schimbă limba în română
                    /en - schimbă limba în engleză
                        
                Dacă aveți întrebări sau aveți nevoie de ajutor, folosiți comanda /help. Mult succes!""";
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
