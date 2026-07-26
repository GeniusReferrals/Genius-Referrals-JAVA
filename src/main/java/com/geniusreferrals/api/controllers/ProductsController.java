package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class ProductsController {
    private final GRClient client;
    public ProductsController(GRClient client) { this.client = client; }

    public String getProducts(String accountSlug, int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get(GRClient.path("/accounts/{account_slug}/products", Map.of("account_slug", accountSlug)), qp);
    }

    public String getProduct(String accountSlug, String productSlug) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("product_slug", productSlug);
        return client.get(GRClient.path("/accounts/{account_slug}/products/{product_slug}", params), null);
    }

    public String createProduct(String accountSlug, Object productForm) throws APIException {
        return client.post(GRClient.path("/accounts/{account_slug}/products", Map.of("account_slug", accountSlug)), null, productForm);
    }

    public void updateProduct(String accountSlug, String productSlug, Object productForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("product_slug", productSlug);
        client.put(GRClient.path("/accounts/{account_slug}/products/{product_slug}", params), null, productForm);
    }

    public void deleteProduct(String accountSlug, String productSlug) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("product_slug", productSlug);
        client.delete(GRClient.path("/accounts/{account_slug}/products/{product_slug}", params), null);
    }

    public String getProductVariants(String accountSlug, String productSlug) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("product_slug", productSlug);
        return client.get(GRClient.path("/accounts/{account_slug}/products/{product_slug}/variants", params), null);
    }

    public String createProductVariant(String accountSlug, String productSlug, Object variantForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("product_slug", productSlug);
        return client.post(GRClient.path("/accounts/{account_slug}/products/{product_slug}/variants", params), null, variantForm);
    }

    public void patchProductVariant(String accountSlug, String productSlug, String variantId, Object variantForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("product_slug", productSlug);
        params.put("variant_id", variantId);
        client.patch(GRClient.path("/accounts/{account_slug}/products/{product_slug}/variants/{variant_id}", params), null, variantForm);
    }

    public void deleteProductVariant(String accountSlug, String productSlug, String variantId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("product_slug", productSlug);
        params.put("variant_id", variantId);
        client.delete(GRClient.path("/accounts/{account_slug}/products/{product_slug}/variants/{variant_id}", params), null);
    }

    public void patchProductVariantPrice(String accountSlug, String productSlug, String variantId, String currencyCode, Object priceForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("product_slug", productSlug);
        params.put("variant_id", variantId);
        params.put("currency_code", currencyCode);
        client.patch(GRClient.path("/accounts/{account_slug}/products/{product_slug}/variants/{variant_id}/prices/{currency_code}", params), null, priceForm);
    }
}
