Feature: Verify functionality of adding word

  Background: login as user
    When User navigates to site
    Then User is on Login page
    And Login page is displayed
    When User enters user`s name
    And User enters password
    And User presses 'Sign in' button
    Then User is on Main page
    Then Main page is displayed

  Scenario Outline: Add word with all necessary data
    When User enters <englishWord> english word
    And User enters <transcription> transcription
    And User enters <russianTranslation> russian translation
    And User enters <englishExample> example on english
    And User enters <exampleRussianTranslation> example`s translation in russian
    And User presses 'Add word' button
    Then <englishWord> word with <transcription>, <russianTranslation>, <englishExample> and <exampleRussianTranslation> is displayed as first word in list of words
    When User deletes <englishWord> word
    Then <englishWord> word is not displayed in list of words
    And User presses logout button
    And User is on Login page
    And Login page is displayed

    Examples:
      | englishWord | transcription | russianTranslation | englishExample | exampleRussianTranslation |
      |             |               |                    |                |                           |

  Scenario Outline: Add word without any necessary data
    When User enters <englishWord> english word
    And User presses 'Autofill' button
    And User presses 'Add word' button
    Then <englishWord> word with <transcription>, <russianTranslation>, <englishExample> and <exampleRussianTranslation> is displayed as first word in list of words
    And User presses logout button
    And User is on Login page
    And Login page is displayed

    Examples:
      | englishWord | transcription | russianTranslation | englishExample | exampleRussianTranslation |
      |             |               |                    |                |                           |