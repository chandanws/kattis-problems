// Problem link: https://open.kattis.com/problems/busnumbers
// Live example link: https://repl.it/KPHI
// CPU running time: 0.16 s
// Status: Accepted

import java.util.*;

public class busnumbers {
  
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);
    int previousBus = 0;
    int numberOfBuses = scanner.nextInt();
    String busesInLine = scanner.nextLine();
    String busesInString [] = scanner.nextLine().split(" ");
    int busesInInt [] = new int[numberOfBuses];
    int shortenModeCount = 0;
    int j = 0;
    
    for (String s: busesInString) {
      busesInInt[j++] = Integer.parseInt(s);
    }
    
    // here, we have to sort an int array instead of the String array
    // otherwise, 100 would treat it as smaller than 25
    Arrays.sort(busesInInt);

    for (int i = 0; i < numberOfBuses; i++) {
      // always print the first bus to start with
      if (previousBus == 0) {
        System.out.print(busesInInt[i]);
      // this happens when the number is different by more than 1 like 100 200
      } else if (busesInInt[i] - previousBus > 1) {
        // make sure to print the ending number if there are any
        // like 100-
        if (shortenModeCount > 0) {
          if (shortenModeCount > 1) {
            System.out.print("-");
          } else {
            System.out.print(" ");
          }
          System.out.print(previousBus + " " + busesInInt[i]);
          shortenModeCount = 0;
        } else {
          System.out.print(" " + busesInInt[i]);
        }
      // this happens when the number is different by 1 like 100 101
      } else if (busesInInt[i] - previousBus == 1) {
        shortenModeCount++;
      }
      
      previousBus = busesInInt[i];
    }
    
    // add the last bus back in
    if (shortenModeCount > 0) {
      if (shortenModeCount > 1) {
        System.out.print("-");
      } else {
        System.out.print(" ");
      }
      System.out.print(busesInInt[busesInInt.length - 1]);
    }
    
    scanner.close();
  }
}
