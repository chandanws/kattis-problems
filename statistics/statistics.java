// Problem link: https://open.kattis.com/problems/statistics
// Live example link: https://repl.it/GVrq
// CPU running time: 0.12 s
// Status: Accepted

import java.util.*;
import java.util.Scanner;
import java.text.MessageFormat;

public class statistics {
  
  public static String [] readSamples(String samples) {
    return samples.split(" ");
  }
  
  public static void printTestCaseResult(int index, int min, int max) {
    System.out.println(MessageFormat.format("Case {0}: {1} {2} {3}", index, Long.toString(min), Long.toString(max), Long.toString(max - min)));
  }
  
  public static void analyzedTheSample(String testCase, int indexOfTestCase) {
    int min = 1000001, max = -1000001, nextInt = 0;
    String [] samples = readSamples(testCase);
    
    if (samples.length == 2) {
      printTestCaseResult(indexOfTestCase, Integer.parseInt(samples[1]), Integer.parseInt(samples[1]));
    } else {
      for (int i = 1; i < samples.length; i++) {
        nextInt = Integer.parseInt(samples[i]);
        
        if (nextInt < min) {
          min = nextInt;
        }
        
        if (nextInt > max) {
          max = nextInt;
        }
      }
      
      printTestCaseResult(indexOfTestCase, min, max);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = 1;
    String nextTestCase = scanner.nextLine();
    
    while(!nextTestCase.isEmpty()) {
      analyzedTheSample(nextTestCase, i++);
      
      try {
        nextTestCase = scanner.nextLine();
      } catch (Exception e) {
        break;
      }
    }
    
    scanner.close();
  }
}
