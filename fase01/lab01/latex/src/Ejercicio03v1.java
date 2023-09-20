// Laboratorio Nro 01 - Ejercicio03
// Autor : Hernan Andy
// Colaboró : -
// Tiempo : -

import java.util.Scanner;
class Ejercicio03 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] soldiers = new String[5];

    for (int i = 0; i < soldiers.length; i++) {
      System.out.print("Ingrese el nombre del soldado Nro " + (i + 1) + " : ");
      soldiers[i] = sc.next();
    }


  }
}