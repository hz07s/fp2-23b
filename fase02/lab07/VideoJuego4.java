// Laboratorio Nro 06 - Ejercicio01
// Autor : Hernan Andy
// Colaboro : null
// Tiempo : 3 horas
import java.util.ArrayList;
import java.util.Scanner;

public class VideoJuego4 {
  static ArrayList<ArrayList<Soldado>> army = new ArrayList<>();
  static ArrayList<Soldado> army1DA = new ArrayList<>();
  static ArrayList<Soldado> army1DB = new ArrayList<>();
  public static void main(String [] args){
    createArmy();

    armyWinnerHealth();
  }
  public static void mainInterfaz(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Bienvenido...");

    System.out.println("1. Crear un nuevo ejercito" 
                      +"2. Mostrar los datos de los ejercitos" 
                      +"3. Mostrar la tabla con los ejercitos" 
                      +"4. Mostrar el promedio de vida de los ejercitos" 
                      +"5. Ordenar los soldados de ejercitos segun la vida" 
                      +"6. Mostrar ejercito ganador"
                      +"7. Salir del juego");
    int action = sc.nextInt();

    switch (action){
      case 1 -> { // Crear un nuevo ejercito
        army.clear();
        army1DA.clear();
        army1DB.clear();
          
        createArmy();
      }
      case 2 -> { // Mostrar los datos de los ejercitos
        System.out.println("DATOS DE LOS SOLDADOS CREADOS:\n");
        showArmyData(army1DA, 'A');
        showArmyData(army1DB, 'B');
      }
      case 3 -> { // Mostrar la tabla con los ejercitos
        showArmyTable(army);
      }
      case 4 -> { // Mostrar el promedio de vida de los ejercitos
        System.out.println("El promedio de vida del Ejercito A es: " + averageHealth(army1DA));
        System.out.println("El promedio de vida del Ejercito B es: " + averageHealth(army1DB));
      }
      case 5 -> { // Mostrar los soldados de ejercitos con mayor vida
        moreHelath(army1DA, 'A');
        moreHelath(army1DB, 'B');
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
      }
      case 7 -> { // Mostrar ejercito ganador
        
      }
      case 8 -> { // Salir del juego
        
      }
    }

    sc.close();
  }

  public static void createArmy(){
    int numSoldiersA = (int) (Math.random() * 10) + 1;
    int numSoldiersB = (int) (Math.random() * 10) + 1;

    for (int i = 0; i < 10; i++){
      army.add(new ArrayList<>());
      for (int j = 0; j < 10; j++)
        army.get(i).add(null);
    }

    army1DA = createArmyTeam(numSoldiersA, army1DA, 'A');
    army1DB = createArmyTeam(numSoldiersB, army1DB, 'B');
  }

  public static ArrayList <Soldado> createArmyTeam(int numSoldiers, ArrayList <Soldado> army1D, char t){
    for (int i = 0; i < numSoldiers; i++){
      int row, col;
      
      do {
        row = (int) (Math.random() * 9) + 1;
        col = (int) (Math.random() * 9) + 1;
      } while (army.get(row).get(col) != null);

      Soldado s = new Soldado("Soldier" + i + "X" + t, row + 1, (char) (col + 'A'), true, (int) (Math.random() * 5) + 1, t);
      army1D.add(i, s);
      army.get(row).set(col, s);
    }
    return army1D;
  }

  public static void showArmyTable(ArrayList <ArrayList <Soldado>> army){
    System.out.println("\n                  TABLA CON LAS UBICACIONES DE LOS SOLDADOS CREADOS: \n");
    String linesDown = "   |_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|";
    System.out.println("       A       B       C       D       E       F       G       H       I       J\n"
                      +"    _______________________________________________________________________________");
    
    for (int r = 0; r < army.size(); r++){
      System.out.print("   |");
      for (int c = 0; c < army.get(r).size(); c++)
        System.out.print(" " + (army.get(r).get(c) != null ? ("\'" + army.get(r).get(c).getTeam() + "\'" 
        + "S" + army.get(r).get(c).getName().charAt(7) + " |") : "      |"));

      System.out.print("\n" + (r+1) + ((r != 9) ? "  |" : " |"));
      for (int c = 0; c < army.get(r).size(); c++)
        System.out.print(" " + (army.get(r).get(c) != null ? "HP: " + army.get(r).get(c).getHealth() : "     ") + " |");
        
      System.out.println("\n" + linesDown );
    }
    System.out.println();
  }

  public static void showArmyData(ArrayList <Soldado> army1D, char t){
    System.out.println("EJERCITO \"" + t + "\"");
    for (Soldado s : army1D)
      System.out.println(s);
  }

  public static void moreHelath(ArrayList <Soldado> army1MH, char t){
    int maxHealth = -1;
    for(Soldado s : army1MH)
      if (s.getHealth() > maxHealth)
        maxHealth = s.getHealth();

    System.out.println("Soldado(s) con mayor vida del Ejercito " + t + ": ");
    for (Soldado s : army1MH) 
      if (s.getHealth() == maxHealth)
        System.out.println("Nombre: " + s.getName() + "  Vida: " + s.getHealth());
    System.out.println();
  }

  public static double averageHealth(ArrayList <Soldado> army1DAH){
    return sumHealth(army1DAH) / army1DAH.size();
  }

  public static int sumHealth(ArrayList <Soldado> army1DSH){
    int sum = 0;
    for (Soldado s : army1DSH)
      sum += s.getHealth();
    return sum;
  }

  public static ArrayList <Soldado> bubbleSort(ArrayList <Soldado> army1DBS){
    ArrayList <Soldado>army1DCopyBubble = new ArrayList<>(army1DBS);
    int n = army1DCopyBubble.size();
    boolean swapped;
    for (int i = 0; i < n - 1; i++) {
      swapped = false;
      for (int j = 0; j < n - i - 1; j++)
        if (army1DCopyBubble.get(j).getHealth() < army1DCopyBubble.get(j+1).getHealth()) {
          Soldado temp = army1DCopyBubble.get(j);
          army1DCopyBubble.set(j, army1DCopyBubble.get(j+1));
          army1DCopyBubble.set(j+1, temp);
          swapped = true;
        }
      if (!swapped)
        break;
    }
    return army1DCopyBubble;
  }

  public static ArrayList <Soldado> insertionSort(ArrayList <Soldado> army1DIS) {
    int n = army1DIS.size();
    ArrayList <Soldado> army1DCopyInsertion = new ArrayList<>(army1DIS);

    for (int i = 1; i < n; i++) {
      Soldado key = army1DCopyInsertion.get(i);
      int j = i - 1;

      while (j >= 0 && army1DCopyInsertion.get(j).getHealth() < key.getHealth()) {
        army1DCopyInsertion.set(j+1, army1DCopyInsertion.get(j));
        j = j - 1;
      }
      army1DCopyInsertion.set(j+1, key);
    }
    return army1DCopyInsertion;
  }

  public static ArrayList <Soldado> selectionSort(ArrayList <Soldado> army1DSS) {
    int n = army1DSS.size();
    ArrayList <Soldado> army1DCopySelection = new ArrayList<>(army1DSS);
  
    for (int i = 0; i < n - 1; i++) {
      int min_idx = i;
  
      for (int j = i + 1; j < n; j++)
        if (army1DCopySelection.get(j).getHealth() > army1DCopySelection.get(min_idx).getHealth()) 
          min_idx = j;
  
      Soldado temp = army1DCopySelection.get(min_idx);
      army1DCopySelection.set(min_idx, army1DCopySelection.get(i));
      army1DCopySelection.set(i, temp);
    }
    return army1DCopySelection;
  }

  public static void printArmyHealth(ArrayList <Soldado> armyPrint, char t){
    System.out.println("EJERCITO " + t + " : ");
    for(int i = 0; i < armyPrint.size(); i++)
      System.out.println((i + 1) + ". " + armyPrint.get(i).getName() + "  Vida: " + armyPrint.get(i).getHealth());
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
}