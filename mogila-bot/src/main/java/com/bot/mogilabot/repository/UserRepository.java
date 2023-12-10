package com.bot.mogilabot.repository;

import com.bot.mogilabot.model.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<TelegramUser, Long> {
    Optional<TelegramUser> findBySystemUserId(Long userId);
}
