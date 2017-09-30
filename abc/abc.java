// Problem link: https://open.kattis.com/problems/abc
// Live example link: https://repl.it/FyS7
// CPU running time: 0.12 s
// Status: Accepted

import java.util.*;

public class abc {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String [] threePos = scanner.nextLine().split(" ");
    int [] threePosInt = {
      Integer.parseInt(threePos[0]),
      Integer.parseInt(threePos[1]),
      Integer.parseInt(threePos[2])
    };
    String lineOfABC = scanner.nextLine();
    
    Arrays.sort(threePosInt);
    
    String line = "";

    for(int i : lineOfABC.toCharArray()) {
      if (i % 65 == 0) {
        line += threePosInt[0] + " ";
      } else if (i % 65 == 1) {
        line += threePosInt[1] + " ";
      } else if (i % 65 == 2) {
        line += threePosInt[2] + " ";
      }
    }
    
    System.out.print(line.trim());

    scanner.close();
  }
}
