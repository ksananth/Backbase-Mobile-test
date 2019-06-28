## Backbase - Mobile Test
[![Build Status](https://travis-ci.org/ksananth/Backbase-Mobile-test.svg?branch=master)](https://travis-ci.org/ksananth/Backbase-Mobile-test)
[![codecov](https://codecov.io/gh/ksananth/Backbase-Mobile-test/branch/master/graph/badge.svg)](https://codecov.io/gh/ksananth/Backbase-Mobile-test)
## Aim of this Project:
Develop an Android app to list cities containing around 200k entries in JSON and show its mapview

## Acceptance Criteria:
* Download the list of cities from [here](cities.json).
* Be able to filter the results by a given prefix string, following these requirements:
     * Follow the prefix definition specified in the clarifications section below.
     * Optimise for fast searches. Loading time of the app is not so important.
     * Search is case insensitive.
* Display these cities in a scrollable list, in alphabetical order (city first, country after). Hence, "Denver, US" should appear before "Sydney, Australia".
     * The UI should be as responsive as possible while typing in a filter.
     * The list should be updated with every character added/removed to/from the filter.
* Each city's cell should:
     * Show the city and country code as title.
     * Show the coordinates as subtitle.
     * When tapped, navigate the map to the coordinates of the city.
     * Contain a button that, when tapped, opens an information screen about the selected city. The code of this screen is available under the following folder[Android](androidTestClasses), and for iOS (ios-classes-to-unit-test).
* Create a dynamic UI that follows the [wireframe](wireframes). Hence, when in [portrait](wireframes/portrait.png) different screens should be used for the list and map but when in [landscape](wireframes/landscape.png), a single screen should be used.
* Provide unit tests showing that your search algorithm is displaying the correct results giving different inputs, including invalid inputs.
* Provide UI/unit tests for the information screen code we provided you. You are allowed to refactor if needed.

## Key points to highlight about this kata:
* Followed Test Driven Developemnt
* Used MVP architectural pattern to seperate development of the UI and business logic
* Added Test cases for all business logic in Model and Presenter
* Added Android Test cases to test the View.
* Integrated with Continous Integration tool (Travis CI) [![Build Status](https://travis-ci.org/ksananth/Backbase-Mobile-test.svg?branch=master)](https://travis-ci.org/ksananth/Backbase-Mobile-test)
.

## Run
To run this project (make sure mobile is connected and usb debugging is enabled):

```
$ ./gradlew clean build installDebug
```
To run tests (Junit and Espresso):

```
$ ./gradlew build connectedCheck
```

To generate report of tests:

```
$ ./gradlew build jacocoTestReport assembleAndroidTest createDebugCoverageReport
```
## Code Coverage Report
![](https://github.com/2019-SOW-DEV-003/LeapYears/blob/master/report.png)
###### Note: There is some issue with uploading coverage to codecov. Android studio shows 100% code coverage whereas this tool shows 71.43%

## Output
![](https://github.com/2019-SOW-DEV-003/LeapYears/blob/master/screenshot.gif)
