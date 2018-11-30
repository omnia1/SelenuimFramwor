$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("userRegisterFile.feature");
formatter.feature({
  "line": 1,
  "name": "User Registration",
  "description": " I Want To Check That The User Is Register In Our e-commerce WebSite.",
  "id": "user-registration",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "User Registration",
  "description": "",
  "id": "user-registration;user-registration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "The User  In Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on register link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entered \"\u003cfirstName\u003e\" ,\"\u003clastName\u003e\" ,\"\u003cemail\u003e\",\"\u003ccompany\",\"\u003cpasswod\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the registration page displayed successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "user-registration;user-registration;",
  "rows": [
    {
      "cells": [
        "firstName",
        "lastName",
        "email",
        "company",
        "password"
      ],
      "line": 11,
      "id": "user-registration;user-registration;;1"
    },
    {
      "cells": [
        "ahmed",
        "mah",
        "sam@test.com",
        "c",
        "128990"
      ],
      "line": 12,
      "id": "user-registration;user-registration;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "User Registration",
  "description": "",
  "id": "user-registration;user-registration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "The User  In Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on register link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I entered \"ahmed\" ,\"mah\" ,\"sam@test.com\",\"\u003ccompany\",\"\u003cpasswod\u003e\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "the registration page displayed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "userRegistration.the_User_In_Home_Page()"
});
formatter.result({
  "duration": 1630096453,
  "status": "passed"
});
formatter.match({
  "location": "userRegistration.i_click_on_register_link()"
});
formatter.result({
  "duration": 16542490,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ahmed",
      "offset": 11
    },
    {
      "val": "mah",
      "offset": 20
    },
    {
      "val": "sam@test.com",
      "offset": 27
    },
    {
      "val": "\u003ccompany",
      "offset": 42
    },
    {
      "val": "\u003cpasswod\u003e",
      "offset": 53
    }
  ],
  "location": "userRegistration.i_entered(String,String,String,String,String)"
});
formatter.result({
  "duration": 2824919537,
  "status": "passed"
});
formatter.match({
  "location": "userRegistration.the_registration_page_displayed_successfully()"
});
formatter.result({
  "duration": 1635518244,
  "status": "passed"
});
});