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