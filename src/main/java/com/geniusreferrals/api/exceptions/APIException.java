package com.geniusreferrals.api.exceptions;

public class APIException extends RuntimeException {
    private final int statusCode;
    private final String responseBody;

    public APIException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public APIException(String message) {
        this(message, 0, null);
    }

    public int getStatusCode() { return statusCode; }
    public String getResponseBody() { return responseBody; }
}
