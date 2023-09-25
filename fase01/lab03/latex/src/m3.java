  //Método que devuelve la Nave con mayor número de Puntos
  public static Nave mostrarMayorPuntos(Nave [] flota){
    int min = flota[0].getPuntos();
    int positionNave = 0;
    for (int i = 1; i < flota.length; i++){
      if (flota[i].getPuntos() > min){
        min = flota[i].getPuntos();
        positionNave = i;
      }
    }
    return flota[positionNave];
  }