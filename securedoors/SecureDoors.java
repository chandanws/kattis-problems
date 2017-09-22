// Problem link: https://open.kattis.com/problems/securedoors
// Live example link: https://repl.it/L4QC
// CPU running time: 0.24 s
// Status: Accepted

import java.util.*;

public class SecureDoors {
  private static final String ANOMALY = " (ANOMALY)";
  
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);
    HashSet <String> logSet = new HashSet <String>();
    int numberOfLines = Integer.parseInt(scanner.nextLine());
    String nextLine = "", action = "", name = "", result = "";
    
    for (int i = 0; i < numberOfLines; i++) {
      nextLine = scanner.nextLine();
      action = nextLine.split(" ")[0];
      name = nextLine.split(" ")[1];
      
      if (action.equals("entry")) {
        result = name + " entered";
        if (logSet.contains(name)) {
          result += ANOMALY;
        } else {
          logSet.add(name);
        }
      } else if (action.equals("exit")) {
        result = name + " exited";
        if (!logSet.contains(name)) {
          result += ANOMALY;
        } else {
          logSet.remove(name);
        }
      }
      
      System.out.println(result);
    }
  }
}
