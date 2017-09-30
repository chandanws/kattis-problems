// Problem link: https://open.kattis.com/problems/areal
// Live example link: https://repl.it/LrcB
// CPU running time: 0.14 s
// Status: Accepted

import java.util.*;
import java.lang.Math.*;

public class areal {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(Math.sqrt(Float.parseFloat(scanner.nextLine()))*4);
  }
}
