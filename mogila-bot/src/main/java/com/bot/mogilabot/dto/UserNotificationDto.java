package com.bot.mogilabot.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class UserNotificationDto {
    @NonNull
    private Long userId;
    @NonNull
    private List<String> messages;
}
