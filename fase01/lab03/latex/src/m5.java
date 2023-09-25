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