package com.bot.mogilabot.service;

import com.bot.mogilabot.model.TelegramUser;
import com.bot.mogilabot.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserStartService {
    private final UserRepository userRepository;

    @Transactional
    public void processStart(@NonNull Long systemUserId, @NonNull Long chatId) {
        TelegramUser user = new TelegramUser(systemUserId, chatId);
        userRepository.save(user);
    }
}
