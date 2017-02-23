// Problem link: https://open.kattis.com/problems/jabuke
// Live example link: https://repl.it/FudX
// CPU running time: 0.16 s
// Status: Accepted

import java.util.Scanner;
import java.util.ArrayList;

public class jabuke {
  
  public static int getX(String pts) {
    return Integer.parseInt(pts.split(" ")[0]);
  }

  public static int getY(String pts) {
    return Integer.parseInt(pts.split(" ")[1]);
  }

  public static double getArea(ArrayList<String> landPts) {
    int xa = getX(landPts.get(0)), ya = getY(landPts.get(0)),
        xb = getX(landPts.get(1)), yb = getY(landPts.get(1)),
        xc = getX(landPts.get(2)), yc = getY(landPts.get(2));

    return Math.abs(xa * (yb - yc) + xb * (yc - ya) + xc * (ya - yb)) / 2.0;
  }
  
  public static boolean isPointInsideTriangle(ArrayList<String> landPts, String treePts) {
    
    // Calculate area of triangle ABC
    double A = getArea(landPts);
    
    ArrayList<String> pts = new ArrayList<String>();
    
    // Calculate area of triangle PBC
    pts.add(treePts);
    pts.add(landPts.get(1));
    pts.add(landPts.get(2));
    double A1 = getArea(pts);
 
    // Calculate area of triangle PAC
    pts.clear();
    pts.add(treePts);
    pts.add(landPts.get(0));
    pts.add(landPts.get(2));
    double A2 = getArea(pts);
 
    // Calculate area of triangle PAB
    pts.clear();
    pts.add(treePts);
    pts.add(landPts.get(0));
    pts.add(landPts.get(1));
    double A3 = getArea(pts);
    
    return (A == A1 + A2 + A3);
  }

  public static int countTheNumberOfAppleTrees(ArrayList<String> landPts, ArrayList<String> treesPts) {
    int numberOfTrees = 0;
    
    for (int i = 0; i < treesPts.size(); i++) {
      if (isPointInsideTriangle(landPts, treesPts.get(i))) {
        numberOfTrees++;
      }
    }
        
    return numberOfTrees;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> landPts = new ArrayList<String>();

    // get all the pts of the land
    for (int i = 0; i < 3; i++) {
      landPts.add(scanner.nextLine());
    }

    // get the number of trees
    int numberOfTrees = Integer.parseInt(scanner.nextLine());

    ArrayList<String> treesPts = new ArrayList<String>();

    // get all the pts of the trees
    for (int i = 0; i < numberOfTrees; i++) {
      treesPts.add(scanner.nextLine());
    }

    System.out.printf("%.1f\n%d", getArea(landPts), countTheNumberOfAppleTrees(landPts, treesPts));
    
    scanner.close();
  }
}
