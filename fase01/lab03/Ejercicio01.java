import java.util.Scanner;

public class Ejercicio01 {
  //Solucionar la Actividad 4 de la Práctica 1 pero usando arreglo de objetos
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    Soldier [] soldiers = new Soldier[5];

    for (int i = 0; i < soldiers.length; i++) {
      System.out.print("Ingrese el nombre del soldado Nro " + (i + 1) + " : ");
      soldiers[i].setNombre(sc.next());

      System.out.print("Vida: ");
      soldiers[i].setVida(sc.nextInt());
    }

    for (int i = 0; i < soldiers.length; i++) {
      System.out.println("Soldado Nro " + (i + 1) + ": " + soldiers[i].getNombre() + " - vida: " + soldiers[i].getVida());
    }
  }
}
