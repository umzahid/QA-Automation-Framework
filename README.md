# 🤖 QA Automation Framework

An enterprise-grade BDD test automation framework built with **Selenium 4 + Cucumber 7 + Serenity BDD**, following the **Page Object Model (POM)** pattern. Targets [SauceDemo](https://www.saucedemo.com) — a purpose-built e-commerce testing sandbox.

## ✨ Features

- ✅ **BDD with Gherkin** — human-readable `.feature` files
- ✅ **Serenity BDD** — rich HTML reports with step-level screenshots
- ✅ **Page Object Model** — clean separation of page logic from test logic
- ✅ **BasePage abstraction** — shared explicit-wait helpers across all pages
- ✅ **ConfigManager** — environment overrides via system properties (CI-friendly)
- ✅ **Tag-based filtering** — run `@smoke`, `@regression`, or `@negative` suites independently
- ✅ **Parametrized scenarios** — `Scenario Outline` with `Examples` tables
- ✅ **Headless support** — toggle via `config.properties`

## 🧱 Tech Stack

| Tool | Version | Purpose |
|------|---------|---------|
| Java | 11 | Language |
| Selenium | 4.15.0 | Browser automation |
| Cucumber | 7.14.0 | BDD framework |
| Serenity BDD | 3.9.8 | Reporting + page objects |
| WebDriverManager | 5.6.3 | Auto driver management |
| JUnit 5 | 5.10 | Test runner |
| Maven | 3.9+ | Build & dependency management |

## 🚀 Getting Started

```bash
# Clone
git clone https://github.com/umairzahid/qa-automation-framework.git
cd qa-automation-framework

# Run all smoke tests
mvn clean verify -Dcucumber.filter.tags="@smoke"

# Run full regression suite
mvn clean verify -Dcucumber.filter.tags="@regression"

# Run headless (for CI)
mvn clean verify -Dheadless=true

# View Serenity HTML report
open target/site/serenity/index.html
```

## 📁 Project Structure

```
qa-automation-framework/
├── src/
│   ├── main/
│   │   ├── java/com/umair/framework/
│   │   │   ├── config/ConfigManager.java     # Config loader with CI override
│   │   │   └── pages/
│   │   │       ├── BasePage.java             # Shared wait helpers
│   │   │       ├── LoginPage.java            # Login page POM
│   │   │       └── InventoryPage.java        # Products page POM
│   │   └── resources/config.properties       # Environment config
│   └── test/
│       ├── java/com/umair/tests/
│       │   ├── CucumberTestRunner.java        # Suite runner
│       │   └── SauceDemoSteps.java            # Step definitions
│       └── resources/features/
│           └── saucedemo.feature              # Gherkin scenarios
├── pom.xml
└── README.md
```

## 🔖 Tags

| Tag | Scope |
|-----|-------|
| `@smoke` | Critical path — login + cart |
| `@regression` | Full suite |
| `@login` | Login scenarios only |
| `@cart` | Cart scenarios only |
| `@negative` | Invalid input scenarios |

## 📊 Serenity Reports

After `mvn verify`, open:
```
target/site/serenity/index.html
```
Reports include: test results, feature breakdown, step-by-step screenshots, and execution timeline.

## 🔧 CI/CD Integration (GitHub Actions)

```yaml
- name: Run QA Tests
  run: mvn clean verify -Dheadless=true -Dcucumber.filter.tags="@smoke"

- name: Upload Serenity Report
  uses: actions/upload-artifact@v3
  with:
    name: serenity-report
    path: target/site/serenity/
```

## 👨‍💻 Author

**Umair Zahid** — SDET  
📧 aumair525@gmail.com | 🔗 [LinkedIn](https://linkedin.com/in/umair-zahid)
