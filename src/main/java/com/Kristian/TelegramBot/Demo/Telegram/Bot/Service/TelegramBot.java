package com.Kristian.TelegramBot.Demo.Telegram.Bot.Service;

import com.Kristian.TelegramBot.Demo.Telegram.Bot.cache.UsersCache;
import com.Kristian.TelegramBot.Demo.Telegram.Bot.config.BotConfig;
import com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages.ChoseLanguage;
import com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages.Language;
import com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages.UserLanguage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;

    private UsersCache usersCache = new UsersCache();

    public TelegramBot (BotConfig config){
        super(config.getBotToken());
        this.config=config;
        List<BotCommand> listOfComands = new ArrayList<>();
        listOfComands.add(new BotCommand("/start", "start bot"));
        listOfComands.add(new BotCommand("/quiz", "start quiz"));
        listOfComands.add(new BotCommand("/addQuiz" , "add personal quiz"));
        listOfComands.add(new BotCommand("/score", "your score"));
        listOfComands.add(new BotCommand("/settings", "set your preferences"));
        listOfComands.add(new BotCommand("/help", "bot commands info"));
        try{
            this.execute(new SetMyCommands(listOfComands, new BotCommandScopeDefault(), null));
        }catch (TelegramApiException e){
            log.error("error seting bot's commands list" + e.getMessage());
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            UserLanguage language = new UserLanguage();
            if (!(usersCache.containsId(chatId))){
                usersCache.addToCache(chatId, new UserLanguage());
            }

            switch (messageText){
                case "/start": startComandRecived(chatId,  usersCache.getFromCache(chatId).getLanguage());
                break;
                case "/startTest" : sendQuiz(chatId);
                case "/en": usersCache.addToCache(chatId, new UserLanguage(ChoseLanguage.ENGLISH));
                break;
                case "/ru": usersCache.addToCache(chatId, new UserLanguage(ChoseLanguage.RUSSIAN));
                break;
                case "/ro": usersCache.addToCache(chatId, new UserLanguage(ChoseLanguage.ROMANIAN));
                break;
                default: sendMessage(chatId, language.getLanguage().startCommand());
            }

        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    private void sendMessage(long chatId, String messageToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(messageToSend);

        try {
            execute(message);
        }catch (TelegramApiException e){
            log.error("TelegramApiException TelegramBot" + e.getMessage());
        }
    }

    private void startComandRecived(long chatId, Language language){

        String answer = String.format("""
                                           %s""", language.startCommand());
        sendMessage(chatId,answer);
        log.info("Replied to user {}", chatId);
    }

    private void sendQuiz(long chatId){
        SendPoll poll = new SendPoll();
        poll.setType("quiz");
        List<String> options = new ArrayList<>();
        options.add("1");
        options.add("2");
        options.add("3");
        options.add("4");
        poll.setChatId(String.valueOf(chatId));
        poll.setQuestion("Right answer is 3");
        poll.setCorrectOptionId(2);
        poll.setOptions(options);

        try {
            execute(poll);
        }catch (TelegramApiException e){
            log.error("Quiz send error" + e.getMessage());
        }
    }
}
