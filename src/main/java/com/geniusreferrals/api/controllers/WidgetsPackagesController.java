package com.geniusreferrals.api.controllers;

import com.geniusreferrals.api.GRClient;
import com.geniusreferrals.api.exceptions.APIException;

import java.util.HashMap;
import java.util.Map;

public class WidgetsPackagesController {
    private final GRClient client;
    public WidgetsPackagesController(GRClient client) { this.client = client; }

    public String getWidgetsPackages(String accountSlug, int page, int limit) throws APIException {
        Map<String, Object> qp = new HashMap<>();
        qp.put("page", page);
        qp.put("limit", limit);
        return client.get(GRClient.path("/accounts/{account_slug}/widgets-packages", Map.of("account_slug", accountSlug)), qp);
    }

    public String getWidgetsPackage(String accountSlug, String widgetsPackageSlug) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        return client.get(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}", params), null);
    }

    public String createWidgetsPackage(String accountSlug, Object widgetsPackageForm) throws APIException {
        return client.post(GRClient.path("/accounts/{account_slug}/widgets-packages", Map.of("account_slug", accountSlug)), null, widgetsPackageForm);
    }

    public void updateWidgetsPackage(String accountSlug, String widgetsPackageSlug, Object widgetsPackageForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        client.put(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}", params), null, widgetsPackageForm);
    }

    public void deleteWidgetsPackage(String accountSlug, String widgetsPackageSlug) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        client.delete(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}", params), null);
    }

    public String getWidgets(String accountSlug, String widgetsPackageSlug) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        return client.get(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}/widgets", params), null);
    }

    public String getWidget(String accountSlug, String widgetsPackageSlug, String widgetId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        params.put("widget_id", widgetId);
        return client.get(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}/widgets/{widget_id}", params), null);
    }

    public String createWidget(String accountSlug, String widgetsPackageSlug, Object widgetForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        return client.post(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}/widgets", params), null, widgetForm);
    }

    public void patchWidget(String accountSlug, String widgetsPackageSlug, String widgetId, Object widgetForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        params.put("widget_id", widgetId);
        client.patch(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}/widgets/{widget_id}", params), null, widgetForm);
    }

    public void putWidget(String accountSlug, String widgetsPackageSlug, String widgetId, Object widgetForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        params.put("widget_id", widgetId);
        client.put(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}/widgets/{widget_id}", params), null, widgetForm);
    }

    public String getWidgetTranslations(String accountSlug, String widgetsPackageSlug, String widgetId) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        params.put("widget_id", widgetId);
        return client.get(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}/widgets/{widget_id}/translations", params), null);
    }

    public String getWidgetTranslation(String accountSlug, String widgetsPackageSlug, String widgetId, String locale) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        params.put("widget_id", widgetId);
        params.put("locale", locale);
        return client.get(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}/widgets/{widget_id}/translations/{locale}", params), null);
    }

    public String createWidgetTranslation(String accountSlug, String widgetsPackageSlug, String widgetId, Object translationForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        params.put("widget_id", widgetId);
        return client.post(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}/widgets/{widget_id}/translations", params), null, translationForm);
    }

    public void patchWidgetTranslation(String accountSlug, String widgetsPackageSlug, String widgetId, String locale, Object translationForm) throws APIException {
        Map<String, String> params = new HashMap<>();
        params.put("account_slug", accountSlug);
        params.put("widgets_package_slug", widgetsPackageSlug);
        params.put("widget_id", widgetId);
        params.put("locale", locale);
        client.patch(GRClient.path("/accounts/{account_slug}/widgets-packages/{widgets_package_slug}/widgets/{widget_id}/translations/{locale}", params), null, translationForm);
    }
}
