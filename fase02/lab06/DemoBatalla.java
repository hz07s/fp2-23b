// Laboratorio Nro 06 - Ejercicio01
// Autor : Hernan Andy
// Colaboro : null
// Tiempo : 
import java.util.ArrayList;

public class DemoBatalla {
  static ArrayList<ArrayList<Soldado>> army = new ArrayList<>();
  static ArrayList<Soldado> army1DA = new ArrayList<>();
  static ArrayList<Soldado> army1DB = new ArrayList<>();
  public static void main(String [] args){
    createArmy();
    
    System.out.println("DATOS DE LOS SOLDADOS CREADOS: \n");
    System.out.println("EJERCITO \"A\"");
    showArmyData(army1DA);
    System.out.println("\nEJERCITO \"B\"");
    showArmyData(army1DB);

    System.out.println("                  TABLA CON LAS UBICACIONES DE LOS SOLDADOS CREADOS: \n");
    showArmyTable(army);

    System.out.println("Soldado(s) con mayor vida del Ejercito A: ");
    moreHelath(army1DA);
    System.out.println("Soldado(s) con mayor vida del Ejercito B: ");
    moreHelath(army1DB);

    System.out.println("La suma de la vida del Ejercito A es: " + sumHealth(army1DA));
    System.out.println("El promedio de vida del Ejercito A es: " + averageHealth(army1DA));
    System.out.println("La suma de la vida del Ejercito B es: " + sumHealth(army1DB));
    System.out.println("El promedio de vida del Ejercito B es: " + averageHealth(army1DB));

    System.out.println("\nEjercitos ordenados (bubbleSort) segun la vida: ");
    System.out.println("EJERCITO  A: ");
    printArmyHealth(bubbleSort(army1DA));
    System.out.println("EJERCITO  B: ");
    printArmyHealth(bubbleSort(army1DB));

    System.out.println("\nEjercitos ordenados (insertionSort) segun la vida: ");
    System.out.println("EJERCITO  A: ");
    printArmyHealth(insertionSort(army1DA));
    System.out.println("EJERCITO  B: ");
    printArmyHealth(insertionSort(army1DB));

    System.out.println("\nEjercitos ordenados (selectionSort) segun la vida: ");
    System.out.println("EJERCITO  A: ");
    printArmyHealth(selectionSort(army1DA));
    System.out.println("EJERCITO  B: ");
    printArmyHealth(selectionSort(army1DB));

    System.out.println();
    armyWinnerHealth();
  }

  public static void createArmy(){
    int numSoldiersA = (int) (Math.random() * 10) + 1;
    int numSoldiersB = (int) (Math.random() * 10) + 1;

    for (int i = 0; i < 10; i++){
      army.add(new ArrayList<>());
      for (int j = 0; j < 10; j++)
        army.get(i).add(null);
    }

    army1DA = createArmyTeam(numSoldiersA, army1DA, "A");
    army1DB = createArmyTeam(numSoldiersB, army1DB, "B");
  }

  public static ArrayList <Soldado> createArmyTeam(int numSoldiers, ArrayList <Soldado> army1D, String t){
    for (int i = 0; i < numSoldiers; i++){
      int row, col;
      
      do {
        row = (int) (Math.random() * 9) + 1;
        col = (int) (Math.random() * 9) + 1;
      } while (army.get(row).get(col) != null);

      Soldado s = new Soldado("Soldier" + i + "X" + t, row + 1, (char) (col + 'A'), true, (int) (Math.random() * 5) + 1);
      army1D.add(i, s);
      army.get(row).set(col, s);
    }
    return army1D;
  }

  public static void showArmyTable(ArrayList <ArrayList <Soldado>> army){
    String linesUp = "   |       |       |       |       |       |       |       |       |       |       |";

    String linesDown = "   |_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|";

    System.out.println("       A       B       C       D       E       F       G       H       I       J\n"
                      +"    _______________________________________________________________________________");
    for (int r = 0; r < army.size(); r++){
      System.out.println(linesUp);
      System.out.print(r+1 + ((r != 9) ? "  |" : " |"));
      for (int c = 0; c < army.get(r).size(); c++){
        System.out.print(" " + (isTeam(army.get(r).get(c), army1DA)? "\'A\'" : isTeam(army.get(r).get(c), army1DB)? "\'B\'" : "") 
        + ((army.get(r).get(c) != null) ?"S" 
        + army.get(r).get(c).getName().charAt(7) + " |" : "      |"));
        
      }
      System.out.println("\n" + linesDown);
    }
    System.out.println();
  }

  public static boolean isTeam(Soldado s, ArrayList <Soldado> army1DT){
    for (Soldado sA : army1DT)
      if (sA.equals(s))
        return true;
    return false;
  }

  public static void showArmyData(ArrayList <Soldado> army1D){
    for (Soldado s : army1D)
      System.out.println(s);
  }

  public static void moreHelath(ArrayList <Soldado> army1MH){
    int maxHealth = -1;
    for(Soldado s : army1MH)
      if (s.getHealth() > maxHealth)
        maxHealth = s.getHealth();

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
        for (int j = 0; j < n - i - 1; j++) {
          if (army1DCopyBubble.get(j).getHealth() < army1DCopyBubble.get(j+1).getHealth()) {
            Soldado temp = army1DCopyBubble.get(j);
            army1DCopyBubble.set(j, army1DCopyBubble.get(j+1));
            army1DCopyBubble.set(j+1, temp);
            swapped = true;
          }
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
  
      for (int j = i + 1; j < n; j++) {
        if (army1DCopySelection.get(j).getHealth() > army1DCopySelection.get(min_idx).getHealth()) {
          min_idx = j;
        }
      }
  
      Soldado temp = army1DCopySelection.get(min_idx);
      army1DCopySelection.set(min_idx, army1DCopySelection.get(i));
      army1DCopySelection.set(i, temp);
    }
  
    return army1DCopySelection;
  }

  public static void printArmyHealth(ArrayList <Soldado> armyPrint){
    for(int i = 0; i < armyPrint.size(); i++)
      System.out.println((i + 1) + ". " + armyPrint.get(i).getName() + "  Vida: " + armyPrint.get(i).getHealth());
  }

  public static void armyWinnerHealth(){
    System.out.println("(Segun la vida)");
    if (sumHealth(army1DA) > sumHealth(army1DB))
      System.out.println("El ejercito ganador es: \'A\'");
      else if (sumHealth(army1DB) > sumHealth(army1DA))
        System.out.println("El ejercito ganador es: \'B\'");
        else
          System.out.println("La batalla quedo en empate");
    System.out.println();
  }
}