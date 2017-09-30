// Problem link: https://open.kattis.com/problems/pot
// Live example link: https://repl.it/G76t
// CPU running time: 0.13 s
// Status: Accepted

import java.util.*;

public class pot {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int power = 0;
    String nextP = "";
    long sum = 0;
    
    for (int i = 0; i < n; i++) {
      nextP = scanner.nextLine();
      power = Integer.parseInt(nextP) % 10;
      nextP = nextP.substring(0, nextP.length() - 1);
      
      sum += Math.pow(Integer.parseInt(nextP), power);
    }
    
    System.out.print(sum);

    scanner.close();
  }
}
