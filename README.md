## Mobile Test
[![Build Status](https://travis-ci.org/ksananth/Backbase-Mobile-test.svg?branch=master)](https://travis-ci.org/ksananth/Backbase-Mobile-test)
[![codecov](https://codecov.io/gh/ksananth/Backbase-Mobile-test/branch/master/graph/badge.svg)](https://codecov.io/gh/ksananth/Backbase-Mobile-test)
## Aim of this Project:
Develop an Android app to list cities containing around 200k entries in JSON and show its mapview

## Key points to highlight about this kata:
* Followed Test Driven Development
* Used MVP architectural pattern to separate development of the UI and business logic
* Added Test cases for all business logic in Model and Presenter
* Added Android Test cases to test the View.
* Integrated with Continuous Integration tool (Travis CI) [![Build Status](https://travis-ci.org/ksananth/Backbase-Mobile-test.svg?branch=master)](https://travis-ci.org/ksananth/Backbase-Mobile-test)

## Architecture Blueprint:
![](https://github.com/ksananth/Backbase-Mobile-test/blob/master/blueprint.png)

## Run
To run this project (make sure mobile is connected and usb debugging is enabled):

```
$ ./gradlew clean build installRelease
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
#### Espresso Test Result
![](https://github.com/ksananth/Backbase-Mobile-test/blob/master/espresso_dashboard.png)

#### Unit Test Result
![](https://github.com/ksananth/Backbase-Mobile-test/blob/master/unittest_dashboard.png)

## Output
![](https://github.com/ksananth/Backbase-Mobile-test/blob/master/screenshot.gif)
