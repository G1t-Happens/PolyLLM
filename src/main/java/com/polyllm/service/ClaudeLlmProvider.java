package com.polyllm.service;

import com.polyllm.entities.ConversationMessage;
import com.polyllm.service.interfaces.LlmProvider;
import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ClaudeLlmProvider implements LlmProvider {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ClaudeLlmProvider.class);

    private final RestClient restClient;

    @Autowired
    public ClaudeLlmProvider(@Qualifier("claudeClient") RestClient restClient) {
        this.restClient = restClient;
    }

    @PostConstruct
    public void validateApiKey() {
        LOG.debug("--> validateApiKey");
        if (restClient == null) {
            throw new IllegalStateException("RestClient is not initialized");
        }
        //TODO: Check for API Key
        LOG.info("<-- validateApiKey, Claude LLM provider initialized successfully.");
    }

    @Override
    public String generateResponse(List<ConversationMessage> messages) {
        // TODO: Implement API call to the LLM provider
        return "";
    }
}
