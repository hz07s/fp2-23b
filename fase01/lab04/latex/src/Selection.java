  public static void ordenarPorNombreSeleccion(Nave[] flota){
    for (int i = 0; i < flota.length - 1; i++) {
      int nombreMin = i;
      for (int j = i + 1; j < flota.length; j++) {
          if (compararNombresMayor(flota[j].getNombre(), flota[i].getNombre())) {
              nombreMin = j;
          }
      }
      intercambiar(flota, nombreMin, i);
    }
  }