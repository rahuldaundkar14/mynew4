package com.testrunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import java.io.File;
@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features"
,glue = {"com.stepdefn","com.hooks"}
,plugin = {"com.core.listners.ExtentCucumberAdapter:"}
, tags = {"@android, @ios"})
public class TestDevice_2{ public void hello() { System.out.print("Hello world");}}
