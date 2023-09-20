// Laboratorio Nro 01 - Ejercicio02
// Autor : Hernan Andy
// Colaboró : -
// Tiempo : -

import java.util.Scanner;
class Ejercicio02 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese el nombre del primer soldado: ");
    String soldier1 = sc.next();
    System.out.print("Vida: ");
    int healt1 = sc.nextInt();
    System.out.print("Ingrese el segundo soldado: ");
    String soldier2 = sc.next();
    System.out.print("Vida: ");
    int healt2 = sc.nextInt();
    System.out.print("Ingrese el tercer soldado: ");
    String soldier3 = sc.next();
    System.out.print("Vida: ");
    int healt3 = sc.nextInt();
    System.out.print("Ingrese el cuarto soldado: ");
    String soldier4 = sc.next();
    System.out.print("Vida: ");
    int healt4 = sc.nextInt();
    System.out.print("Ingrese el quinto soldado: ");
    String soldier5 = sc.next();
    System.out.print("Vida: ");
    int healt5 = sc.nextInt();
    
    System.out.println("Lista de soldados: ");
    System.out.println("Soldado Nro1 : " + soldier1 + " - vida :" + healt1);
    System.out.println("Soldado Nro2 : " + soldier2 + " - vida :" + healt2);
    System.out.println("Soldado Nro3 : " + soldier3 + " - vida :" + healt3);
    System.out.println("Soldado Nro4 : " + soldier4 + " - vida :" + healt4);
    System.out.println("Soldado Nro5 : " + soldier5 + " - vida :" + healt5);
  }
}
