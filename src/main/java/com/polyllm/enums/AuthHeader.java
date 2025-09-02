package com.polyllm.enums;

/**
 * Enum representing supported HTTP authentication headers.
 */
public enum AuthHeader {
    /**
     * Standard-bearer token header: Authorization: Bearer xxx
     */
    AUTHORIZATION("Authorization", true),

    /**
     * API key header (e.g. Claude): x-api-key: xxx
     */
    X_API_KEY("x-api-key", false);

    private final String headerName;
    private final boolean bearerToken;

    AuthHeader(String headerName, boolean bearerToken) {
        this.headerName = headerName;
        this.bearerToken = bearerToken;
    }

    public String getHeaderName() {
        return headerName;
    }

    public boolean isBearerToken() {
        return bearerToken;
    }
}

