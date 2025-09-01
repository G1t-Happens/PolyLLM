package com.polyllm.enums;

/**
 * Represents the role of a message participant in a conversation.
 * Typically used to distinguish between the user, the assistant (LLM),
 * and optional system instructions.
 */
public enum Role {

    /**
     * The role representing the end-user interacting with the system.
     */
    USER,

    /**
     * The role representing the assistant (LLM) generating responses.
     */
    ASSISTANT,

    /**
     * The role used for system-level messages, such as initial instructions or constraints.
     */
    SYSTEM
}
