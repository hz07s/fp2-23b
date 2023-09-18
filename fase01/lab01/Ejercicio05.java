// Laboratorio Nro 01 - Ejercicio05
// Autor : Hernan Andy
// Colaboró : -
// Tiempo : -

class Ejercicio05 {
  public static void main(String[] args) {
    String[] army1 = createArmy();
    String[] army2 = createArmy();
    
    System.out.println("Ejercito Nro 1");
    showArmy(army1);
    System.out.println("\nEjercito Nro 2" );
    showArmy(army2);
    
    armyWinner(army1, army2);
  }

  public static String[] createArmy() {
    int n = (int) (Math.random() * 5) + 1;
    
    String [] army = new String[n];
    for (int i = 0; i < n; i++) {
      army[i] = "Soldado" + i; 
    }

    return army;
  }

  public static void showArmy(String[] army) {
    for (int i = 0; i < army.length; i++) {
      System.out.println(army[i]);
    }
  }

  public static void armyWinner(String[] army1, String[] army2) {
    if (army1.length > army2.length) {
      System.out.println("El ganador es el Ejercito Nro 1");
    } else if (army2.length > army1.length) {
      System.out.println("El ganador es el Ejercito Nro 2");
    } else {
      System.out.println("Es un empate entre los ejercitos");
    }
  }
}