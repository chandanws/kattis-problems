// Problem link: https://open.kattis.com/problems/aaah
// Live example link: https://repl.it/FyR8
// CPU running time: 0.14 s
// Status: Accepted

import java.util.*;
import java.util.Scanner;

public class aaah {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String lineFromJon = scanner.nextLine();
    String lineFromDoctor = scanner.nextLine();
    
    if (lineFromJon.split("").length < lineFromDoctor.split("").length) {
      System.out.print("no");
    } else {
      System.out.print("go");
    }
    
    scanner.close();
  }
}
