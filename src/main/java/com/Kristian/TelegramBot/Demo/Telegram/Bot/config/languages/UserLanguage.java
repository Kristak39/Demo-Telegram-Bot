package com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages;

import lombok.Getter;

public class UserLanguage {

    @Getter
    private ChoseLanguage languageChoise;
    @Getter
    private Language language;


    public UserLanguage() {
         languageChoise = ChoseLanguage.ENGLISH;
         setLanguage(languageChoise);
    }

    public UserLanguage(ChoseLanguage languageChoise) {
        this.languageChoise = languageChoise;
        setLanguage(languageChoise);
    }

    public void setUserLanguage(ChoseLanguage languageChoise) {
        this.languageChoise = languageChoise;
        setLanguage(languageChoise);
    }

    public void setLanguage(ChoseLanguage languageChoise) {
        switch (languageChoise){
            case ENGLISH -> {
                language = new EnglishCommandsText();
            }
            case RUSSIAN -> {
                language = new RussianCommandsText();
            }
            case ROMANIAN -> {
                language = new RomanianCommandsText();
            }
        }
    }
}
