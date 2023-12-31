package com.bot.mogilabot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("telegram.bot")
public class BotConfig {
    private String name;
    private String token;
}
