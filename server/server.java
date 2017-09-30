// Problem link: https://open.kattis.com/problems/server
// Live example link: https://repl.it/Lrah
// CPU running time: 0.11 s
// Status: Accepted

import java.util.*;

public class server {
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);
    String nextLine = scanner.nextLine();
    int numberOfTasks = Integer.parseInt(nextLine.split(" ")[0]);
    int totalTimesAval = Integer.parseInt(nextLine.split(" ")[1]);
    String [] tasksInTime = scanner.nextLine().split(" ");
    int totalElapsed = 0, i;
    
    for (i = 0; i < numberOfTasks; i++) {
      totalElapsed += Integer.parseInt(tasksInTime[i]);
      if (totalElapsed > totalTimesAval) {
        break;
      }
    }
    System.out.println(i);
  }
}
