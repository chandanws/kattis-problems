// Problem link: https://open.kattis.com/problems/autori
// Live example link: https://repl.it/KHp8
// CPU running time: 0.12 s
// Status: Accepted

import java.util.*;

public class autori {
  public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    String [] names = name.split("-");
    String nameInShort = "";
    
    for (int i = 0; i < names.length; i++) {
      nameInShort += names[i].split("")[0];
    }
    
    System.out.println(nameInShort);
  }
}
