package com.polyllm.service.interfaces;

import com.polyllm.entities.ConversationMessage;
import com.polyllm.exception.BadRequestException;

import java.util.List;

/**
 * Defines the contract for interacting with different LLM providers.
 * <p>
 * Implementations of this interface are responsible for generating responses
 * based on a list of conversation messages.
 * </p>
 */
public interface LlmProvider {

    /**
     * Generates a response based on the provided list of conversation messages.
     *
     * @param messages a list of {@link ConversationMessage} instances representing the conversation history;
     *                 must not be {@code null} or empty
     * @return the generated response as a {@link String}
     * @throws IllegalArgumentException if {@code messages} is {@code null} or empty
     * @throws BadRequestException      if an error occurs while generating the response
     */
    String generateResponse(List<ConversationMessage> messages) throws BadRequestException;
}

