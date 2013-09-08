Feature:  Ensure an input file is read and each url is retrieved and assessed

 Scenario: Ensure a redirected url is retrieved and checked
 Given a Filechecker that will check the following urls:
 |http://www.google.com|
 |http://www.google.co.uk|
 When the file checker is run
 Then the output log will contain:
 | 200 | http://www.google.co.uk | false |
 | 200 | http://www.google.co.uk | false |



