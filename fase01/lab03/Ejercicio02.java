public class Ejercicio02 {
  /*
    escribir un programa donde se creen 2 ejércitos, cada uno con un número aleatorio de soldados entre
    1 y 5, considerando sólo su nombre. Sus datos se inicializan automáticamente con nombres tales como “Soldado0”,
    “Soldado1”, etc. Luego de crear los 2 ejércitos se deben mostrar los datos de todos los soldados de ambos ejércitos
    e indicar qué ejército fue el ganador.
    Restricción: aplicar arreglos estándar y métodos para inicializar los ejércitos, mostrar ejército y mostrar ejército
    ganador. La métrica a aplicar para indicar el ganador es el mayor número de soldados de cada ejército, puede
    haber empates. (Todavía no aplicar arreglo de objetos)
   */

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
