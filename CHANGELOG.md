# Changelog

## v2.0.0 - 2026-07-24

### Breaking Changes
- Java minimum raised from 5 to 17
- Removed deprecated Unirest 1.0.7 dependency
- Removed APIMATIC-generated client structure
- New package structure: `com.geniusreferrals.api`
- New entry point: `GeniusReferralsClient`
- Removed hardcoded API token from Configuration

### Added
- New `GRClient` using Java 11+ `HttpClient` (zero external HTTP deps)
- Full endpoint coverage (80+ endpoints)
- New controllers: Products, Tags, Vouchers, WidgetsPackages
- New operations: Account CRUD, Bonus PATCH, Bonus Tags, Reports revenue/1099, Utilities payment-methods
- JUnit 5 test suite with MockWebServer (60+ tests)
- Live smoke test suite
- Docker dev environment
- README rewritten, MIGRATION.md added

### Changed
- Jackson updated from 2.2.3 to 2.16.1
- JUnit updated from 4.12 to 5.10.2
- Maven group/artifact changed to `com.geniusreferrals:geniusreferrals-java-sdk`
