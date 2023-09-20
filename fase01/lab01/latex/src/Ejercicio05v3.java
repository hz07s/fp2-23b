  public static void armyWinner(String[] army1, String[] army2) {
    if (army1.length > army2.length) {
      System.out.println("El ganador es el Ejercito Nro 1");
    } else if (army2.length > army1.length) {
      System.out.println("El ganador es el Ejercito Nro 2");
    } else {
      System.out.println("Es un empate entre los ejercitos");
    }
  }