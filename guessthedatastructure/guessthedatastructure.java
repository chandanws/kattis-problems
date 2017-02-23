// Problem link: https://open.kattis.com/problems/guessthedatastructure
// Live example link: 
// CPU running time: 1.14 s
// Status: Not accepted

import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

class Queue<E> {
   private LinkedList<E> list = new LinkedList<E>();
   
   public void enqueue(E item) {
      list.addLast(item);
   }
   
   public E top() {
      return list.peek();
   }
   
   public E dequeue() {
      return list.poll();
   }
   
   public boolean isEmpty() {
     return list.isEmpty();
   }
}

public class guessthedatastructure {
  
  public static boolean whichOper(String oper) {
    return Integer.parseInt(oper.split(" ")[0]) == 1;
  }
  
  public static int getItem(String oper) {
    return Integer.parseInt(oper.split(" ")[1]);
  }
  
  public static boolean checkForQueue(ArrayList<String> listOfOpers) {
    Queue<Integer> qu = new Queue<Integer>();
    
    for(int i = 0; i < listOfOpers.size(); i++) {
      if (whichOper(listOfOpers.get(i))) {
        qu.enqueue(getItem(listOfOpers.get(i)));
      } else {
        try {
          if ((Integer) qu.top() != getItem(listOfOpers.get(i))) {
            return false;
          } else {
            qu.dequeue();
          }
        }catch (NullPointerException e) {
           return false;
        }
      }
    }
    
    return qu.isEmpty();
  }
  
  public static boolean checkForStack(ArrayList<String> listOfOpers) {
    Stack<Integer> st = new Stack<Integer>();
    
    for(int i = 0; i < listOfOpers.size(); i++) {
      if (whichOper(listOfOpers.get(i))) {
        st.push(getItem(listOfOpers.get(i)));
      } else {
        try {
          if ((Integer) st.peek() != getItem(listOfOpers.get(i))) {
            return false;
          } else {
            st.pop();
          }
        }catch (EmptyStackException e) {
           return false;
        }
      }
    }
    
    return st.isEmpty();
  }
  
  public static boolean checkForPQueue(ArrayList<String> listOfOpers) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
    
    for(int i = 0; i < listOfOpers.size(); i++) {
      if (whichOper(listOfOpers.get(i))) {
        pq.add(getItem(listOfOpers.get(i)));
      } else {
        try {
          if ((Integer) pq.peek() != getItem(listOfOpers.get(i))) {
            return false;
          } else {
            pq.poll();
          }
        }catch (NullPointerException e) {
           return false;
        }
      }
    }
  
    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfLines = Integer.parseInt(scanner.nextLine());
    String nextLine = "";
    ArrayList<String> listOfOpers = new ArrayList<String>();
    boolean isQ, isS, isPQ;
    
    while(true) {
      for(int i = 0; i < numberOfLines; i++) {
        listOfOpers.add(scanner.nextLine());
      }
      isQ = checkForQueue(listOfOpers);
      isS = checkForStack(listOfOpers);
      isPQ = checkForPQueue(listOfOpers);
      
      if ((isQ && isS) || (isQ && isPQ) || (isS && isPQ)) {
        System.out.println("not sure");
      } else if (isS) {
        System.out.println("stack");
      } else if (isQ) {
        System.out.println("queue");
      } else if (isPQ) {
        System.out.println("priority queue");
      } else {
        System.out.println("impossible");
      }
      listOfOpers.clear();
      
      try {
        numberOfLines = Integer.parseInt(scanner.nextLine());
      } catch (Exception e) {
        break;
      }
    }
    scanner.close();
  }
}
