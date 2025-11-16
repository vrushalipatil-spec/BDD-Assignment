BDD_Amazon_Project - Demo POC

This project contains a Cucumber + Selenium demo POC for automating high-level Amazon flows described by the user.
It uses placeholder selectors and example flows — you must update locators and possibly flows for the live site (Amazon
often changes markup and requires account-specific flows).

How to run:
1. Unzip project and open in IntelliJ as Maven project.
2. Update src/test/resources/config/config.properties with your credentials (if running login scenarios).
3. Update locators in page objects and step definitions as per the latest Amazon DOM for your region.
4. Right-click src/test/java/runners/TestRunner.java -> Run 'TestRunner'.
5. Screenshots on failure are saved to target/screenshots/

Notes:
- This is a demonstrative POC. For production, enhance with waits, better locators, error handling, data-driven tests,
  secure secrets management, and CI integration.
# BDD-Assignment
