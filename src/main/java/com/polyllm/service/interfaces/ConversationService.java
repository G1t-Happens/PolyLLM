package com.polyllm.service.interfaces;

import com.polyllm.entities.Conversation;
import com.polyllm.entities.ConversationMessage;

import com.polyllm.exception.ResourceNotFoundException;


import java.util.List;
import java.util.UUID;

/**
 * Provides operations for managing conversations and their messages.
 * <p>
 * This service allows for the creation, retrieval, and management of conversations and messages.
 * It serves as the primary interface for interacting with conversation data.
 * </p>
 *
 * @since 1.0
 */
public interface ConversationService {

    /**
     * Creates a new conversation with the specified LLM provider.
     *
     * @param llmProvider the name of the LLM provider associated with the conversation; must not be {@code null}
     * @return the created {@link Conversation} instance
     * @throws IllegalArgumentException if {@code llmProvider} is {@code null}
     */
    Conversation createConversation(String llmProvider);

    /**
     * Retrieves a conversation by its unique identifier.
     *
     * @param id the unique identifier of the conversation; must not be {@code null}
     * @return the {@link Conversation} instance with the specified ID
     * @throws IllegalArgumentException      if {@code id} is {@code null}
     * @throws ResourceNotFoundException if no conversation with the specified ID exists
     */
    Conversation getConversation(UUID id) throws ResourceNotFoundException;

    /**
     * Retrieves all messages associated with a specific conversation.
     *
     * @param conversationId the unique identifier of the conversation; must not be {@code null}
     * @return a list of {@link ConversationMessage} instances associated with the specified conversation
     * @throws IllegalArgumentException      if {@code conversationId} is {@code null}
     * @throws ResourceNotFoundException if no conversation with the specified ID exists
     */
    List<ConversationMessage> getMessagesForConversation(UUID conversationId) throws ResourceNotFoundException;

    /**
     * Adds a new message to an existing conversation.
     *
     * @param conversationId the unique identifier of the conversation; must not be {@code null}
     * @param content        the content of the message; must not be {@code null}
     * @return the created {@link ConversationMessage} instance
     * @throws IllegalArgumentException      if any of the parameters are {@code null}
     * @throws ResourceNotFoundException if no conversation with the specified ID exists
     */
    ConversationMessage addMessageToConversation(UUID conversationId, String content) throws ResourceNotFoundException;
}
