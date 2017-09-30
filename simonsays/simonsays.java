// Problem link: https://open.kattis.com/problems/simonsays
// Live example link: https://repl.it/Lr0T
// CPU running time: 0.22 s
// Status: Accepted

import java.util.*;

public class simonsays {
  public static final String SIMONSAYS = "Simon says";
  
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOflines = Integer.parseInt(scanner.nextLine());
    String nextLine = "";
    
    for (int i = 0; i < numberOflines; i++) {
      nextLine = scanner.nextLine();
      if (nextLine.startsWith(SIMONSAYS)) {
        System.out.println(nextLine.split(SIMONSAYS)[1]);
      }
    }
  }
}
