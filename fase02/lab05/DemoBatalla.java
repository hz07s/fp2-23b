// Laboratorio Nro 05 - Ejercicio01
// Autor : Hernan Andy
// Colaboro : -
// Tiempo : -
//import java.util.*;
public class DemoBatalla {
  static Soldado[][] army = new Soldado[10][10];
  static Soldado[] army1D = new Soldado[10];
  public static void main(String [] args){
  createArmy(army);
  showArmyData(army1D);
  showArmyTable(army);
  }

  public static void createArmy(Soldado army[][]){
    int numSoldiers = (int) (Math.random() * 10) + 1;
    
    for (int i = 0; i < numSoldiers; i++){
      int row, col;
      
      do {
        row = (int) (Math.random() * 9) + 1;
        col = (int) (Math.random() * 9) + 1;
      } while (army[row][col] != null);

      Soldado s = new Soldado("Soldier" + i, row + 1, (char) (col + 'A'), true, (int) (Math.random() * 5) + 1);
      army1D[i] = s;
      army[row][col] = s;

    }
  }

  public static void showArmyTable(Soldado[][] army){
    String linesUp = "  |       |       |       |       |       |       |       |       |       |       |";

    String linesDown = "  |_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|";

    System.out.println("      A      B      C      D      E      F      G      H      I      J\n"
                      +"   _______________________________________________________________________________");
    for (int r = 0; r < army.length; r++){
      System.out.println(linesUp);
      System.out.print(r+1 + " |");
      for (int c = 0; c < army[r].length; c++){
        System.out.print((army[r][c] != null) ?" Sold" + army[r][c].getName().charAt(7) + " |" : "       |");
        
      }
      System.out.println("\n" + linesDown);
    }

    /*
    Example:
        A      B      C      D      E      F      G      H      I      J    
     _______________________________________________________________________
    |       |       |       |       |       |       |       |       |       |
    |  S 1  |       |       |       |       |       |       |       |       |
    |_______|_______|_______|_______|_______|_______|_______|_______|_______|




     */
  }

  public static void showArmyData(Soldado[] army1D){
    for (Soldado s : army1D)
      System.out.println(s);
  }
}