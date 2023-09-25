  public static void ordenarPorNombreInsercion(Nave[] flota) {
    for (int i = 1; i < flota.length; i++) {
      Nave naveActual = flota[i];
      int j = i - 1;

      while (j >= 0 && compararNombresMayor(flota[j].getNombre(), naveActual.getNombre())) {
        flota[j + 1] = flota[j];
        j--;
      }
        
      flota[j + 1] = naveActual;
    }

    System.out.println("Flota ordenada por nombres (inserción): ");
    for (int i = 0; i < flota.length; i++) {
        System.out.println((i + 1) + ". " + flota[i].getNombre());
    }
  }