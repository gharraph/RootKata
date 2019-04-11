# RootKata

## How to run the application
- Clone this repo 
- In any terminal:
- Change directory to /RootKata/src/main/java
- run the following command to compile the code :  
```
javac  RootKata/DrivingHistoryApp.java
```
- run the following command to run the application:
```
java RootKata/DrivingHistoryApp testFile.txt
```
- please note that I included a test file with the application for testing. You can include any other files in the same directory, and replace the testFile.txt argurment with the name of the new file.


## Solution Analysis:
- To parse the input file I chose HashMap data structre with Driver name as the key for the map, and list of trips is the value for each driver.
```
{
  "Alex":[<trip:startTime, endTime, milesDriven>, <trip:startTime, endTime, milesDriven>], 
  "Dan":[<trip:startTime, endTime, milesDriven>], 
  "Bob":[]
}
 ```
- This helped associating all trips to their driver owner. I chose the driver name as the key, but in real application I would recommend driver Identifier as the key, however, given the input file in the exercise problem the driver name will suffice.
- Used Junit 4 with Hamcrest matchers for unit testing. 
- Object used in my solutions are: Trip, and DriverSummaryRecord. I would typicaly use an object for driver, but, as the problem is simple enough using only driver first name, String object suffice.
- I did not need to use any mocking from work for problem simplicity, as most of the logic are in the parser class.
- For simplicity I use LocalTime library for the start and end time of the trip. 
- I had to use comparator class to output driver summary record in the order specified.
