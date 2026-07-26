package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

public class RootsController {
    private final GRClient client;
    public RootsController(GRClient client) { this.client = client; }

    public String getRoot() throws APIException {
        return client.get("/", null);
    }
}
