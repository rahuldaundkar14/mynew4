Feature: Reset functionality on login page of Application
  
  @android @ios
 	 Scenario Outline:  Verification of Reset button1
    Given Open the browser "<browser>" with url "<url>"
    Given Click on Gmail button
    #Given Close the browser
    
   Examples:
   |browser|url|
   |chrome|http://google.com|
   #|firefox|https://www.guru99.com|

    @smoke
 	 Scenario Outline:  Verification of Reset button123
    Given Open the browser "<browser>" with url "<url>"
    Given Close the browser
   
   Examples:
   |browser|url|
   |chrome|https://sqa.stackexchange.com|
  #mvn clean test -Durl=https://sqa.stackexchange.com -Dcucumber.options="--tags @smoke"