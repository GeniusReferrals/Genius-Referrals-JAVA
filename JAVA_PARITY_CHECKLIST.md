# Java SDK 2.0 Parity Checklist

## Endpoint Inventory

Controller coverage is present for the current Genius Referrals API resources:

- Root and authentication: root, test authentication
- Accounts: list, get, create, update, delete
- Advocates: list, get, create, put, patch, delete, bulk delete, share links, payment methods
- Bonuses: list, get, create, force, delete, checkup, traces, patch, tags
- Campaigns: list, get
- Products: list, get, create, update, delete, variants, variant patch/delete, variant price patch
- Redemption requests: list, get, create, patch, redeem
- Referrals: list, get, create, update, delete
- Reports: bonuses daily given, bonuses summary per origin, click/referral/share daily participation, referrals summary per origin, top advocates, revenue, 1099 tax
- Tags: list, get, create, update, delete
- Utilities: bonus redemption methods, currencies, payment methods, redemption request actions/statuses, referral origins
- Vouchers: list, get, create, patch, delete, denominations
- Widgets packages: list, get, create, update, delete, widgets, widget translations

## Controller and Model Parity

Typed model/form coverage was added under `src/main/java/com/geniusreferrals/api/models` for writable resources.

- Account: `Account`, `AccountForm`
- Advocate: `Advocate`, `AdvocateForm`, `AdvocatePatchForm`
- Bonus: `Bonus`, `BonusForm`, `BonusPatchForm`, `Bonuses`, `BonusesForm`, `ForceBonus`, `ForceBonusForm`, `ForceBonuses`, `ForceBonusesForm`
- Payment method: `PaymentMethod`, `PaymentMethodForm`
- Product: `Product`, `ProductForm`, `Variant`, `VariantForm`, `VariantPatchForm`, `Price`, `PriceForm`, `PricePatchForm`
- Redemption request: `RedemptionRequest`, `RedemptionRequestForm`, `RedemptionRequestPatchForm`, `ProcessRedemptionForm`
- Referral: `Referral`, `ReferralForm`
- Tag: `Tag`, `TagForm`
- Voucher: `Voucher`, `VoucherForm`, `VoucherPatchForm`
- Widgets: `WidgetsPackage`, `WidgetsPackageForm`, `Widget`, `WidgetForm`, `WidgetPatchForm`, `WidgetTranslation`, `WidgetTranslationForm`, `WidgetTranslationPatchForm`
- Shared response helper: `PaginatedResponse`

Controllers continue accepting `Object` bodies so existing `Map` callers remain supported, while typed forms can now be passed directly.

## Payload Audit Notes

- Create/update request bodies use the documented wrapper keys, including `advocate`, `bonus`, `advocate_payment_method`, `redemption_request`, `referral`, `tag`, `voucher`, `product`, `variant`, `price`, `widgets_package`, `widget`, and `widget_translation`.
- PATCH-specific forms serialize as bare partial bodies where the API expects PATCH fields without the create wrapper.
- `AuthenticationsController` now uses `/test-authentication`, matching the live API docs and completed Go SDK.
- Live smoke response parsing now handles both string and numeric identifiers through Jackson JSON parsing.

## Verification Log

White-box Docker gate:

```bash
docker compose run --rm sdk mvn test
```

Result: 71 tests, 0 failures, 0 errors.

Black-box live smoke gate:

```bash
GR_API_TOKEN=... GR_ACCOUNT_SLUG=test1000 docker compose run --rm sdk mvn -q test-compile exec:java -Dexec.mainClass=com.geniusreferrals.api.LiveApiSmokeTest -Dexec.classpathScope=test
```

Result: 30 checks passed, 0 failed.

## Open Gaps

- No known controller/model/payload/test gaps after the current pass.
- GitHub project metadata says `bolt-dot` has read access but not push access to `Genius-Referrals-JAVA`, so opening a PR may require repository write access or an approved fork workflow.
