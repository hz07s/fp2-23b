// Laboratorio Nro 01 - Ejercicio01
// Autor : Hernan Andy
// Colaboro : -

import java.util.Scanner;
class Ejercicio01 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el primer soldado: ");
    String soldier1 = sc.next();
    System.out.print("Ingrese el segundo soldado: ");
    String soldier2 = sc.next();
    System.out.print("Ingrese el tercer soldado: ");
    String soldier3 = sc.next();
    System.out.print("Ingrese el cuarto soldado: ");
    String soldier4 = sc.next();
    System.out.print("Ingrese el quinto soldado: ");
    String soldier5 = sc.next();
    
    System.out.println("Lista de soldados: ");
    System.out.println("Soldado Nro1 " + soldier1);
    System.out.println("Soldado Nro2 " + soldier2);
    System.out.println("Soldado Nro3 " + soldier3);
    System.out.println("Soldado Nro4 " + soldier4);
    System.out.println("Soldado Nro5 " + soldier5);
  }
}
