// Problem link: https://open.kattis.com/problems/t9spelling
// Live example link: https://repl.it/KHMa
// CPU running time: 0.71 s
// Status: Accepted

import java.util.*;

public class t9spelling {
  
  // for example, Case #1: 44 444
  public static void printT9WithCaseNumber(int i, String t9) {
    System.out.println("Case #" + i + ": " + t9);
  }
  
  public static String [] translateCharacterToNumber(char singleCharacter) {
    Map<Integer, TreeSet<Character>> mapOfT9 = buildT9Map();
    double charInDec = (int) singleCharacter;
    String numberInString = "";
    int point = 0;
    
    // belongs to 2, 3, 4, 5, 6
    if (charInDec < 112) {
      double startingPtOfAscii = 99;
      int startingPtOfMap = 2;
      
      point = startingPtOfMap + (int) Math.ceil((charInDec - startingPtOfAscii) / 3);
      numberInString = Integer.toString(point);
    // belongs to 7, 8, 9
    } else {
      for (int i = 7; i < 10; i++) {
        if (mapOfT9.get(i).contains((char) singleCharacter)) {
          point = i;
          numberInString = Integer.toString(point);
          
          // make sure you leave right away when you find one
          break;
        }
      }
    }

    Iterator<Character> iterator = mapOfT9.get(point).iterator();

    // print as many times as you need
    while (iterator.hasNext() && iterator.next() != singleCharacter) {
      numberInString += Integer.toString(point);
    }
    
    // sending point back allows us to keep track of the previous point
    return new String[] {numberInString, Integer.toString(point)};
  }
  
  public static String getT9Spelling(String line) {
    String [] lineArray = line.split("");
    char nextChar;
    String result = "";
    int prevpoint = 0;
    
    for (int i = 0; i < lineArray.length; i++) {
      // when character is a space
      if (lineArray[i].charAt(0) == ' ') {
        // make sure we ignore the first one otherwise, we might get indexNotFound exception
        if (i > 0) {
          // when previous character is also a space then we need to add a space in-between
          if (lineArray[i-1].charAt(0) == ' ') {
            result += " ";
          }
        }
        // when we see a space, we add a "0"
        result += "0";
        // reset the prevpoint to the default value so that it works otherwise
        // cases like [space]a[space]b would work
        prevpoint = 0;
        // since it is a space, so we do not need to further check
        // just continue
        continue;
      }
      
      String [] resultOfNumbers = translateCharacterToNumber(lineArray[i].charAt(0));
      
      // when you see 'aa'
      // make sure to add a space in-between
      if (prevpoint == Integer.parseInt(resultOfNumbers[1])) {
        result += " ";
      }
      
      result += resultOfNumbers[0];
      prevpoint = Integer.parseInt(resultOfNumbers[1]);
    }

    return result;
  }
  
  // hard-coded the T9 as a map with TreeSet in there so that we preserve the order
  public static Map<Integer, TreeSet<Character>> buildT9Map() {
    Map<Integer, TreeSet<Character>> mapOfT9 = new HashMap<Integer, TreeSet<Character>>();
    
    mapOfT9.put(2, new TreeSet<Character>(Arrays.asList('a', 'b', 'c')));
    mapOfT9.put(3, new TreeSet<Character>(Arrays.asList('d', 'e', 'f')));
    mapOfT9.put(4, new TreeSet<Character>(Arrays.asList('g', 'h', 'i')));
    mapOfT9.put(5, new TreeSet<Character>(Arrays.asList('j', 'k', 'l')));
    mapOfT9.put(6, new TreeSet<Character>(Arrays.asList('m', 'n', 'o')));
    mapOfT9.put(7, new TreeSet<Character>(Arrays.asList('p', 'q', 'r', 's')));
    mapOfT9.put(8, new TreeSet<Character>(Arrays.asList('t', 'u', 'v')));
    mapOfT9.put(9, new TreeSet<Character>(Arrays.asList('w', 'x', 'y', 'z')));
    
    return mapOfT9;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfCases = scanner.nextInt();
    String line = scanner.nextLine();
    
    for (int i = 1; i < numberOfCases + 1; i++) {
      line = scanner.nextLine();
      
      printT9WithCaseNumber(i, getT9Spelling(line));
    }
    
    scanner.close();
  }
}
