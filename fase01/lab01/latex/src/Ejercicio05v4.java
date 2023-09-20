  public static void main(String[] args) {
    String[] army1 = createArmy();
    String[] army2 = createArmy();

    System.out.println("Ejercito Nro 1");
    showArmy(army1);
    System.out.println("\nEjercito Nro 2" );
    showArmy(army2);

    armyWinner(army1, army2);
  }