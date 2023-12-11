package com.bot.mogilabot.service;

import com.bot.mogilabot.dto.UserNotificationDto;
import com.bot.mogilabot.repository.UserRepository;
import com.bot.mogilabot.telegram.TelegramBot;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserNotificationService {
    private final UserRepository repository;
    private final TelegramBot telegramBot;
    private final TaskScheduler taskScheduler;

    public void sendNotification(@NonNull UserNotificationDto notificationDto) {
        repository.findBySystemUserId(notificationDto.getUserId())
                .ifPresent(telegramUser -> sendNotification(telegramUser.getChatId(), notificationDto.getMessages()));
    }

    private void sendNotification(Long userChatId, List<UserNotificationDto.Notification> messages) {
        messages.forEach(message -> taskScheduler.schedule(
                () -> telegramBot.silent().send(message.getMessage(), userChatId),
                Instant.from(message.getDate())
        ));
    }
}
