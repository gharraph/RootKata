# RootKata

## How to run the application
- In any terminal, Clone this repo:
```
git clone https://github.com/gharraph/RootKata.git
```
- Change directory to:
```
RootKata/src/main/java
```
- run the following command to compile the code :  
```
javac  RootKata/DrivingHistoryApp.java
```
- run the following command to run the application:
```
java RootKata/DrivingHistoryApp testFile.txt
```
- please note that I included a test file with the application for testing. You can include any other files in the same directory, and replace the testFile.txt argurment with the name of the new file.
- To run unit tests, change directory to RootKata (root folder for the project). run the following command:
```
./gradlew test
```


## Solution Analysis:
- To parse the input file I chose HashMap data structure with Driver name as the key for the map, and list of trips as the value for each driver.
```
{
  "Alex":[<trip:startTime, endTime, milesDriven>, <trip:startTime, endTime, milesDriven>], 
  "Dan":[<trip:startTime, endTime, milesDriven>], 
  "Bob":[]
}
 ```
- This helped associating all trips to their driver owner. I chose the driver name as the key, but in real application I would recommend driver identifier as the key, however, given the input file in the exercise problem the driver name will suffice.
- Used Junit 4 with Hamcrest matchers for unit testing. 
- Object used in my solutions are: Trip, and DriverSummaryRecord. I would typicaly use an object for driver, but, as the problem is simple enough using only driver first name, String object suffice.
- The parser class is static class, as it does not have any state. 
- I did not need to use any mocking frawork as problem is simple, as most of the logic are in the parser class.
- For simplicity I used LocalTime library for the start and end time of the trips. 
- I had to use comparator class to output driver summary record in the order specified.
