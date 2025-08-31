package com.polyllm.service;

import com.polyllm.entities.ConversationMessage;
import com.polyllm.exception.BadRequestException;
import com.polyllm.service.interfaces.LlmProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LlmProviderImpl implements LlmProvider {
    @Override
    public String generateResponse(List<ConversationMessage> messages) throws BadRequestException {
        return "";
    }
}
