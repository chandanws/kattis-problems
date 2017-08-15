// Problem link: https://open.kattis.com/problems/averagespeed
// Live example link: https://repl.it/KHth/1
// CPU running time: 0.13 s
// Status: Accepted

import java.util.*;

public class averagespeed {
  
  public static double elapsedTime = 0;
  public static int currentAverageSpeed = 0;
  public static double distance = 0;
  
  public static void printHowFarWeHaveGone(String currentTime) {
    System.out.println(currentTime + " " + roundToTwoDec(distance) + " km");
  }
  
  public static String roundToTwoDec(double number) {
    if (number == 0) {
      return "0.00";
    }
    
    String result = "";
    
    result += (double) Math.round(number * 100) / 100;
    
    // when we have number like 25.0, it becomes 25.00
    if ((result.length() - result.indexOf('.')) == 2) {
      result += "0";
    }
    
    return result;
  }
  
  public static double convertFormattedTimeToHours(String formattedTime) {
    String [] times = formattedTime.split(":");
    
    return (Double.valueOf(times[0])*60*60 +
           Double.valueOf(times[1])*60 +
           Double.valueOf(times[2])) / 3600;
  }
  
  public static void computeDistance(String [] query) {
    double formattedTimeInHours = convertFormattedTimeToHours(query[0]);
    
    distance += (formattedTimeInHours - elapsedTime) * currentAverageSpeed;
    elapsedTime = formattedTimeInHours;
    
    // no new speed, lets print out how far we have traveled
    if (query.length == 1) {
      printHowFarWeHaveGone(query[0]);
    // there is a new speed, lets continue counting...
    } else if (query.length == 2) {
      currentAverageSpeed = Integer.parseInt(query[1]);
    }
  }
  
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);

    while(scanner.hasNextLine()) {
      computeDistance(scanner.nextLine().split(" "));
    }

    scanner.close();
  }
}
