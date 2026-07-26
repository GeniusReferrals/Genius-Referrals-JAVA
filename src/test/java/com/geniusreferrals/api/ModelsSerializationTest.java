package com.geniusreferrals.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geniusreferrals.api.models.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelsSerializationTest {
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void advocateFormSerializesWithAdvocateWrapper() throws Exception {
        Advocate advocate = new Advocate();
        advocate.firstname = "Ada";
        advocate.lastname = "Lovelace";
        advocate.email = "ada@example.com";
        advocate.payoutThreshold = 25;
        advocate.canRefer = true;
        advocate.currencyCode = "USD";
        advocate.status = "active";

        JsonNode json = mapper.valueToTree(new AdvocateForm(advocate));

        assertTrue(json.has("advocate"));
        assertEquals("Ada", json.get("advocate").get("firstname").asText());
        assertEquals(25, json.get("advocate").get("payout_threshold").asInt());
        assertEquals("USD", json.get("advocate").get("currency_code").asText());
        assertFalse(json.get("advocate").has("avatar_url"));
    }

    @Test
    void advocatePatchFormSerializesAsBarePartialBody() throws Exception {
        AdvocatePatchForm patch = new AdvocatePatchForm();
        patch.firstname = "Grace";
        patch.status = "inactive";

        JsonNode json = mapper.valueToTree(patch);

        assertEquals("Grace", json.get("firstname").asText());
        assertEquals("inactive", json.get("status").asText());
        assertFalse(json.has("advocate"));
    }

    @Test
    void paymentMethodFormUsesDocsWrapperKey() throws Exception {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.username = "finance@example.com";
        paymentMethod.description = "PayPal";
        paymentMethod.isActive = true;

        JsonNode json = mapper.valueToTree(new PaymentMethodForm(paymentMethod));

        assertTrue(json.has("advocate_payment_method"));
        assertEquals("finance@example.com", json.get("advocate_payment_method").get("username").asText());
        assertTrue(json.get("advocate_payment_method").get("is_active").asBoolean());
    }

    @Test
    void redemptionRequestFormAndPatchUseDifferentPayloadShapes() throws Exception {
        RedemptionRequest redemptionRequest = new RedemptionRequest();
        redemptionRequest.advocateToken = "adv-token";
        redemptionRequest.requestStatusSlug = "pending";
        redemptionRequest.requestActionSlug = "paypal";
        redemptionRequest.currencyCode = "USD";
        redemptionRequest.amount = 12.5;

        JsonNode createJson = mapper.valueToTree(new RedemptionRequestForm(redemptionRequest));
        assertTrue(createJson.has("redemption_request"));
        assertEquals("adv-token", createJson.get("redemption_request").get("advocate_token").asText());

        RedemptionRequestPatchForm patch = new RedemptionRequestPatchForm();
        patch.requestStatusSlug = "approved";
        patch.modifiedBy = "sdk";

        JsonNode patchJson = mapper.valueToTree(patch);
        assertFalse(patchJson.has("redemption_request"));
        assertEquals("approved", patchJson.get("request_status_slug").asText());
        assertEquals("sdk", patchJson.get("modified_by").asText());
    }

    @Test
    void productVariantAndPriceFormsUseNestedResourceWrappers() throws Exception {
        Product product = new Product();
        product.title = "Referral Hoodie";
        product.descriptionHtml = "<p>Warm</p>";

        Variant variant = new Variant();
        variant.title = "Medium";
        variant.sku = "HOODIE-M";
        variant.inventoryQuantity = 10;

        Price price = new Price();
        price.currencyCode = "USD";
        price.amount = "49.99";

        JsonNode productJson = mapper.valueToTree(new ProductForm(product));
        JsonNode variantJson = mapper.valueToTree(new VariantForm(variant));
        JsonNode priceJson = mapper.valueToTree(new PriceForm(price));

        assertEquals("Referral Hoodie", productJson.get("product").get("title").asText());
        assertEquals("<p>Warm</p>", productJson.get("product").get("description_html").asText());
        assertEquals("HOODIE-M", variantJson.get("variant").get("sku").asText());
        assertEquals(10, variantJson.get("variant").get("inventory_quantity").asInt());
        assertEquals("USD", priceJson.get("price").get("currency_code").asText());
        assertEquals("49.99", priceJson.get("price").get("amount").asText());
    }

    @Test
    void widgetTranslationFormAndPatchUseExpectedShapes() throws Exception {
        WidgetTranslation translation = new WidgetTranslation();
        translation.locale = "en";
        translation.name = "Referral widget";
        translation.content = "Invite your friends";

        JsonNode createJson = mapper.valueToTree(new WidgetTranslationForm(translation));
        assertTrue(createJson.has("widget_translation"));
        assertEquals("en", createJson.get("widget_translation").get("locale").asText());

        WidgetTranslationPatchForm patch = new WidgetTranslationPatchForm();
        patch.content = "Invite customers";

        JsonNode patchJson = mapper.valueToTree(patch);
        assertFalse(patchJson.has("widget_translation"));
        assertEquals("Invite customers", patchJson.get("content").asText());
    }
}
