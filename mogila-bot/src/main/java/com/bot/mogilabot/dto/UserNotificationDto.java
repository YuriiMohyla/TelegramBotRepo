package com.bot.mogilabot.dto;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class UserNotificationDto {
    @NonNull
    private Long userId;
    @NonNull
    private List<Notification> messages;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "of")
    public static class Notification {
        @NonNull
        private String message;
        @NonNull
        private ZonedDateTime date;
    }
}
