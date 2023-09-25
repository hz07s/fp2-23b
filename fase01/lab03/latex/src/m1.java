  //Método para mostrar todas las naves con un número de puntos inferior o igual
  //al número de puntos que se pide por teclado
  public static void mostrarPorPuntos(Nave [] flota){
    Scanner sc = new Scanner(System.in);
    int puntos = sc.nextInt();

    for (int i = 0; i < flota.length; i++){
      if (flota[i].getPuntos() <= puntos){
        mostrarNave(flota[i]);
      }
    }
  }