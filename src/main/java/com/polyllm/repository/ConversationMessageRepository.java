package com.polyllm.repository;

import com.polyllm.entities.ConversationMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConversationMessageRepository extends JpaRepository<ConversationMessage, UUID> {
}
