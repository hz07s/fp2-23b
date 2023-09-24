// Laboratorio Nro 02 - Ejercicio01
// Autor : Hernan Andy
// Colaboró : -
// Tiempo : -

import java.util.*;
public class DemoBatalla {
  public static void main(String [] args){
    Nave [] misNaves = new Nave[10];
    Scanner sc = new Scanner(System.in);
    String nomb, col;
    int fil, punt;
    boolean est;
    
    for (int i = 0; i < misNaves.length; i++) {
      System.out.println("Nave " + (i+1));
      System.out.print("Nombre: ");
      nomb = sc.next();
      System.out.println("Fila ");
      fil = sc.nextInt();
      System.out.print("Columna: ");
      col = sc.next();
      System.out.print("Estado: ");
      est = sc.nextBoolean();
      System.out.print("Puntos: ");
      punt = sc.nextInt();

      misNaves[i] = new Nave();
      misNaves[i].setNombre(nomb);
      misNaves[i].setFila(fil);
      misNaves[i].setColumna(col);
      misNaves[i].setEstado(est);
      misNaves[i].setPuntos(punt);
    }
    System.out.println("\nNaves creadas:");
    mostrarNaves(misNaves);
    mostrarPorNombre(misNaves);
    mostrarPorPuntos(misNaves);
    System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
  }

  //Método para mostrar todas las naves
  public static void mostrarNaves(Nave [] flota){
  }

  //Método para mostrar todas las naves de un nombre que se pide por teclado
  public static void mostrarPorNombre(Nave [] flota){
    Scanner sc = new Scanner(System.in);
    String name = sc.next();

    for (int i = 0; i < flota.length; i++){
      if (flota[i].getNombre().equals(name))
        mostrarNave(flota[i]);
    }
  }

  //Método para mostrar todas las naves con un número de puntos inferior o igual
  //al número de puntos que se pide por teclado
  public static void mostrarPorPuntos(Nave [] flota){
    Scanner sc = new Scanner(System.in);
    int puntos = sc.nextInt();

    for (int i = 0; i < flota.length; i++){
      if (flota[i].getPuntos() <= puntos){
        mostrarNave(flota[i]);
      }
    }
  }
  public static void mostrarNave(Nave nave){

  }

  //Método que devuelve la Nave con mayor número de Puntos
  public static Nave mostrarMayorPuntos(Nave [] flota){
    return null;
  }

  //Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados //pero aleatoriamente desordenados
}