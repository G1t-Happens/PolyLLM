package com.polyllm.controller;

import com.polyllm.entities.Conversation;
import com.polyllm.entities.ConversationMessage;

import com.polyllm.enums.LLMProvider;
import com.polyllm.exception.BadRequestException;
import com.polyllm.exception.ResourceNotFoundException;
import com.polyllm.service.interfaces.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${api.base-path}/conversation")
public class ConversationController {


    private final ConversationService conversationService;

    @Autowired
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping
    public Conversation createConversation(@RequestParam LLMProvider llmProvider, @RequestParam String llmModel) throws BadRequestException {
        return conversationService.createConversation(llmProvider, llmModel);
    }

    @GetMapping("/{id}")
    public Conversation getConversation(@PathVariable UUID id) throws ResourceNotFoundException {
        return conversationService.getConversation(id);
    }

    @PostMapping("/{id}/messages")
    public ConversationMessage addMessageToConversation(
            @PathVariable UUID id,
            @RequestParam String content) throws ResourceNotFoundException {
        return conversationService.addMessageToConversation(id, content);
    }

}

