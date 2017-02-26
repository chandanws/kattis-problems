// Problem link: https://open.kattis.com/problems/moneymatters
// Live example link: https://repl.it/FyQi
// CPU running time: 0.91 s
// Status: Accepted

import java.util.*;
import java.util.Scanner;

public class moneymatters {
  
  public static ArrayList<Boolean> visitedNode = new ArrayList<Boolean>();
  public static ArrayList<Integer> moneyOweOrOwnForEachPerson = new ArrayList<Integer>();
  public static Map<Integer, Set<Integer>> relationshipMap = new HashMap<Integer, Set<Integer>>();
  
  public static boolean dfs() {
    // go through each node, so that even through
    // it was not mention in friendship
    // it will still be covered
    for (int j = 0; j < moneyOweOrOwnForEachPerson.size(); j++) {
      // make sure we do not visit the same node twice
      if (visitedNode.get(j)) {
        continue;
      }
      
      int tempSum = 0, current;
      Stack<Integer> st = new Stack<Integer>();
      
      st.push(j);
      while (!st.isEmpty()) {
        current = st.pop();
  
        if (visitedNode.get(current)) {
          continue;
        }
        
        visitedNode.set(current, true);
        // keep adding the sum of these nodes in the graph
        tempSum += moneyOweOrOwnForEachPerson.get(current);
        
        // push all the neighbors for current node into the stack
        Iterator<Integer> iterator = relationshipMap.get(current).iterator();
        
        while (iterator.hasNext()) {
          Integer node = iterator.next();
          if (!visitedNode.get(node)) {
            st.push(node);
          }
        }
      }
      
      // the sum of all the nodes in the graph isn't even
      if (tempSum != 0) {
        return false;
      }
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String nextLine = scanner.nextLine();
    
    // for example, first line could be 5 3
    // which means that there are
    // Number of friend: 5
    // Number of remaining friendship: 3
    int numberOfFri = Integer.parseInt(nextLine.split(" ")[0]);
    int numberOfRFri = Integer.parseInt(nextLine.split(" ")[1]);
    
    // get how much each person owe or is owed
    // owe if negative number
    // is owed if positive number
    for (int i = 0; i < numberOfFri; i++) {
      moneyOweOrOwnForEachPerson.add(Integer.parseInt(scanner.nextLine()));
    }
    
    // if there were 5 people then we have
    // relationshipMap: {0=[], 1=[], 2=[], 3=[], 4=[]}
    // visitedNode: [false, false, false, false, false]
    for (int j = 0; j < numberOfFri; j++) {
      Set<Integer> newSet = new HashSet<Integer>();
      
      relationshipMap.put(j, newSet);
      visitedNode.add(j, false);
    }
    
    int x = 0, y = 0;
    
    for (int i = 0; i < numberOfRFri; i++) {
      nextLine = scanner.nextLine();
      
      // if x = 0 and y = 1, then that means that 0 and 1 are friend
      x = Integer.parseInt(nextLine.split(" ")[0]);
      y = Integer.parseInt(nextLine.split(" ")[1]);
      
      // setting directed graph to point from x to y
      relationshipMap.get(x).add(y);
      // setting directed graph to point from y to x
      relationshipMap.get(y).add(x);
    }

    if (dfs()) {
      System.out.println("POSSIBLE");
    } else {
      System.out.println("IMPOSSIBLE");
    }
    
    scanner.close();
  }
}
