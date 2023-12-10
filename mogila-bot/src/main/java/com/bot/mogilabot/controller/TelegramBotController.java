package com.bot.mogilabot.controller;

import com.bot.mogilabot.dto.UserNotificationDto;
import com.bot.mogilabot.service.UserNotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TelegramBotController {
    private final UserNotificationService notificationService;

    @PostMapping("/notification")
    public void send(@RequestBody UserNotificationDto notificationDto) {
        notificationService.sendNotification(notificationDto);
    }
}
