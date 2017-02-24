// Problem link: https://open.kattis.com/problems/babelfish
// Live example link: https://repl.it/FwTr
// CPU running time: 2.00 s
// Status: Accepted

import java.util.*;
import java.util.Scanner;

class Main {
  
  // line could be "dog ogday"
  // return dog
  public static String getEnglishWord(String line) {
    return line.split(" ")[0];
  }
  
  // line could be "dog ogday"
  // return ogday
  public static String getForeignWord(String line) {
    return line.split(" ")[1];
  }
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Hashtable<String, String> dict = new Hashtable<String, String>();
    String nextLine = scanner.nextLine();
    
    // put all the foreign words to the dict
    while(!nextLine.isEmpty()) {
      dict.put(getForeignWord(nextLine), getEnglishWord(nextLine));
      nextLine = scanner.nextLine();
    }
    
    String nextWord = scanner.nextLine();
    
    while(!nextWord.isEmpty()) {
      // check if dict has the word
      if (dict.get(nextWord) != null) {
        System.out.println(dict.get(nextWord));
      } else {
        // no word found
        System.out.println("eh");
      }
      
      try {
        nextWord = scanner.nextLine();
      } catch (Exception e) {
        break;
      }
    }
    
    scanner.close();
  }
}
