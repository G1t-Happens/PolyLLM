package com.polyllm.enums;

/**
 * Enum representing supported Large Language Model (LLM) providers.
 * <p>
 * Each provider corresponds to a distinct LLM platform with its own APIs and model offerings.
 * This enum is used to route conversation requests to the appropriate backend service.
 */
public enum LLMProvider {

    /**
     * OpenAI's LLM platform (e.g., ChatGPT, GPT-3.5, GPT-4, GPT-4o).
     */
    OPENAI,

    /**
     * Google's Gemini LLM platform (e.g., Gemini Pro, Gemini 1.5).
     */
    GEMINI,

    /**
     * Anthropic's Claude LLM platform (e.g., Claude 3 Sonnet, Opus).
     */
    CLAUDE,

    /**
     * Mistral's open LLM platform (e.g., Mistral 7B, Mixtral).
     */
    MISTRAL
}

