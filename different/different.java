// Problem link: https://open.kattis.com/problems/different
// Live example link: https://repl.it/KJxu/1
// CPU running time: 0.11 s
// Status: Accepted

import java.util.*;

public class different {

  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);
    String nextLine = "";
    
    while(scanner.hasNextLine()) {
      nextLine = scanner.nextLine();
      
      System.out.println(
        Math.abs(
          Long.parseLong(nextLine.split(" ")[0]) -
          Long.parseLong(nextLine.split(" ")[1])
        )
      );
    }

    scanner.close();
  }
}
