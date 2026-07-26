package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class ReportsController {
    private final GRClient client;
    public ReportsController(GRClient client) { this.client = client; }

    public String getBonusesDailyGiven(String accountSlug, String startDate, String endDate, String advocateToken) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("account_slug", accountSlug);
        qp.put("start_date", startDate);
        qp.put("end_date", endDate);
        if (advocateToken != null) qp.put("advocate_token", advocateToken);
        return client.get("/reports/bonuses-daily-given", qp);
    }

    public String getBonusesSummaryPerOrigin(String accountSlug, String startDate, String endDate, String advocateToken) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("account_slug", accountSlug);
        qp.put("start_date", startDate);
        qp.put("end_date", endDate);
        if (advocateToken != null) qp.put("advocate_token", advocateToken);
        return client.get("/reports/bonuses-summary-per-origin", qp);
    }

    public String getClickDailyParticipation(String accountSlug, String startDate, String endDate, String advocateToken) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("account_slug", accountSlug);
        qp.put("start_date", startDate);
        qp.put("end_date", endDate);
        if (advocateToken != null) qp.put("advocate_token", advocateToken);
        return client.get("/reports/click-daily-participation", qp);
    }

    public String getReferralDailyParticipation(String accountSlug, String startDate, String endDate, String advocateToken) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("account_slug", accountSlug);
        qp.put("start_date", startDate);
        qp.put("end_date", endDate);
        if (advocateToken != null) qp.put("advocate_token", advocateToken);
        return client.get("/reports/referral-daily-participation", qp);
    }

    public String getReferralsSummaryPerOrigin(String accountSlug, String startDate, String endDate, String advocateToken) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("account_slug", accountSlug);
        qp.put("start_date", startDate);
        qp.put("end_date", endDate);
        if (advocateToken != null) qp.put("advocate_token", advocateToken);
        return client.get("/reports/referrals-summary-per-origin", qp);
    }

    public String getShareDailyParticipation(String accountSlug, String startDate, String endDate, String advocateToken) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("account_slug", accountSlug);
        qp.put("start_date", startDate);
        qp.put("end_date", endDate);
        if (advocateToken != null) qp.put("advocate_token", advocateToken);
        return client.get("/reports/share-daily-participation", qp);
    }

    public String getTopAdvocates(String accountSlug, String startDate, String endDate) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("account_slug", accountSlug);
        qp.put("start_date", startDate);
        qp.put("end_date", endDate);
        return client.get("/reports/top-advocates", qp);
    }

    public String getRevenue(String accountSlug, String startDate, String endDate) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("account_slug", accountSlug);
        qp.put("start_date", startDate);
        qp.put("end_date", endDate);
        return client.get("/reports/revenue", qp);
    }

    public String get1099TaxReport(String accountSlug, int year) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("account_slug", accountSlug);
        qp.put("year", year);
        return client.get("/reports/1099-tax-report", qp);
    }
}
