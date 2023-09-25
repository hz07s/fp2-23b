// Laboratorio Nro 02 - Ejercicio01
// Autor : Hernan Andy
// Colaboró : -
// Tiempo : -

import java.util.*;
public class DemoBatalla {
  public static void main(String [] args){
    Nave [] misNaves = new Nave[8];
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

      misNaves[i] = new Nave(); //Se crea un objeto Nave y se asigna su referencia a misNaves
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

    //leer un nombre
    //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
    System.out.println("Ingrese el nombre de la nave: (Busqueda Lineal)");
    String nombre = sc.next();
    int pos=busquedaLinealNombre(misNaves,nombre);

    ordenarPorPuntosBurbuja(misNaves);
    mostrarNaves(misNaves);
    ordenarPorNombreBurbuja(misNaves);
    mostrarNaves(misNaves);

    //mostrar los datos de la nave con dicho nombre, mensaje de “no encontrado” en caso contrario
    pos=busquedaBinariaNombre(misNaves,nombre);
    ordenarPorPuntosSeleccion(misNaves);
    mostrarNaves(misNaves);
    ordenarPorPuntosInsercion(misNaves);
    mostrarNaves(misNaves);
    ordenarPorNombreSeleccion(misNaves);
    mostrarNaves(misNaves);
    ordenarPorNombreInsercion(misNaves);
    mostrarNaves(misNaves);
  }
  //Método para mostrar todas las naves
  public static void mostrarNaves(Nave [] flota){
    System.out.println("Naves ingresadas: ");
    for (int i = 0; i < flota.length; i++){
      mostrarNave(flota[i]);
    }
  }

  //Método para mostrar todas las naves de un nombre que se pide por teclado
  public static void mostrarPorNombre(Nave [] flota){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un nombre: ");
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
    System.out.println("Ingrese una cantidad de puntos: ");
    int puntos = sc.nextInt();

    for (int i = 0; i < flota.length; i++){
      if (flota[i].getPuntos() <= puntos){
        mostrarNave(flota[i]);
      }
    }
  }
  public static void mostrarNave(Nave nave){
    System.out.println("\n Nave: " + nave.getNombre());
    if (nave.getEstado())
      System.out.println("Estado : Alive");
      else
      System.out.println("Estado : Dead");
    System.out.println("Puntos : " + nave.getPuntos());
    
  }

  //Método que devuelve la Nave con mayor número de Puntos
  public static Nave mostrarMayorPuntos(Nave [] flota){
    int min = flota[0].getPuntos();
    int positionNave = 0;
    for (int i = 1; i < flota.length; i++){
      if (flota[i].getPuntos() > min){
        min = flota[i].getPuntos();
        positionNave = i;
      }
    }
    return flota[positionNave];
  }

  //Crear un método que devuelva un nuevo arreglo de objetos con todos los objetos previamente ingresados 
  //pero aleatoriamente desordenados

  public static Nave [] desordenarFlota(Nave flota []){
    Nave [] flotaRandom = new Nave [flota.length];
    for (int i = 0; i < flota.length; i++) {
      int r = (int)Math.random() * 10;
      while (flotaRandom[r] != null){
        r = (int)Math.random() * 10;
      }
      flotaRandom [r] = flota[i];
    }

    return flotaRandom;
  }

  //Método para buscar la primera nave con un nombre que se pidió por teclado
  public static int busquedaLinealNombre(Nave[] flota, String s){
    for (int i = 0; i < flota.length; i++){
      if (flota[i].getNombre().equals(s))
        return i;
    }
    System.out.println("No se encontro");
    return -1;
  }
  //Método que ordena por número de puntos de menor a mayor
  public static void ordenarPorPuntosBurbuja(Nave[] flota){
    for (int i = 1; i < flota.length; i++)
      for (int j = 0; j < flota.length - i; j++)
        if (flota[j].getPuntos() > flota[j+1].getPuntos())
          intercambiar(flota, j, j+1);
  }
  //Método que ordena por nombre de A a Z
  public static void ordenarPorNombreBurbuja(Nave[] flota){
    for (int i = 1; i < flota.length; i++)
      for (int j = 0; j < flota.length - i; j++)
        if ((int)flota[j].getNombre().charAt(0) > (int)flota[j+1].getNombre().charAt(0))
          intercambiar(flota, j, j+1);
  }
  //Método para buscar la primera nave con un nombre que se pidió por teclado
  public static int busquedaBinariaNombre(Nave[] flota, String s){
    ordenarPorNombreBurbuja(flota);
    int baja = 0; int media; int alta = flota.length;

    while (baja <= alta){
      media = (alta + baja) / 2;
      if (flota[media].getNombre().equals(s))
        return media;
      else if (compararNombresMayor(s, flota[media].getNombre()))
        alta = media - 1;
        else
          baja = media + 1;
    }
    return -1;
  }
  //Método que ordena por número de puntos de menor a mayor
  public static void ordenarPorPuntosSeleccion(Nave[] flota){
  }
  //Método que ordena por nombre de A a Z
  public static void ordenarPorNombreSeleccion(Nave[] flota){
  }
  //Método que muestra las naves ordenadas por número de puntos de mayor a menor
  public static void ordenarPorPuntosInsercion(Nave[] flota){
  }
  //Método que muestra las naves ordenadas por nombre de Z a A
  public static void ordenarPorNombreInsercion(Nave[] flota){
  }
  public static Nave[] crearArreglo(Nave[] flota){
    Nave[] flotaNueva = new Nave[flota.length];
    System.arraycopy(flota, 0, flotaNueva, 0, flota.length);
    return flotaNueva;
  }
  public static void intercambiar(Nave[] flota, int i, int j){
    Nave temp = flota[i];
    flota[i] = flota[j];
    flota[j] = temp;
  }
  public static boolean compararNombresMayor(String s1, String s2){
    int n = Math.min(s1.length(), s2.length());
    for (int i = 0; i < n; i++)   
      if ((int)s1.charAt(i) < (int)s2.charAt(i))
        return true;
    return false;
  }
}