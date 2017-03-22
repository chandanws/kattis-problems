// Problem link: https://open.kattis.com/problems/modulo
// Live example link: https://repl.it/G74e
// CPU running time: 0.13 s
// Status: Accepted

import java.util.*;
import java.util.Scanner;

public class modulo {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Set<Integer> s = new HashSet<Integer>();
    
    for (int i = 0; i < 10; i++) {
      s.add(Integer.parseInt(scanner.nextLine()) % 42);
    }
    
    System.out.print(s.size());

    scanner.close();
  }
}
