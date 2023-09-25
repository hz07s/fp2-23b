  public static void ordenarPorNombreBurbuja(Nave[] flota){
    for (int i = 1; i < flota.length; i++)
      for (int j = 0; j < flota.length - i; j++)
        if ((int)flota[j].getNombre().charAt(0) > (int)flota[j+1].getNombre().charAt(0))
          intercambiar(flota, j, j+1);
  }