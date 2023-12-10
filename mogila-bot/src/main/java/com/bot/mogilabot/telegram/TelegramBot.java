package com.bot.mogilabot.telegram;

import com.bot.mogilabot.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.util.AbilityExtension;

import java.util.List;

@Component
public class TelegramBot extends AbilityBot {
    protected TelegramBot(BotConfig config, List<AbilityExtension> abilities) {
        super(config.getToken(), config.getName());
        addExtensions(abilities);
    }

    @Override
    public long creatorId() {
        return 1L;
    }
}
