// Laboratorio Nro 05 - Ejercicio01
// Autor : Hernan Andy
// Colaboro : null
// Tiempo : 3 horas

public class DemoBatalla {
  static Soldado[][] army = new Soldado[10][10];
  static Soldado[] army1D;
  public static void main(String [] args){
    army1D = createArmy(army);
    
    System.out.println("DATOS DE LOS SOLDADOS CREADOS: \n");
    showArmyData(army1D);

    System.out.println("                  TABLA CON LAS UBICACIONES DE LOS SOLDADOS CREADOS: \n");
    showArmyTable(army);

    moreHelath(army1D);

    System.out.println("La suma de la vida del ejercito es: " + sumHealth(army1D));
    System.out.println("El promedio de vida del ejercito es: " + averageHealth(army1D));

    System.out.println("\nEjercito ordenado (bubbleSort) segun la vida: ");
    printArmyHealth(bubbleSort(army1D));

    System.out.println("\nEjercito ordenado (insertionSort) segun la vida: ");
    printArmyHealth(insertionSort(army1D));

    System.out.println("\nEjercito ordenado (selectionSort) segun la vida: ");
    printArmyHealth(selectionSort(army1D));
  }

  public static Soldado[] createArmy(Soldado army[][]){
    int numSoldiers = (int) (Math.random() * 10) + 1;
    army1D = new Soldado[numSoldiers];
    for (int i = 0; i < numSoldiers; i++){
      int row, col;
      
      do {
        row = (int) (Math.random() * 9) + 1;
        col = (int) (Math.random() * 9) + 1;
      } while (army[row][col] != null);

      Soldado s = new Soldado("Soldier" + i, row + 1, (char) (col + 'A'), true, (int) (Math.random() * 5) + 1);
      army1D[i] = s;
      army[row][col] = s;

    }
    return army1D;
  }

  public static void showArmyTable(Soldado[][] army){
    String linesUp = "   |       |       |       |       |       |       |       |       |       |       |";

    String linesDown = "   |_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|";

    System.out.println("       A       B       C       D       E       F       G       H       I       J\n"
                      +"    _______________________________________________________________________________");
    for (int r = 0; r < army.length; r++){
      System.out.println(linesUp);
      System.out.print(r+1 + ((r != 9) ? "  |" : " |"));
      for (int c = 0; c < army[r].length; c++){
        System.out.print((army[r][c] != null) ?" Sold" + army[r][c].getName().charAt(7) + " |" : "       |");
        
      }
      System.out.println("\n" + linesDown);
    }
    System.out.println();
  }

  public static void showArmyData(Soldado[] army1D){
    for (Soldado s : army1D)
      System.out.println(s);
  }

  public static void moreHelath(Soldado[] army1D){
    int maxHealth = -1;
    for(Soldado s : army1D)
      if (s.getHealth() > maxHealth)
        maxHealth = s.getHealth();

    System.out.println("Soldado(s) con mayor vida: ");
    for (Soldado s : army1D) 
      if (s.getHealth() == maxHealth)
        System.out.println("Nombre: " + s.getName() + "  Vida: " + s.getHealth());
    System.out.println();
  }

  public static double averageHealth(Soldado[] army1D){
    return sumHealth(army1D) / army1D.length;
  }

  public static int sumHealth(Soldado[] army1D){
    int sum = 0;
    for (Soldado s : army1D)
      sum += s.getHealth();
    return sum;
  }

  public static Soldado[] bubbleSort(Soldado[] army1D){
    Soldado[] army1DCopyBubble = new Soldado[army1D.length];
    System.arraycopy(army1D, 0, army1DCopyBubble, 0, army1D.length);
    int n = army1DCopyBubble.length;
      boolean swapped;
      for (int i = 0; i < n - 1; i++) {
        swapped = false;
        for (int j = 0; j < n - i - 1; j++) {
          if (army1DCopyBubble[j].getHealth() < army1DCopyBubble[j + 1].getHealth()) {
            Soldado temp = army1DCopyBubble[j];
            army1DCopyBubble[j] = army1DCopyBubble[j + 1];
            army1DCopyBubble[j + 1] = temp;
            swapped = true;
          }
        }
        if (!swapped)
          break;
      }
    return army1DCopyBubble;
  }

  public static Soldado[] insertionSort(Soldado[] army1D) {
    int n = army1D.length;
    Soldado[] army1DCopyInsertion = new Soldado[n];

    // Copia los elementos del arreglo original al arreglo de copia
    for (int i = 0; i < n; i++) {
        army1DCopyInsertion[i] = army1D[i];
    }

    for (int i = 1; i < n; i++) {
        Soldado key = army1DCopyInsertion[i];
        int j = i - 1;

        while (j >= 0 && army1DCopyInsertion[j].getHealth() < key.getHealth()) {
            army1DCopyInsertion[j + 1] = army1DCopyInsertion[j];
            j = j - 1;
        }
        army1DCopyInsertion[j + 1] = key;
    }
    return army1DCopyInsertion;
  }

  public static Soldado[] selectionSort(Soldado[] army1D) {
    int n = army1D.length;
    Soldado[] army1DCopySelection = new Soldado[n];
  
    for (int i = 0; i < n; i++) {
      army1DCopySelection[i] = army1D[i];
    }
  
    for (int i = 0; i < n - 1; i++) {
      int min_idx = i;
  
      for (int j = i + 1; j < n; j++) {
        if (army1DCopySelection[j].getHealth() > army1DCopySelection[min_idx].getHealth()) {
          min_idx = j;
        }
      }
  
      Soldado temp = army1DCopySelection[min_idx];
      army1DCopySelection[min_idx] = army1DCopySelection[i];
      army1DCopySelection[i] = temp;
    }
  
    return army1DCopySelection;
  }

  public static void printArmyHealth(Soldado[] armyPrint){
    for(int i = 0; i < armyPrint.length; i++)
      System.out.println((i + 1) + ". " + armyPrint[i].getName() + "  Vida: " + armyPrint[i].getHealth());
  }
}