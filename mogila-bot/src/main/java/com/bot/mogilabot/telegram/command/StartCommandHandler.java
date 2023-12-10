package com.bot.mogilabot.telegram.command;

import com.bot.mogilabot.service.UserStartService;
import com.bot.mogilabot.utils.BotUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.MessageContext;
import org.telegram.abilitybots.api.objects.Privacy;
import org.telegram.abilitybots.api.util.AbilityExtension;

@Component
@AllArgsConstructor
public class StartCommandHandler implements AbilityExtension {
    private static final String COMMAND = "start";
    private static final String SUCCESS_MESSAGE = "Дякую за користування ботом, ви будете отримувати сповіщення про інвентар";

    private final UserStartService startService;

    public void handle(MessageContext context) {
        // TODO
        startService.processStart(BotUtils.extractStartId(context), context.chatId());
        BotUtils.sendMessage(SUCCESS_MESSAGE, context);
    }

    @SuppressWarnings("unused")
    public Ability startAbility() {
        return Ability.builder()
                .name(COMMAND)
                .info("Description")
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(this::handle)
                .build();
    }
}
