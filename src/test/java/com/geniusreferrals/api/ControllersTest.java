package com.geniusreferrals.api;

import com.geniusreferrals.api.exceptions.APIException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ControllersTest {

    private MockWebServer server;
    private GeniusReferralsClient sdk;

    @BeforeEach
    void setup() throws IOException {
        server = new MockWebServer();
        server.start();
        String baseUri = server.url("").toString().replaceAll("/$", "");
        sdk = new GeniusReferralsClient("test-token", baseUri, "application/json");
    }

    @AfterEach
    void teardown() throws IOException {
        server.shutdown();
    }

    private void enqueue(int code, String body) {
        server.enqueue(new MockResponse().setResponseCode(code).setBody(body));
    }

    private RecordedRequest takeRequest() throws InterruptedException {
        return server.takeRequest();
    }

    private void assertAuthHeader(RecordedRequest req) {
        assertEquals("test-token", req.getHeader("X-Auth-Token"));
        assertEquals("application/json", req.getHeader("Accept"));
    }

    // ── Authentications ──
    @Test void testGetAuthentication() throws Exception {
        enqueue(200, "{\"data\":\"ok\"}");
        assertNotNull(sdk.authentications.getAuthentication());
        RecordedRequest r = takeRequest();
        assertEquals("GET", r.getMethod());
        assertEquals("/test-authentication", r.getPath());
        assertAuthHeader(r);
    }

    // ── Roots ──
    @Test void testGetRoot() throws Exception {
        enqueue(200, "{\"data\":\"ok\"}");
        assertNotNull(sdk.roots.getRoot());
        assertEquals("GET", takeRequest().getMethod());
    }

    // ── Accounts ──
    @Test void testGetAccounts() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.accounts.getAccounts(1, 10, "json"));
        RecordedRequest r = takeRequest();
        assertTrue(r.getPath().contains("page=1"));
        assertTrue(r.getPath().contains("limit=10"));
    }

    @Test void testGetAccount() throws Exception {
        enqueue(200, "{\"slug\":\"test1000\"}");
        assertNotNull(sdk.accounts.getAccount("test1000"));
        assertTrue(takeRequest().getPath().contains("/accounts/test1000"));
    }

    @Test void testCreateAccount() throws Exception {
        enqueue(201, "{\"slug\":\"new\"}");
        Map<String, Object> body = Map.of("account", Map.of("name", "Test"));
        assertNotNull(sdk.accounts.createAccount(body));
        assertEquals("POST", takeRequest().getMethod());
    }

    @Test void testUpdateAccount() throws Exception {
        enqueue(204, "");
        Map<String, Object> body = Map.of("account", Map.of("name", "Updated"));
        sdk.accounts.updateAccount("test1000", body);
        assertEquals("PUT", takeRequest().getMethod());
    }

    @Test void testDeleteAccount() throws Exception {
        enqueue(204, "");
        sdk.accounts.deleteAccount("test1000");
        assertEquals("DELETE", takeRequest().getMethod());
    }

    // ── Advocates ──
    @Test void testGetAdvocates() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.advocates.getAdvocates("test1000", 1, 5));
        assertTrue(takeRequest().getPath().contains("/accounts/test1000/advocates"));
    }

    @Test void testGetAdvocate() throws Exception {
        enqueue(200, "{\"token\":\"abc\"}");
        assertNotNull(sdk.advocates.getAdvocate("test1000", "abc"));
    }

    @Test void testPostAdvocate() throws Exception {
        enqueue(201, "{\"token\":\"abc\"}");
        Map<String, Object> body = Map.of("advocate", Map.of("firstname", "Test"));
        assertNotNull(sdk.advocates.postAdvocate("test1000", body));
        assertEquals("POST", takeRequest().getMethod());
    }

    @Test void testPatchAdvocate() throws Exception {
        enqueue(204, "");
        Map<String, Object> body = Map.of("firstname", "Updated");
        sdk.advocates.patchAdvocate("test1000", "abc", body);
        assertEquals("PATCH", takeRequest().getMethod());
    }

    @Test void testDeleteAdvocate() throws Exception {
        enqueue(204, "");
        sdk.advocates.deleteAdvocate("test1000", "abc");
        assertEquals("DELETE", takeRequest().getMethod());
    }

    @Test void testGetAdvocateShareLinks() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.advocates.getAdvocateShareLinks("test1000", "abc"));
        takeRequest();
    }

    @Test void testGetAdvocatePaymentMethods() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.advocates.getAdvocatePaymentMethods("test1000", "abc"));
        takeRequest();
    }

    @Test void testPostAdvocatePaymentMethod() throws Exception {
        enqueue(201, "{\"id\":1}");
        Map<String, Object> body = Map.of("payment_method", Map.of("type", "paypal"));
        assertNotNull(sdk.advocates.postAdvocatePaymentMethod("test1000", "abc", body));
        takeRequest();
    }

    // ── Bonuses ──
    @Test void testGetBonuses() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.bonuses.getBonuses("test1000", 1, 5));
        takeRequest();
    }

    @Test void testPostBonus() throws Exception {
        enqueue(201, "{\"id\":1}");
        Map<String, Object> body = Map.of("bonus", Map.of("amount", 10));
        assertNotNull(sdk.bonuses.postBonus("test1000", body));
        assertEquals("POST", takeRequest().getMethod());
    }

    @Test void testForceBonus() throws Exception {
        enqueue(201, "{\"id\":1}");
        Map<String, Object> body = Map.of("bonus", Map.of("amount", 10));
        assertNotNull(sdk.bonuses.forceBonus("test1000", body));
        assertTrue(takeRequest().getPath().contains("/bonuses/force"));
    }

    @Test void testDeleteBonus() throws Exception {
        enqueue(204, "");
        sdk.bonuses.deleteBonus("test1000", "123");
        assertEquals("DELETE", takeRequest().getMethod());
    }

    @Test void testPatchBonus() throws Exception {
        enqueue(204, "");
        Map<String, Object> body = Map.of("status", "approved");
        sdk.bonuses.patchBonus("test1000", "123", body);
        assertEquals("PATCH", takeRequest().getMethod());
    }

    @Test void testGetBonusTags() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.bonuses.getBonusTags("test1000", "123"));
        takeRequest();
    }

    @Test void testAddBonusTag() throws Exception {
        enqueue(201, "{\"slug\":\"tag1\"}");
        Map<String, Object> body = Map.of("tag", Map.of("name", "tag1"));
        assertNotNull(sdk.bonuses.addBonusTag("test1000", "123", body));
        takeRequest();
    }

    @Test void testRemoveBonusTag() throws Exception {
        enqueue(204, "");
        sdk.bonuses.removeBonusTag("test1000", "123", "tag1");
        assertEquals("DELETE", takeRequest().getMethod());
    }

    // ── Campaigns ──
    @Test void testGetCampaigns() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.campaigns.getCampaigns("test1000", 1, 5));
        takeRequest();
    }

    @Test void testGetCampaign() throws Exception {
        enqueue(200, "{\"slug\":\"camp1\"}");
        assertNotNull(sdk.campaigns.getCampaign("test1000", "camp1"));
        takeRequest();
    }

    // ── Products ──
    @Test void testGetProducts() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.products.getProducts("test1000", 1, 5));
        takeRequest();
    }

    @Test void testGetProduct() throws Exception {
        enqueue(200, "{\"slug\":\"prod1\"}");
        assertNotNull(sdk.products.getProduct("test1000", "prod1"));
        takeRequest();
    }

    @Test void testCreateProduct() throws Exception {
        enqueue(201, "{\"slug\":\"prod1\"}");
        Map<String, Object> body = Map.of("product", Map.of("title", "Test"));
        assertNotNull(sdk.products.createProduct("test1000", body));
        takeRequest();
    }

    @Test void testUpdateProduct() throws Exception {
        enqueue(204, "");
        Map<String, Object> body = Map.of("product", Map.of("title", "Updated"));
        sdk.products.updateProduct("test1000", "prod1", body);
        assertEquals("PUT", takeRequest().getMethod());
    }

    @Test void testDeleteProduct() throws Exception {
        enqueue(204, "");
        sdk.products.deleteProduct("test1000", "prod1");
        assertEquals("DELETE", takeRequest().getMethod());
    }

    @Test void testGetProductVariants() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.products.getProductVariants("test1000", "prod1"));
        takeRequest();
    }

    @Test void testCreateProductVariant() throws Exception {
        enqueue(201, "{\"id\":1}");
        Map<String, Object> body = Map.of("variant", Map.of("title", "V1"));
        assertNotNull(sdk.products.createProductVariant("test1000", "prod1", body));
        takeRequest();
    }

    @Test void testDeleteProductVariant() throws Exception {
        enqueue(204, "");
        sdk.products.deleteProductVariant("test1000", "prod1", "1");
        assertEquals("DELETE", takeRequest().getMethod());
    }

    // ── Redemption Requests ──
    @Test void testGetRedemptionRequests() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.redemptionRequests.getRedemptionRequests("test1000", 1, 5));
        takeRequest();
    }

    @Test void testPostRedemptionRequest() throws Exception {
        enqueue(201, "{\"id\":1}");
        Map<String, Object> body = Map.of("redemption_request", Map.of("amount", 10));
        assertNotNull(sdk.redemptionRequests.postRedemptionRequest("test1000", body));
        takeRequest();
    }

    @Test void testPatchRedemptionRequest() throws Exception {
        enqueue(204, "");
        Map<String, Object> body = Map.of("status", "approved");
        sdk.redemptionRequests.patchRedemptionRequest("test1000", "1", body);
        assertEquals("PATCH", takeRequest().getMethod());
    }

    @Test void testRedeemRedemptionRequest() throws Exception {
        enqueue(204, "");
        sdk.redemptionRequests.redeemRedemptionRequest("test1000", "1");
        assertTrue(takeRequest().getPath().contains("/redemption"));
    }

    // ── Referrals ──
    @Test void testGetReferrals() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.referrals.getReferrals("test1000", "abc", 1, 5));
        takeRequest();
    }

    @Test void testPostReferral() throws Exception {
        enqueue(201, "{\"id\":1}");
        Map<String, Object> body = Map.of("referral", Map.of("url", "http://example.com"));
        assertNotNull(sdk.referrals.postReferral("test1000", "abc", body));
        takeRequest();
    }

    @Test void testDeleteReferral() throws Exception {
        enqueue(204, "");
        sdk.referrals.deleteReferral("test1000", "abc", "1");
        assertEquals("DELETE", takeRequest().getMethod());
    }

    // ── Reports ──
    @Test void testGetBonusesDailyGiven() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.reports.getBonusesDailyGiven("test1000", "2026-01-01", "2026-01-31", null));
        assertTrue(takeRequest().getPath().contains("account_slug=test1000"));
    }

    @Test void testGetRevenue() throws Exception {
        enqueue(200, "{\"data\":1000.00}");
        assertNotNull(sdk.reports.getRevenue("test1000", "2026-01-01", "2026-01-31"));
        takeRequest();
    }

    @Test void testGet1099TaxReport() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.reports.get1099TaxReport("test1000", 2025));
        assertTrue(takeRequest().getPath().contains("year=2025"));
    }

    // ── Tags ──
    @Test void testGetTags() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.tags.getTags("test1000", 1, 5));
        takeRequest();
    }

    @Test void testGetTag() throws Exception {
        enqueue(200, "{\"slug\":\"tag1\"}");
        assertNotNull(sdk.tags.getTag("test1000", "tag1"));
        takeRequest();
    }

    @Test void testCreateTag() throws Exception {
        enqueue(201, "{\"slug\":\"tag1\"}");
        Map<String, Object> body = Map.of("tag", Map.of("name", "tag1"));
        assertNotNull(sdk.tags.createTag("test1000", body));
        takeRequest();
    }

    @Test void testUpdateTag() throws Exception {
        enqueue(204, "");
        Map<String, Object> body = Map.of("tag", Map.of("name", "Updated"));
        sdk.tags.updateTag("test1000", "tag1", body);
        assertEquals("PUT", takeRequest().getMethod());
    }

    @Test void testDeleteTag() throws Exception {
        enqueue(204, "");
        sdk.tags.deleteTag("test1000", "tag1");
        assertEquals("DELETE", takeRequest().getMethod());
    }

    // ── Vouchers ──
    @Test void testGetVouchers() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.vouchers.getVouchers("test1000", 1, 5));
        takeRequest();
    }

    @Test void testGetVoucher() throws Exception {
        enqueue(200, "{\"id\":1}");
        assertNotNull(sdk.vouchers.getVoucher("test1000", "1"));
        takeRequest();
    }

    @Test void testCreateVoucher() throws Exception {
        enqueue(201, "{\"id\":1}");
        Map<String, Object> body = Map.of("voucher", Map.of("code", "V1"));
        assertNotNull(sdk.vouchers.createVoucher("test1000", body));
        takeRequest();
    }

    @Test void testPatchVoucher() throws Exception {
        enqueue(204, "");
        Map<String, Object> body = Map.of("status", "available");
        sdk.vouchers.patchVoucher("test1000", "1", body);
        assertEquals("PATCH", takeRequest().getMethod());
    }

    @Test void testDeleteVoucher() throws Exception {
        enqueue(204, "");
        sdk.vouchers.deleteVoucher("test1000", "1");
        assertEquals("DELETE", takeRequest().getMethod());
    }

    // ── Widgets Packages ──
    @Test void testGetWidgetsPackages() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.widgetsPackages.getWidgetsPackages("test1000", 1, 5));
        takeRequest();
    }

    @Test void testGetWidgetsPackage() throws Exception {
        enqueue(200, "{\"slug\":\"wp1\"}");
        assertNotNull(sdk.widgetsPackages.getWidgetsPackage("test1000", "wp1"));
        takeRequest();
    }

    @Test void testCreateWidgetsPackage() throws Exception {
        enqueue(201, "{\"slug\":\"wp1\"}");
        Map<String, Object> body = Map.of("widgets_package", Map.of("name", "WP1"));
        assertNotNull(sdk.widgetsPackages.createWidgetsPackage("test1000", body));
        takeRequest();
    }

    @Test void testDeleteWidgetsPackage() throws Exception {
        enqueue(204, "");
        sdk.widgetsPackages.deleteWidgetsPackage("test1000", "wp1");
        assertEquals("DELETE", takeRequest().getMethod());
    }

    @Test void testGetWidgets() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.widgetsPackages.getWidgets("test1000", "wp1"));
        takeRequest();
    }

    @Test void testCreateWidget() throws Exception {
        enqueue(201, "{\"id\":1}");
        Map<String, Object> body = Map.of("widget", Map.of("type", "referral"));
        assertNotNull(sdk.widgetsPackages.createWidget("test1000", "wp1", body));
        takeRequest();
    }

    // ── Utilities ──
    @Test void testGetCurrencies() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.utilities.getCurrencies(1, 10));
        takeRequest();
    }

    @Test void testGetPaymentMethodsList() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.utilities.getPaymentMethodsList(1, 10));
        takeRequest();
    }

    @Test void testGetReferralOrigins() throws Exception {
        enqueue(200, "{\"data\":[]}");
        assertNotNull(sdk.utilities.getReferralOrigins(1, 10));
        takeRequest();
    }

    // ── Error handling ──
    @Test void test401ThrowsAuthError() throws Exception {
        enqueue(401, "{\"message\":\"unauthorized\"}");
        APIException ex = assertThrows(APIException.class, () -> sdk.accounts.getAccounts(1, 1, "json"));
        assertTrue(ex.getMessage().contains("not authenticated"));
        takeRequest(); // drain the request from the queue
    }

    @Test void test403ThrowsAuthzError() throws Exception {
        enqueue(403, "{\"message\":\"forbidden\"}");
        APIException ex = assertThrows(APIException.class, () -> sdk.accounts.getAccounts(1, 1, "json"));
        assertTrue(ex.getMessage().contains("not authorized"));
        takeRequest(); // drain the request from the queue
    }

    @Test void test404ThrowsNotFoundError() throws Exception {
        enqueue(404, "{\"message\":\"not found\"}");
        APIException ex = assertThrows(APIException.class, () -> sdk.accounts.getAccount("nonexistent"));
        assertTrue(ex.getMessage().contains("not found"));
        takeRequest(); // drain the request from the queue
    }
}
