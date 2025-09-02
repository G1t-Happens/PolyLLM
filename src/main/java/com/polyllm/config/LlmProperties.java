package com.polyllm.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * Configuration properties for integrating multiple LLM (Large Language Model) providers.
 * <p>
 * Each provider configuration (OpenAI, Gemini, Claude, Mistral) is optional and can be enabled via application properties or environment variables.
 * The {@code timeout} configuration is required to ensure proper HTTP client behavior.
 * <p>
 * Example YAML configuration:
 *
 * <pre>{@code
 * llm:
 *   openai:
 *     base-url: https://api.openai.com/v1          # Base URL for OpenAI
 *     api-key: your-api-key                        # API key (must not be checked into version control)
 *   timeout:
 *     connect: 3000                                # Connect timeout in milliseconds
 *     read: 5000                                   # Read timeout in milliseconds
 * }</pre>
 */
@Validated
@ConfigurationProperties(prefix = "llm")
public class LlmProperties {

    /**
     * Configuration for OpenAI client (optional).
     */
    @Valid
    private ApiClientConfig openai;

    /**
     * Configuration for Gemini client (optional).
     */
    @Valid
    private ApiClientConfig gemini;

    /**
     * Configuration for Claude client (optional).
     */
    @Valid
    private ApiClientConfig claude;

    /**
     * Configuration for Mistral client (optional).
     */
    @Valid
    private ApiClientConfig mistral;

    /**
     * Timeout settings for HTTP connections (required).
     */
    @NotNull
    @Valid
    private TimeoutConfig timeout;

    public ApiClientConfig getOpenai() {
        return openai;
    }

    public void setOpenai(ApiClientConfig openai) {
        this.openai = openai;
    }

    public ApiClientConfig getGemini() {
        return gemini;
    }

    public void setGemini(ApiClientConfig gemini) {
        this.gemini = gemini;
    }

    public ApiClientConfig getClaude() {
        return claude;
    }

    public void setClaude(ApiClientConfig claude) {
        this.claude = claude;
    }

    public ApiClientConfig getMistral() {
        return mistral;
    }

    public void setMistral(ApiClientConfig mistral) {
        this.mistral = mistral;
    }

    public TimeoutConfig getTimeout() {
        return timeout;
    }

    public void setTimeout(TimeoutConfig timeout) {
        this.timeout = timeout;
    }

    // --- Nested static classes ---

    /**
     * Configuration for a single API client.
     * <p>
     * Both fields are required if the client is enabled.
     */
    public static class ApiClientConfig {

        /**
         * The base URL for the API endpoint.
         * <p>
         * Example: {@code https://api.openai.com/v1}
         */
        private String baseUrl;

        /**
         * The API key used for authentication.
         * <p>
         * Must be provided via environment variable or secret.
         */
        private String apiKey;

        public String getBaseUrl() {
            return baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }
    }

    /**
     * HTTP timeout configuration for all LLM API clients.
     * <p>
     * Values are in milliseconds.
     */
    public static class TimeoutConfig {

        /**
         * Timeout for establishing a connection (in milliseconds).
         * Must be between 100 and 10,000 ms.
         */
        @NotNull
        @Min(100)
        @Max(10000)
        private Integer connect;

        /**
         * Timeout for waiting for a server response (in milliseconds).
         * Must be between 100 and 60,000 ms.
         */
        @NotNull
        @Min(100)
        @Max(60000)
        private Integer read;

        public Integer getConnect() {
            return connect;
        }

        public void setConnect(Integer connect) {
            this.connect = connect;
        }

        public Integer getRead() {
            return read;
        }

        public void setRead(Integer read) {
            this.read = read;
        }
    }
}
