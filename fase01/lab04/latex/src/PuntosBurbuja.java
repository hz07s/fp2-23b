  public static void ordenarPorPuntosBurbuja(Nave[] flota){
    for (int i = 1; i < flota.length; i++)
      for (int j = 0; j < flota.length - i; j++)
        if (flota[j].getPuntos() > flota[j+1].getPuntos())
          intercambiar(flota, j, j+1);
  }