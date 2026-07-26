package com.geniusreferrals.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.Map;

public class LiveApiSmokeTest {
    private static int passCount = 0;
    private static int failCount = 0;
    private static final ObjectMapper mapper = new ObjectMapper();
    private static GeniusReferralsClient sdk;
    private static String accountSlug;

    public static void main(String[] args) {
        String token = System.getenv("GR_API_TOKEN");
        String slug = System.getenv("GR_ACCOUNT_SLUG");
        if (token == null || token.isEmpty()) {
            System.out.println("SKIP: GR_API_TOKEN is not set");
            return;
        }
        if (slug == null || slug.isEmpty()) {
            slug = "test1000";
        }
        accountSlug = slug;
        sdk = new GeniusReferralsClient(token);

        // Reads
        check("authentication", () -> sdk.authentications.getAuthentication());
        check("root", () -> sdk.roots.getRoot());
        check("accounts list", () -> sdk.accounts.getAccounts(1, 10, "json"));
        check("account detail", () -> sdk.accounts.getAccount(accountSlug));
        check("advocates list", () -> sdk.advocates.getAdvocates(accountSlug, 1, 5));
        check("bonuses list", () -> sdk.bonuses.getBonuses(accountSlug, 1, 5));
        check("campaigns list", () -> sdk.campaigns.getCampaigns(accountSlug, 1, 5));
        check("products list", () -> sdk.products.getProducts(accountSlug, 1, 5));
        check("tags list", () -> sdk.tags.getTags(accountSlug, 1, 5));
        check("vouchers list", () -> sdk.vouchers.getVouchers(accountSlug, 1, 5));
        check("widgets packages list", () -> sdk.widgetsPackages.getWidgetsPackages(accountSlug, 1, 5));
        check("1099 tax report", () -> sdk.reports.get1099TaxReport(accountSlug, 2025));
        check("utility payment methods", () -> sdk.utilities.getPaymentMethodsList(1, 10));
        check("utility currencies", () -> sdk.utilities.getCurrencies(1, 10));

        // Tags CRUD
        doTagsCrud();

        // Advocates CRUD
        doAdvocatesCrud();

        // Vouchers CRUD
        doVouchersCrud();

        // Products CRUD
        doProductsCrud();

        System.out.println("\n--- SUMMARY ---");
        System.out.println("Pass: " + passCount + ", Fail: " + failCount);
        if (failCount > 0) System.exit(1);
    }

    private static void doTagsCrud() {
        final String tagName = "bolt-smoke-tag-" + System.currentTimeMillis();
        final String[] tagSlug = {null};
        try {
            String created = sdk.tags.createTag(accountSlug, Map.of("tag", Map.of("name", tagName, "description", "Bolt smoke", "color", "#123456")));
            System.out.println("tags create: PASS");
            passCount++;
            tagSlug[0] = extractField(created, "slug");
            final String ts = tagSlug[0];
            check("tags get", () -> sdk.tags.getTag(accountSlug, ts));
            runVoid("tags update", () -> sdk.tags.updateTag(accountSlug, ts, Map.of("tag", Map.of("name", tagName, "description", "Updated", "color", "#654321"))));
            runVoid("tags delete", () -> sdk.tags.deleteTag(accountSlug, ts));
            tagSlug[0] = null;
        } catch (Exception e) {
            fail("tags CRUD", e);
            if (tagSlug[0] != null) { try { sdk.tags.deleteTag(accountSlug, tagSlug[0]); } catch (Exception ignored) {} }
        }
    }

    private static void doAdvocatesCrud() {
        final String suffix = String.valueOf(System.currentTimeMillis());
        final String[] advocateToken = {null};
        try {
            String created = sdk.advocates.postAdvocate(accountSlug, Map.of("advocate", Map.of(
                "firstname", "Bolt", "lastname", "Smoke",
                "email", "bolt-smoke-" + suffix + "@example.com",
                "payout_threshold", 10, "can_refer", 1,
                "currency_code", "USD", "status", "active")));
            System.out.println("advocates create: PASS");
            passCount++;
            advocateToken[0] = extractField(created, "token");
            final String at = advocateToken[0];
            check("advocates get", () -> sdk.advocates.getAdvocate(accountSlug, at));
            check("advocates share-links", () -> sdk.advocates.getAdvocateShareLinks(accountSlug, at));
            runVoid("advocates patch", () -> sdk.advocates.patchAdvocate(accountSlug, at, Map.of("firstname", "Bolted", "status", "active")));
            runVoid("advocates delete", () -> sdk.advocates.deleteAdvocate(accountSlug, at));
            advocateToken[0] = null;
        } catch (Exception e) {
            fail("advocates CRUD", e);
            if (advocateToken[0] != null) { try { sdk.advocates.deleteAdvocate(accountSlug, advocateToken[0]); } catch (Exception ignored) {} }
        }
    }

    private static void doVouchersCrud() {
        final String voucherCode = "BOLT-" + System.currentTimeMillis();
        final String[] voucherId = {null};
        try {
            String created = sdk.vouchers.createVoucher(accountSlug, Map.of("voucher", Map.of(
                "code", voucherCode, "value", 9.99, "currency_code", "USD", "status", "available")));
            System.out.println("vouchers create: PASS");
            passCount++;
            voucherId[0] = extractField(created, "id");
            final String vid = voucherId[0];
            check("vouchers get", () -> sdk.vouchers.getVoucher(accountSlug, vid));
            runVoid("vouchers delete", () -> sdk.vouchers.deleteVoucher(accountSlug, vid));
            voucherId[0] = null;
        } catch (Exception e) {
            fail("vouchers CRUD", e);
            if (voucherId[0] != null) { try { sdk.vouchers.deleteVoucher(accountSlug, voucherId[0]); } catch (Exception ignored) {} }
        }
    }

    private static void doProductsCrud() {
        final String psuffix = String.valueOf(System.currentTimeMillis());
        final String[] productSlug = {null};
        try {
            String created = sdk.products.createProduct(accountSlug, Map.of("product", Map.of(
                "title", "Bolt Smoke Product " + psuffix,
                "description_html", "Bolt live smoke suite",
                "status", "open",
                "images", new String[]{"https://example.com/product.png"},
                "variants", new Object[]{Map.of(
                    "title", "Variant " + psuffix,
                    "inventory_quantity", 5,
                    "barcode", psuffix,
                    "sku", psuffix,
                    "features", "Smoke variant",
                    "price", Map.of("currency_code", "USD", "amount", "19.99"))})));
            System.out.println("products create: PASS");
            passCount++;
            productSlug[0] = extractField(created, "slug");
            final String ps = productSlug[0];
            check("products get", () -> sdk.products.getProduct(accountSlug, ps));
            runVoid("products update", () -> sdk.products.updateProduct(accountSlug, ps, Map.of("product", Map.of(
                "title", "Bolt Smoke Product " + psuffix + " Updated",
                "description_html", "Updated by Bolt smoke",
                "status", "open",
                "images", new String[]{"https://example.com/product-updated.png"}))));
            runVoid("products delete", () -> sdk.products.deleteProduct(accountSlug, ps));
            productSlug[0] = null;
        } catch (Exception e) {
            fail("products CRUD", e);
            if (productSlug[0] != null) { try { sdk.products.deleteProduct(accountSlug, productSlug[0]); } catch (Exception ignored) {} }
        }
    }

    // ── Helpers ──

    interface GetString { String run() throws Exception; }
    interface Action { void run() throws Exception; }

    private static void check(String name, GetString action) {
        try {
            action.run();
            System.out.println(name + ": PASS");
            passCount++;
        } catch (Exception e) {
            System.out.println(name + ": FAIL - " + e.getMessage());
            failCount++;
        }
    }

    private static void runVoid(String name, Action action) {
        try {
            action.run();
            System.out.println(name + ": PASS");
            passCount++;
        } catch (Exception e) {
            System.out.println(name + ": FAIL - " + e.getMessage());
            failCount++;
        }
    }

    private static void fail(String name, Exception e) {
        System.out.println(name + ": FAIL - " + e.getMessage());
        failCount++;
    }

    private static String extractField(String json, String field) {
        try {
            JsonNode value = mapper.readTree(json).findValue(field);
            if (value == null || value.isNull()) {
                throw new IllegalStateException("Missing field in live API response: " + field);
            }
            return value.asText();
        } catch (Exception e) {
            throw new IllegalStateException("Could not parse live API response field `" + field + "`: " + e.getMessage(), e);
        }
    }
}
