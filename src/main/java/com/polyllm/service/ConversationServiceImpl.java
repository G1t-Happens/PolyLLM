package com.polyllm.service;

import com.polyllm.entities.Conversation;
import com.polyllm.entities.ConversationMessage;
import com.polyllm.exception.ResourceNotFoundException;
import com.polyllm.service.interfaces.ConversationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConversationServiceImpl implements ConversationService {
    @Override
    public Conversation createConversation(String llmProvider) {
        return null;
    }

    @Override
    public Conversation getConversation(UUID id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<ConversationMessage> getMessagesForConversation(UUID conversationId) throws ResourceNotFoundException {
        return List.of();
    }

    @Override
    public ConversationMessage addMessageToConversation(UUID conversationId, String content) throws ResourceNotFoundException {
        return null;
    }
}
