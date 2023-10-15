// Laboratorio Nro 05 - Ejercicio01
// Autor : Hernan Andy
// Colaboro : -
// Tiempo : -
import java.util.*;
public class DemoBatalla {
  static Soldado[][] army = new Soldado[10][10];
  public static void main(String [] args){
  createArmy(army);
  for (int i = 0; i < army.length; i++)
    for (int k = 0; k < army[i].length; k++)
      System.out.println(army[i][k]);
  }

  public static void createArmy(Soldado army[][]){
    int numSoldiers = (int) (Math.random() * 10);
    
    for (int i = 0; i < numSoldiers; i++){
      int row = 0, col = 0;
      
      do {
        row = (int) (Math.random() * 9) + 1;
        col = (int) (Math.random() * 9) + 1;
      } while (army[row][col] == null);

      Soldado s = new Soldado("Soldier" + i, row, (char) (col + 'A'), true, (int) (Math.random() * 5) + 1);
      army[row][col] = s;

    }
  }


  

}