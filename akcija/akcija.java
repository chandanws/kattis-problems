// Problem link: https://open.kattis.com/problems/akcija
// Live example link: https://repl.it/KLjz/1
// CPU running time: 0.83 s
// Status: Accepted

import java.util.*;
import java.lang.Math.*;
import java.util.Arrays;

public class akcija {
  
  public static int numberOfPossibleGroups(int numberOfBooks) {
    return (int) Math.ceil((double) numberOfBooks / 3);
  }
  
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfBooks = scanner.nextInt();
    int listOfBooks [] = new int[numberOfBooks];

    for (int i = 0; i < numberOfBooks; i++) {
      listOfBooks[i] = scanner.nextInt();
    }
    
    Arrays.sort(listOfBooks);
    
    int numberOfPossibleGroups = numberOfPossibleGroups(numberOfBooks);
    int j = 0, requiredMinimalPrice = 0;
    List<List<Integer>> groupsOfBooks = new ArrayList<List<Integer>>();
    
    for (int i = numberOfBooks - 1; i >= 0; i--) {
      try {
        if (groupsOfBooks.get(j).size() != 3) {
          groupsOfBooks.get(j).add(listOfBooks[i]);
        }
      } catch (IndexOutOfBoundsException e) {
        List<Integer> groupOfBooks = new ArrayList<Integer>();
        groupOfBooks.add(listOfBooks[i]);
        groupsOfBooks.add(groupOfBooks);
      }
      
      if (groupsOfBooks.get(j).size() == 3) {
        j++;
      } else {
        requiredMinimalPrice += listOfBooks[i];
      }
    }
    
    // System.out.println(Arrays.deepToString(groupsOfBooks.toArray()));
    System.out.println(requiredMinimalPrice);
    
    scanner.close();
  }
}
