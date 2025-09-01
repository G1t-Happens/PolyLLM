package com.polyllm.service;

import com.polyllm.entities.Conversation;
import com.polyllm.entities.ConversationMessage;
import com.polyllm.enums.LLMProvider;
import com.polyllm.exception.ResourceNotFoundException;
import com.polyllm.repository.ConversationRepository;
import com.polyllm.service.interfaces.ConversationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConversationServiceImpl implements ConversationService {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ConversationServiceImpl.class);

    private final ConversationRepository conversationRepository;

    @Autowired
    public ConversationServiceImpl(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }


    @Override
    public Conversation createConversation(LLMProvider llmProvider, String llmModel) {
        LOG.debug("--> createConversation");

        LOG.debug("<-- createConversation");
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
