  public static void intercambiar(Nave[] flota, int i, int j){
    Nave temp = flota[i];
    flota[i] = flota[j];
    flota[j] = temp;
  }