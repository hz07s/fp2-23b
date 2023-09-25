  public static void ordenarPorPuntosInsercion(Nave[] flota){
    for (int i = 1; i < flota.length; i++) {
      int puntos = flota[i].getPuntos();
      int j = i - 1;

      while (j >= 0 && flota[j].getPuntos() > puntos) {
          flota[j + 1] = flota[j];
          j--;
      }
      flota[j + 1].setPuntos(puntos);
    }

    System.out.println("Flota ordenada por puntos (insercion): ");
    for (int i = 0; i <  flota.length; i++){
      System.out.println(flota[i].getNombre() + ": " + flota[i].getPuntos());
    }
  }