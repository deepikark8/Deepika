package com.practice.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/rahade/workspaceSelenium/CucumberPracticeScenarioOutline/features/login.feature",
glue={"com.practice.steps"},
plugin={"pretty","html:target/cucumber-reports/cucumber.html","json:target/cucumber-reports/cucumber.json"}
	
		)

public class Runner {

}
