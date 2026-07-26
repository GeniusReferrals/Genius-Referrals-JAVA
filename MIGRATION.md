# Migration Guide: v1.x to v2.0

## Java Version

v2.0 requires Java 17+. Update your project's compiler settings:

```xml
<maven.compiler.source>17</maven.compiler.source>
<maven.compiler.target>17</maven.compiler.target>
```

## Package Change

The old APIMATIC-generated package structure has been replaced:

**Old:**
```java
import com.geniusreferrals.api.controllers.AccountsController;
AccountsController.getInstance().getAccount("slug");
```

**New:**
```java
import com.geniusreferrals.api.GeniusReferralsClient;
GeniusReferralsClient client = new GeniusReferralsClient("YOUR_TOKEN");
client.accounts.getAccount("slug");
```

## Configuration

The old `Configuration` class had a hardcoded API token. This has been removed.
Pass your token to the `GeniusReferralsClient` constructor instead.

## HTTP Client

Unirest 1.0.7 has been replaced with Java's built-in `HttpClient`. No external HTTP dependencies required.

## New Endpoints

v2.0 adds these previously missing endpoints:
- Products (CRUD + variants + prices)
- Tags (CRUD)
- Vouchers (CRUD + denominations)
- Widgets Packages (CRUD + widgets + translations)
- Account CRUD (POST/PUT/DELETE)
- Bonus PATCH and Bonus Tags
- Reports: revenue, 1099-tax-report
- Utilities: payment-methods

## Maven Coordinates

**Old:** `GeniusReferralsLib:GeniusReferralsLib:1.0.0`
**New:** `com.geniusreferrals:geniusreferrals-java-sdk:2.0.0`
