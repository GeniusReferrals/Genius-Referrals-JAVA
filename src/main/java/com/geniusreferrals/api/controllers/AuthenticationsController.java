package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

public class AuthenticationsController {
    private final GRClient client;
    public AuthenticationsController(GRClient client) { this.client = client; }

    public String getAuthentication() throws APIException {
        return client.get("/test-authentication", null);
    }
}
