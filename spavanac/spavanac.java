// Problem link: https://open.kattis.com/problems/spavanac
// Live example link: https://repl.it/KFyX
// CPU running time: 0.13 s
// Status: Accepted

import java.util.Scanner;

public class spavanac {
  
  public static void printTheTime(int hour, int minute) {
    System.out.println(hour + " " + minute);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String time = scanner.nextLine();
    String [] times = time.split(" ");
    int hour = Integer.parseInt(times[0]);
    int minute = Integer.parseInt(times[1]);
    int differences = minute - 45;
    
    if (differences < 0) {
      differences = 45 - minute;
      if (hour == 0) {
        printTheTime(23, 60 - differences);
      } else {
        printTheTime(hour - 1, 60 - differences);
      }
    } else if (differences > 0) {
      printTheTime(hour, differences);
    }
    
    scanner.close();
  }
}
