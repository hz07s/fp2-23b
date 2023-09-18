// Laboratorio Nro 01 - Ejercicio03
// Autor : Hernan Andy
// Colaboró : -
// Tiempo : -

import java.util.Scanner;
class Ejercicio04 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    String[] soldiers = new String[5];
    int[] healt = new int[5];

    for (int i = 0; i < soldiers.length; i++) {
      System.out.print("Ingrese el nombre del soldado Nro " + (i + 1) + " : ");
      soldiers[i] = sc.next();
    }

    for (int i = 0; i < healt.length; i++) {
      System.out.print("Ingrese la vida del soldado Nro " + (i + 1) + " : ");
      healt[i] = sc.nextInt();
    }

    for (int i = 0; i < soldiers.length; i++) {
      System.out.println("Soldado Nro " + (i + 1) + " : " + soldiers[i]);
    }

  }
}