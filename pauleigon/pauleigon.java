// Problem link: https://open.kattis.com/problems/pauleigon
// Live example link: https://repl.it/GVuI
// CPU running time: 0.13 s
// Status: Accepted

import java.util.*;
import java.util.Scanner;

public class pauleigon {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String [] l = scanner.nextLine().split(" ");
    long totalRounds = Long.parseLong(l[1]) + Long.parseLong(l[2]) + 1;
    System.out.print(((int) Math.ceil((double) totalRounds / Long.parseLong(l[0]))) % 2 == 0 ? "opponent" : "paul");
  }
}
