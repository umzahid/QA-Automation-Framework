package com.umair.tests;

import io.cucumber.junit.platform.engine.Constants;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.umair.tests")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,
    value = "pretty, json:target/cucumber-reports/cucumber.json")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@smoke or @regression")
public class CucumberTestRunner {
    // Serenity + Cucumber runner — no body needed
}
