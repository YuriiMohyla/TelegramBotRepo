package com.bot.mogilabot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "telegram_user")
@NoArgsConstructor
public class TelegramUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long systemUserId;

    @Column(nullable = false)
    private Long chatId;

    public TelegramUser(Long systemUserId, Long chatId) {
        this.systemUserId = systemUserId;
        this.chatId = chatId;
    }
}
