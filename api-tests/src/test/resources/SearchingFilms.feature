Feature: Test

  Scenario: Search film by title

    Given User search the new film "Star Wars"
    When User receive response according to search
    Then User search completed successfully by film name "Star Wars: Episode IV - A New Hope"

  Scenario: Search film by title and year

    Given User search the new film  with name "Star Wars" and year "1977"
    When User receive response for film name and year
    Then User search completed successfully by film name "Star Wars: Episode IV - A New Hope" and year "1977"

  Scenario: User search film using all fields

    Given User search film using all fields with name "Wild",year "2014", plot "short", response "JSON"
    When User receive response for searching film using all fields
    Then User search completed successfully by film name "Wild" ,year "2014", plot "A chronicle of one woman's one thousand one hundred mile solo hike undertaken as a way to recover from a recent personal tragedy.", response "application/json; charset=utf-8"

  Scenario: User search film with response type xml

    Given User search film with response XML film name "Wild",year "2014", plot "short", response "xml"
    When User receive response for searching film with xml response
    Then User search completed successfully with response type "text/xml; charset=utf-8"

  Scenario: Search film with empty title

    Given User search the new film  with empty name ""
    When User receive response with warning
    Then User see that response "False" with warning "Something went wrong."

  Scenario: Search film with invalid name

    Given User search the new film  with invalid name "UkraineTheBestCounty"
    When User receive response with valid error message
    Then User see that response "False" with error "Movie not found!"