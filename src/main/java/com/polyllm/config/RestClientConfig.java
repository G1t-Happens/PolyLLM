package com.polyllm.config;

import com.polyllm.enums.AuthHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.http.client.ClientHttpRequestFactoryBuilder;
import org.springframework.boot.http.client.ClientHttpRequestFactorySettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import com.polyllm.config.LlmProperties.ApiClientConfig;

import java.time.Duration;

/**
 * Configuration class that provides configured {@link RestClient} beans for
 * different LLM API clients with appropriate base URLs, authentication headers,
 * and timeout settings.
 */
@Configuration
public class RestClientConfig {

    private final LlmProperties llmProperties;

    /**
     * Constructs the configuration with the provided LLM properties.
     *
     * @param llmProperties the properties containing API client configs and timeouts
     */
    @Autowired
    public RestClientConfig(LlmProperties llmProperties) {
        this.llmProperties = llmProperties;
    }

    /**
     * Builds a {@link RestClient} configured with the specified API client settings,
     * authentication header, and timeout values.
     *
     * @param config     the API client configuration containing base URL, API key, and timeouts
     * @param authHeader the name of the HTTP header to use for authentication (e.g. "Authorization" or "x-api-key")
     * @return a configured {@link RestClient} instance
     * @throws IllegalStateException if the config, base URL, or API key is missing or blank
     */
    private RestClient buildClient(ApiClientConfig config, AuthHeader authHeader) {
        if (config == null) {
            throw new IllegalStateException("LLM ApiClientConfig must not be null");
        }
        if (config.getBaseUrl() == null || config.getBaseUrl().isBlank()) {
            throw new IllegalStateException("Base URL must be set for LLM client");
        }
        if (config.getApiKey() == null || config.getApiKey().isBlank()) {
            throw new IllegalStateException("API key must be set for LLM client");
        }

        // Extract timeouts from the config
        Duration connectTimeout = Duration.ofMillis(llmProperties.getTimeout().getConnect());
        Duration readTimeout = Duration.ofMillis(llmProperties.getTimeout().getRead());

        ClientHttpRequestFactory requestFactory = createRequestFactory(connectTimeout, readTimeout);

        RestClient.Builder builder = RestClient.builder()
                .baseUrl(config.getBaseUrl())
                .requestFactory(requestFactory)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        // Set authentication header appropriately
        String authValue = authHeader.isBearerToken()
                ? "Bearer " + config.getApiKey()
                : config.getApiKey();

        builder.defaultHeader(authHeader.getHeaderName(), authValue);

        return builder.build();
    }

    /**
     * Creates a {@link ClientHttpRequestFactory} configured with the given connect and read timeouts.
     * This factory is used by the {@link RestClient} to manage HTTP request settings.
     *
     * @param connectTimeout the connection timeout duration
     * @param readTimeout    the read (response) timeout duration
     * @return a configured {@link ClientHttpRequestFactory}
     */
    private ClientHttpRequestFactory createRequestFactory(Duration connectTimeout, Duration readTimeout) {
        ClientHttpRequestFactorySettings settings = ClientHttpRequestFactorySettings
                .defaults()
                .withConnectTimeout(connectTimeout)
                .withReadTimeout(readTimeout);

        // Detect the actual HTTP client implementation automatically (recommended)
        return ClientHttpRequestFactoryBuilder.detect().build(settings);
    }

    /**
     * Creates a {@link RestClient} bean configured for the OpenAI API client.
     *
     * @return the configured OpenAI RestClient
     */
    @Bean(name = "openAiClient")
    public RestClient openAiClient() {
        return buildClient(llmProperties.getOpenai(), AuthHeader.AUTHORIZATION);
    }

    /**
     * Creates a {@link RestClient} bean configured for the Gemini API client.
     *
     * @return the configured Gemini RestClient
     */
    @Bean(name = "geminiClient")
    public RestClient geminiClient() {
        return buildClient(llmProperties.getGemini(), AuthHeader.AUTHORIZATION);
    }

    /**
     * Creates a {@link RestClient} bean configured for the Claude API client.
     *
     * @return the configured Claude RestClient
     */
    @Bean(name = "claudeClient")
    public RestClient claudeClient() {
        return buildClient(llmProperties.getClaude(), AuthHeader.X_API_KEY);
    }

    /**
     * Creates a {@link RestClient} bean configured for the Mistral API client.
     *
     * @return the configured Mistral RestClient
     */
    @Bean(name = "mistralClient")
    public RestClient mistralClient() {
        return buildClient(llmProperties.getMistral(), AuthHeader.AUTHORIZATION);
    }
}
