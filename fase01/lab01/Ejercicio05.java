// Laboratorio Nro 01 - Ejercicio05
// Autor : Hernan Andy
// Colaboró : -
// Tiempo : -

import java.util.Scanner;
class Ejercicio05 {
  public static void main(String[] args) {
    
  
  }

  public static String[] createArmy(int n) {
    String [] army = new String[n];
    for (int i = 0; i < n; i++) {
      army[i] = "Soldado" + i; 
    }

    return army;
  }

  public static void showArmy(String[] army) {
    for (int i = 0; i < army.length; i++) {
      System.out.println(army[i]);
    }
  }

  public static void armyWinner(String[] army1, String[] army2) {
    if (army1.length > army2.length) {
      System.out.println(" El ganador es el Ejercito Nro 1");
    } else if (army2.length > army1.length) {
      System.out.println("El ganador es el Ejercito Nro 2");
    } else {
      System.out.println("Es un empate entre los ejercitos");
    }
  }
}