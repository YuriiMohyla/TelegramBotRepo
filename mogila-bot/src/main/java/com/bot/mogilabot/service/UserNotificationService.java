package com.bot.mogilabot.service;

import com.bot.mogilabot.dto.UserNotificationDto;
import com.bot.mogilabot.repository.UserRepository;
import com.bot.mogilabot.telegram.TelegramBot;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserNotificationService {
    private final UserRepository repository;
    private final TelegramBot telegramBot;

    public void sendNotification(@NonNull UserNotificationDto notificationDto) {
        repository.findBySystemUserId(notificationDto.getUserId())
                .ifPresent(telegramUser -> sendNotification(telegramUser.getChatId(), notificationDto.getMessages()));
    }

    private void sendNotification(Long userChatId, List<String> messages) {
        messages.forEach(message -> telegramBot.silent().send(message, userChatId));
    }
}
