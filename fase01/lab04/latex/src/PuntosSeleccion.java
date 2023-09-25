  public static void ordenarPorPuntosSeleccion(Nave[] flota){
    for (int i = 0; i < flota.length - 1; i++) {
      int puntosMin = i;
      for (int j = i + 1; j < flota.length; j++) {
          if (flota[j].getPuntos() < flota[i].getPuntos()) {
              puntosMin = j;
          }
      }
      intercambiar(flota, puntosMin, i);
    }
  }