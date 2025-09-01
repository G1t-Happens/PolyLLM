package com.polyllm.entities;

import com.polyllm.enums.LLMProvider;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "conversations")
public class Conversation extends AbstractEntity {


    @Serial
    private static final long serialVersionUID = 8276335340070907405L;

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "llm_provider", nullable = false)
    private LLMProvider llmProvider;

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConversationMessage> messages;

    public UUID getId() {
        return id;
    }

    public LLMProvider getLlmProvider() {
        return llmProvider;
    }

    public void setLlmProvider(LLMProvider llmProvider) {
        this.llmProvider = llmProvider;
    }

    public List<ConversationMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ConversationMessage> messages) {
        this.messages = messages;
    }
}

