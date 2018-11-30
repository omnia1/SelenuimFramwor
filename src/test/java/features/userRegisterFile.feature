Feature: User Registration
   I Want To Check That The User Is Register In Our e-commerce WebSite.
   
   Scenario Outline: User Registration
   Given The User  In Home Page 
   When  I click on register link
   And  I entered "<firstName>" ,"<lastName>" ,"<email>","<company","<passwod>"
   Then the registration page displayed successfully
   
   Examples:
   |firstName|lastName|email|company|password|
   |ahmed|mah|sam@test.com|c|128990|