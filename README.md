# Genius Referrals Java SDK

Java SDK for the Genius Referrals REST API.

## Requirements

- Java 17+
- Maven 3.6+

## Installation

### Maven

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.geniusreferrals</groupId>
    <artifactId>geniusreferrals-java-sdk</artifactId>
    <version>2.0.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.geniusreferrals:geniusreferrals-java-sdk:2.0.0'
```

## Authentication

Get your API token from [Settings > API Access](https://www.geniusreferrals.com/en/settings/api-access).

```java
import com.geniusreferrals.api.GeniusReferralsClient;

GeniusReferralsClient client = new GeniusReferralsClient("YOUR_API_TOKEN");
```

## Usage

### Accounts

```java
// List accounts
String accounts = client.accounts.getAccounts(1, 10, "json");

// Get single account
String account = client.accounts.getAccount("my-account");
```

### Advocates

```java
// List advocates
String advocates = client.advocates.getAdvocates("my-account", 1, 10);

// Create advocate
Map<String, Object> form = Map.of("advocate", Map.of(
    "firstname", "John",
    "lastname", "Doe",
    "email", "john@example.com",
    "payout_threshold", 10,
    "can_refer", 1,
    "currency_code", "USD",
    "status", "active"
));
String created = client.advocates.postAdvocate("my-account", form);
```

### Tags

```java
// Create tag
Map<String, Object> tagForm = Map.of("tag", Map.of(
    "name", "VIP",
    "description", "VIP advocates",
    "color", "#FF0000"
));
String tag = client.tags.createTag("my-account", tagForm);
```

### Products

```java
// List products
String products = client.products.getProducts("my-account", 1, 10);
```

### Reports

```java
// Bonuses daily given
String report = client.reports.getBonusesDailyGiven("my-account", "2026-01-01", "2026-12-31", null);

// 1099 tax report
String taxReport = client.reports.get1099TaxReport("my-account", 2025);
```

## Docker Development

```bash
# Build
docker compose build

# Run tests
docker compose run --rm sdk mvn test

# Run live smoke
docker compose run --rm -e GR_API_TOKEN=your_token -e GR_ACCOUNT_SLUG=your_account sdk mvn test-compile exec:java -Dexec.mainClass=com.geniusreferrals.api.LiveApiSmokeTest -Dexec.classpathScope=test
```

## API Coverage

All 80+ endpoints across 13 resources + utilities are covered:

- Accounts (CRUD)
- Advocates (CRUD + payment methods + share links)
- Authentications
- Bonuses (CRUD + force + traces + tags)
- Campaigns
- Products (CRUD + variants + prices)
- Redemption Requests (CRUD + redeem)
- Referrals (CRUD)
- Reports (7 report types + revenue + 1099)
- Roots
- Tags (CRUD)
- Utilities (currencies, payment methods, referral origins, etc.)
- Vouchers (CRUD + denominations)
- Widgets Packages (CRUD + widgets + translations)

## License

MIT
