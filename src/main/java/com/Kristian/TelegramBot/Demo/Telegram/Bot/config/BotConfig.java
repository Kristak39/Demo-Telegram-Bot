package com.Kristian.TelegramBot.Demo.Telegram.Bot.config;

import lombok.Data;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@Data
@PropertySource("application.properties")
public class BotConfig {

    @Value("${bot.Name}")
    private String botName;

    @Value("${bot.Token}")
    private String botToken;
}
