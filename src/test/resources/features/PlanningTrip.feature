Feature: Planning a trip with TFL

  Quick feature file for exercise tests

  Scenario: TFL main page title
    When viewing TFL main page
    Then the title "Transport for London" will be displayed

  Scenario: TFL overground title
    When viewing TFL status page
    Then the title "Tube, Overground, Elizabeth line, DLR & Tram" will be displayed

  Scenario: Search for station
    When searching for the station "Waterloo"
    Then results will display headline "Search: Waterloo"

  Scenario: View search results
    When searching for the station "Jubilee"
    Then results will contains items related to "Jubilee"

  Scenario: Station list for status
    When viewing TFL status page
    Then it includes station names

  Scenario: Fill contact form
    When populating the TFL contact form
    Then the form will show entered details
