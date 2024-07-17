package com.Kristian.TelegramBot.Demo.Telegram.Bot.cache;

import com.Kristian.TelegramBot.Demo.Telegram.Bot.config.languages.UserLanguage;

import java.util.Hashtable;
import java.util.Map;

public class UsersCache {
    private Map<Long, UserLanguage> userCache = new Hashtable<>();

    public void addToCache(Long chatId, UserLanguage language){
        userCache.put(chatId,language);
    }

    public UserLanguage getFromCache (long userId){
        return userCache.get(userId);
    }

    public void removeFromCache (Long userId){
        userCache.remove(userId);
    }

    public boolean containsId (Long userId){
        return userCache.containsKey(userId);
    }
}
