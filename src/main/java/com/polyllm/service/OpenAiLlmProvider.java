package com.polyllm.service;

import com.polyllm.entities.ConversationMessage;
import com.polyllm.service.interfaces.LlmProvider;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenAiLlmProvider implements LlmProvider {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OpenAiLlmProvider.class);

    @Value("${LLM_OPENAI_API_KEY:}")
    private String openaiApiKey;

    @Override
    public String generateResponse(List<ConversationMessage> messages) {
        // TODO: Implement API call to the LLM provider
        return "";
    }
}
