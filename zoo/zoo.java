// Problem link: https://open.kattis.com/problems/zoo
// Live example link: https://repl.it/LXsM
// CPU running time: 0.18 s
// Status: Accepted

import java.util.*;
import java.util.Map.Entry;

public class Main {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int numberOfAnimals = Integer.parseInt(scanner.nextLine()), listNumber = 1;
    String nextAnimal = "", animalType = "";
    HashMap <String, Integer> animalMap = new HashMap<String, Integer>();
    ArrayList <String> animalTypesInOrder = new ArrayList<String>();

    while (numberOfAnimals != 0) {
      // for example,
      /* {
        "tiger": 3,
        "bear": 1,
        "elephant": 1
      } */
      for (int i = 0; i < numberOfAnimals; i++) {
        nextAnimal = scanner.nextLine();
        animalType = nextAnimal.split(" ")[nextAnimal.split(" ").length - 1].toLowerCase();
        if (animalMap.containsKey(animalType)) {
          animalMap.put(animalType, animalMap.get(animalType) + 1);
        } else {
          animalMap.put(animalType, 1);
        }
      }
      
      // to get alphabetical order
      for (String animal : animalMap.keySet()) {
        animalTypesInOrder.add(animal);
      }
      Collections.sort(animalTypesInOrder);
      
      System.out.println("List " + listNumber++ + ":");
      for (int i = 0; i < animalTypesInOrder.size(); i++) {
        System.out.println(animalTypesInOrder.get(i) + " | " + animalMap.get(animalTypesInOrder.get(i)));
      }
      
      animalMap.clear();
      animalTypesInOrder.clear();
      numberOfAnimals = Integer.parseInt(scanner.nextLine());
    }
  }
}
