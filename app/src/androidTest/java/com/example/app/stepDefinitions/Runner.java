package com.example.app.stepDefinitions;

import cucumber.api.CucumberOptions;


@CucumberOptions(
        plugin = {
                "pretty",
                "html:" + Runner.REPORT_PATH + "cucumber-html-report",
                "pretty:" + Runner.REPORT_PATH + "cucumber-report.json",
                "junit:" + Runner.REPORT_PATH + "cucumber.xml"
        },
        features = "features",
        tags = "@shortSanity")

public class Runner {
    public static final String REPORT_PATH = "data/data/" + com.example.app.BuildConfig.APPLICATION_ID + "/cucumber-reports/";
}
