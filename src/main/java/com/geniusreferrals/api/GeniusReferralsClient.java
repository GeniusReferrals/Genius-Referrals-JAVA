package com.geniusreferrals.api;

import com.geniusreferrals.api.controllers.*;

public class GeniusReferralsClient {
    private final GRClient client;

    public final AccountsController accounts;
    public final AdvocatesController advocates;
    public final AuthenticationsController authentications;
    public final BonusesController bonuses;
    public final CampaignsController campaigns;
    public final ProductsController products;
    public final RedemptionRequestsController redemptionRequests;
    public final ReferralsController referrals;
    public final ReportsController reports;
    public final RootsController roots;
    public final TagsController tags;
    public final UtilitiesController utilities;
    public final VouchersController vouchers;
    public final WidgetsPackagesController widgetsPackages;

    public GeniusReferralsClient(String apiToken) {
        this.client = new GRClient(apiToken);
        this.accounts = new AccountsController(client);
        this.advocates = new AdvocatesController(client);
        this.authentications = new AuthenticationsController(client);
        this.bonuses = new BonusesController(client);
        this.campaigns = new CampaignsController(client);
        this.products = new ProductsController(client);
        this.redemptionRequests = new RedemptionRequestsController(client);
        this.referrals = new ReferralsController(client);
        this.reports = new ReportsController(client);
        this.roots = new RootsController(client);
        this.tags = new TagsController(client);
        this.utilities = new UtilitiesController(client);
        this.vouchers = new VouchersController(client);
        this.widgetsPackages = new WidgetsPackagesController(client);
    }

    public GeniusReferralsClient(String apiToken, String baseUri, String contentType) {
        this.client = new GRClient(apiToken, baseUri, contentType);
        this.accounts = new AccountsController(client);
        this.advocates = new AdvocatesController(client);
        this.authentications = new AuthenticationsController(client);
        this.bonuses = new BonusesController(client);
        this.campaigns = new CampaignsController(client);
        this.products = new ProductsController(client);
        this.redemptionRequests = new RedemptionRequestsController(client);
        this.referrals = new ReferralsController(client);
        this.reports = new ReportsController(client);
        this.roots = new RootsController(client);
        this.tags = new TagsController(client);
        this.utilities = new UtilitiesController(client);
        this.vouchers = new VouchersController(client);
        this.widgetsPackages = new WidgetsPackagesController(client);
    }

    public GRClient getClient() { return client; }
}
