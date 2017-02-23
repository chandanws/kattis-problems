// Problem link: https://open.kattis.com/problems/whatdoesthefoxsay
// Live example link: https://repl.it/Fugy
// CPU running time: 0.13 s
// Status: Accepted

import java.util.*;
import java.util.Scanner;

public class whatdoesthefoxsay {
  
  // format of animalsVoice, <animal> goes <sound>
  // For example, dog goes woof
  public static String getSound(String animalsVoice) {
    return animalsVoice.split(" ")[2];
  }
  
  public static String [] turnFullOfAnimalsVoicesIntoList(String fullOfAnimalsVoices) {
    return fullOfAnimalsVoices.split(" ");
  }
  
  public static void filteredOtherAnimalsSound(String fullOfAnimalsVoices, Set<String> listOfEachAnimalsSound) {
    String [] listOfAnimalsVoices = turnFullOfAnimalsVoicesIntoList(fullOfAnimalsVoices);
    String filteredAnimalsSound = "";
    
    for (int i = 0; i < listOfAnimalsVoices.length; i++) {
      if (!listOfEachAnimalsSound.contains(listOfAnimalsVoices[i])) {
        filteredAnimalsSound += listOfAnimalsVoices[i] + " ";
      }
    }
    System.out.println(filteredAnimalsSound.trim());
  }
  
  public static void whatDoesTheFoxSay(Scanner scanner) {
    // get all the animals' voices in the forest at once
    String fullOfAnimalsVoices = scanner.nextLine();
    
    Set<String> listOfEachAnimalsSound = new HashSet<String>();
    String nextAnimalSound = scanner.nextLine();
    
    // get each animals' voice
    while(!nextAnimalSound.equals("what does the fox say?")) {
      listOfEachAnimalsSound.add(getSound(nextAnimalSound));
      nextAnimalSound = scanner.nextLine();
    }
    filteredOtherAnimalsSound(fullOfAnimalsVoices, listOfEachAnimalsSound);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfTests = Integer.parseInt(scanner.nextLine());
    
    while(numberOfTests > 0) {
      whatDoesTheFoxSay(scanner);
      numberOfTests--;
    }
    scanner.close();
  }
}
