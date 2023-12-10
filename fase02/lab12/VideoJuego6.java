// Laboratorio Nro 12 - Ejercicio01
// Autor : Hernan Andy
// Colaboro : null
// Tiempo : 3 horas
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VideoJuego6 {
  static HashMap <Integer, Soldado> army = new HashMap<>();
  static HashMap <Integer, Soldado> army1DA = new HashMap<>();
  static HashMap <Integer, Soldado> army1DB = new HashMap<>();
  public static void main(String [] args){
    VideoJuego6 videoJuego = new VideoJuego6();
    videoJuego.createArmy();
    videoJuego.mainInterfaz();
  }
  public void mainInterfaz(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Bienvenido...");

    System.out.println("1. Crear un nuevo ejercito" 
                      +"\n2. Mostrar los datos de los ejercitos" 
                      +"\n3. Mostrar la tabla con los ejercitos" 
                      +"\n4. Mostrar el promedio de vida de los ejercitos" 
                      +"\n5. Mostrar los soldados de ejercitos con mayor vida" 
                      +"\n6. Ordenar los soldados de ejercitos segun la vida" 
                      +"\n7. Mostrar ejercito ganador"
                      +"\n8. Salir del juego");
    int action = sc.nextInt();

    switch (action){
      case 1 -> { // Crear un nuevo ejercito
        army.clear();
        army1DA.clear();
        army1DB.clear();
        createArmy();
        mainInterfaz();
      }
      case 2 -> { // Mostrar los datos de los ejercitos
        System.out.println("DATOS DE LOS SOLDADOS CREADOS:\n");
        showArmyData(army1DA, 'A');
        showArmyData(army1DB, 'B');
        mainInterfaz();
      }
      case 3 -> { // Mostrar la tabla con los ejercitos
        showArmyTable(army);
        mainInterfaz();
      }
      case 4 -> { // Mostrar el promedio de vida de los ejercitos
        System.out.println("El promedio de vida del Ejercito A es: " + averageHealth(army1DA));
        System.out.println("El promedio de vida del Ejercito B es: " + averageHealth(army1DB));
        mainInterfaz();
      }
      case 5 -> { // Mostrar los soldados de ejercitos con mayor vida
        moreHelath(army1DA, 'A');
        moreHelath(army1DB, 'B');
        mainInterfaz();
      }
      case 6 -> { // Ordenar los soldados de ejercitos segun la vida
        System.out.println("\nEjercitos ordenados (bubbleSort) segun la vida: ");
        printArmyHealth(bubbleSort(army1DA), 'A');
        printArmyHealth(bubbleSort(army1DB), 'B');

        System.out.println("\nEjercitos ordenados (insertionSort) segun la vida: ");
        printArmyHealth(insertionSort(army1DA), 'A');
        printArmyHealth(insertionSort(army1DB), 'B');

        System.out.println("\nEjercitos ordenados (selectionSort) segun la vida: ");
        printArmyHealth(selectionSort(army1DA), 'A');
        printArmyHealth(selectionSort(army1DB), 'B');
        mainInterfaz();
      }
      case 7 -> { // Mostrar ejercito ganador
        armyWinnerHealth();
        mainInterfaz();
      }
      case 8 -> { // Salir del juego
        System.out.println("Fin.");
      }
      default -> {
        System.out.println("Selecciona una opcion valida");
        mainInterfaz();
      }
    }

    sc.close();
  }

  public void createArmy(){
    int numSoldiersA = (int) (Math.random() * 10) + 1;
    int numSoldiersB = (int) (Math.random() * 10) + 1;

    army1DA = createArmyTeam(numSoldiersA, army1DA, 'A');
    army1DB = createArmyTeam(numSoldiersB, army1DB, 'B');
  }

  public HashMap <Integer, Soldado> createArmyTeam(int numSoldiers, HashMap <Integer, Soldado> army1D, char t){
    for (int i = 0; i < numSoldiers; i++){
      int row, col;
      
      do {
        row = (int) (Math.random() * 10);
        col = (int) (Math.random() * 10);
      } while (army.containsKey(row * 10 + col));

      Soldado s = new Soldado(VideoJuego6.this,"Soldier" + i + "X" + t, row + 1, (char) (col + 'A'), t, 
                            (int)(Math.random() * 5) + 1, (int)(Math.random() * 5) + 1, (int)(Math.random() * 5) + 1,
                            0, "Defensiva", true);
      army1D.put(i, s);
      army.put(row * 10 + col, s);
    }
    /*
     * (VideoJuego6 VideoJuego6,String name, int row, char column, char team, 
                int attackLevel, int attackDefense, int lifeLevel, int actualLife, int speed, 
                String attitude, boolean lives){
     */
    return army1D;
  }

  public static void showArmyTable(HashMap <Integer, Soldado> army){
    System.out.println("\n                  TABLA CON LAS UBICACIONES DE LOS SOLDADOS CREADOS: \n");
    String linesDown = "   |_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|";
    System.out.println("       A       B       C       D       E       F       G       H       I       J\n"
                      +"    _______________________________________________________________________________");
    
    for (int r = 0; r < 10; r++){
      System.out.print("   |");
      for (int c = 0; c < 10; c++)
        System.out.print(" " + (army.get(r*10+c) != null ? ("\'" + army.get(r*10+c).getTeam() + "\'" 
        + "S" + army.get(r*10+c).getName().charAt(7) + " |") : "      |"));

      System.out.print("\n" + (r+1) + ((r != 9) ? "  |" : " |"));
      for (int c = 0; c < 10; c++)
        System.out.print(" " + (army.get(r*10+c) != null ? "HP: " + army.get(r*10+c).getActualLife() : "     ") + " |");
        
      System.out.println("\n" + linesDown );
    }
    System.out.println();
  }

  public static void showArmyData(HashMap <Integer, Soldado> army1D, char t){
    System.out.println("EJERCITO \"" + t + "\"");
    for (Soldado s : army1D.values())
      System.out.println(s);
  }

  public static void moreHelath(HashMap <Integer, Soldado> army1MH, char t){
    int maxHealth = -1;
    for(Soldado s : army1MH.values())
      if (s.getActualLife() > maxHealth)
        maxHealth = s.getActualLife();

    System.out.println("Soldado(s) con mayor vida del Ejercito " + t + ": ");
    for (Soldado s : army1MH.values()) 
      if (s.getActualLife() == maxHealth)
        System.out.println("Nombre: " + s.getName() + "  Vida: " + s.getActualLife());
    System.out.println();
  }

  public static double averageHealth(HashMap <Integer, Soldado> army1DAH){
    return sumHealth(army1DAH) / army1DAH.size();
  }

  public static int sumHealth(HashMap <Integer, Soldado> army1DSH){
    int sum = 0;
    for (Soldado s : army1DSH.values())
      sum += s.getActualLife();
    return sum;
  }

  public static HashMap <Integer, Soldado> bubbleSort(HashMap <Integer, Soldado> army1DBS){
    HashMap<Integer, Soldado> army1DCopyBubble = new HashMap<>(army1DBS);
    int n = army1DCopyBubble.size();
    boolean swapped;
    for (int i = 0; i < n - 1; i++) {
      swapped = false;
      for (int j = 0; j < n - i - 1; j++)
        if (army1DCopyBubble.get(j).getActualLife() < army1DCopyBubble.get(j+1).getActualLife()) {
          Soldado temp = army1DCopyBubble.get(j);
          army1DCopyBubble.put(j, army1DCopyBubble.get(j+1));
          army1DCopyBubble.put(j+1, temp);
          swapped = true;
        }
      if (!swapped)
        break;
    }
    return army1DCopyBubble;
  }

  public static HashMap <Integer, Soldado> insertionSort(HashMap <Integer, Soldado> army1DIS) {
    int n = army1DIS.size();
    HashMap<Integer, Soldado> army1DCopyInsertion = new HashMap<>(army1DIS);

    for (int i = 1; i < n; i++) {
      Soldado key = army1DCopyInsertion.get(i);
      int j = i - 1;

      while (j >= 0 && army1DCopyInsertion.get(j).getActualLife() < key.getActualLife()) {
        army1DCopyInsertion.put(j+1, army1DCopyInsertion.get(j));
        j = j - 1;
      }
      army1DCopyInsertion.put(j+1, key);
    }
    return army1DCopyInsertion;
  }

  public static HashMap <Integer, Soldado> selectionSort(HashMap <Integer, Soldado> army1DSS) {
    int n = army1DSS.size();
    HashMap<Integer, Soldado> army1DCopySelection = new HashMap<>(army1DSS);
  
    for (int i = 0; i < n - 1; i++) {
      int min_idx = i;
  
      for (int j = i + 1; j < n; j++)
        if (army1DCopySelection.get(j).getActualLife() > army1DCopySelection.get(min_idx).getActualLife()) 
          min_idx = j;
  
      Soldado temp = army1DCopySelection.get(min_idx);
      army1DCopySelection.put(min_idx, army1DCopySelection.get(i));
      army1DCopySelection.put(i, temp);
    }
    return army1DCopySelection;
  }

  public static void printArmyHealth(HashMap <Integer, Soldado> armyPrint, char t){
    System.out.println("EJERCITO " + t + " : ");
    for(int i = 0; i < armyPrint.size(); i++)
      System.out.println((i + 1) + ". " + armyPrint.get(i).getName() + "  Vida: " + armyPrint.get(i).getActualLife());
  }

  public static void armyWinnerHealth(){
    System.out.print("\nSegun la suma de vida de los soldados, ");
    if (sumHealth(army1DA) > sumHealth(army1DB))
      System.out.println("el ejercito ganador es el: \'A\'");
      else if (sumHealth(army1DB) > sumHealth(army1DA))
        System.out.println("el ejercito ganador es el: \'B\'");
        else
          System.out.println("la batalla quedo en empate");
    System.out.println();
  }
  
  public void removeSoldier(Soldado s){
    //Por llenar
  }
}