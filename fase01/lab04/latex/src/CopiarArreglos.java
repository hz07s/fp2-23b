  public static Nave[] crearArreglo(Nave[] flota){
      Nave[] flotaNueva = new Nave[flota.length];
      System.arraycopy(flota, 0, flotaNueva, 0, flota.length);
      return flotaNueva;
    }
  }