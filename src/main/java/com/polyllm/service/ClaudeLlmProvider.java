package com.polyllm.service;

import com.polyllm.entities.ConversationMessage;
import com.polyllm.service.interfaces.LlmProvider;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaudeLlmProvider implements LlmProvider {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ClaudeLlmProvider.class);

    @Value("${LLM_CLAUDE_API_KEY:}")
    private String claudeApiKey;

    @Override
    public String generateResponse(List<ConversationMessage> messages) {
        // TODO: Implement API call to the LLM provider
        return "";
    }
}
