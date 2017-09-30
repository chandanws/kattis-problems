// Problem link: https://open.kattis.com/problems/bookingaroom
// Live example link: https://repl.it/GVpJ
// CPU running time: 0.11 s
// Status: Accepted

import java.util.*;

public class bookingaroom {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfAvailableRooms = 0, numberOfBookedRooms = 0;
    String roomInfo = scanner.nextLine();
    
    numberOfAvailableRooms = Integer.parseInt(roomInfo.split(" ")[0]);
    numberOfBookedRooms = Integer.parseInt(roomInfo.split(" ")[1]);
    
    if (numberOfAvailableRooms == numberOfBookedRooms) {
      System.out.print("too late");
    } else {
      Set<Integer> setOfBookedRoom = new HashSet<Integer>();
      
      for (int i = 1; i <= numberOfBookedRooms; i++) {
        setOfBookedRoom.add(Integer.parseInt(scanner.nextLine()));
      }
      
      for (int i = 1; i <= numberOfAvailableRooms; i++) {
        if (!setOfBookedRoom.contains(i)) {
          System.out.print(i);
          break;
        }
      }
    }
    
    scanner.close();
  }
}
