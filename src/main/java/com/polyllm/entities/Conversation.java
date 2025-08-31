package com.polyllm.entities;

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

    @Column(name = "llm_provider", nullable = false)
    private String llmProvider;

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ConversationMessage> messages;

    public UUID getId() {
        return id;
    }

    public String getLlmProvider() {
        return llmProvider;
    }

    public void setLlmProvider(String llmProvider) {
        this.llmProvider = llmProvider;
    }

    public List<ConversationMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ConversationMessage> messages) {
        this.messages = messages;
    }
}

