// Laboratorio Nro 12 - Ejercicio01
// Autor : Hernan Andy
// Colaboro : null
// Tiempo : 3 horas
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

public class VideoJuego7 {
  static HashMap <Integer, Soldado> army = new HashMap<>();
  static HashMap <Integer, Soldado> army1DA = new HashMap<>();
  static HashMap <Integer, Soldado> army1DB = new HashMap<>();
  static String map;
  public static void main(String [] args){
    VideoJuego7 videoJuego = new VideoJuego7();
    videoJuego.createArmy();
    videoJuego.mainInterfaz();
  }
  public void mainInterfaz(){
    Scanner sc = new Scanner(System.in);
    System.out.println(  "1. Quick game" 
                      +"\n2. Custom game" 
                      +"\n3. Exit");
    int action = sc.nextInt();
    switch (action){
      case 1 -> quickGame();
      case 2 -> customGame();
      case 3 -> System.out.println("Exiting the program.");
      default -> {
        System.out.println("Choose a valid option");
        mainInterfaz();
      }
    }
  }
  public void quickGame(){
    Scanner sc = new Scanner(System.in);

    System.out.println("1. Crear un nuevo ejercito" 
                      +"\n2. Mostrar los datos de los ejercitos" 
                      +"\n3. Mostrar la tabla con los ejercitos" 
                      +"\n4. Mostrar el promedio de vida de los ejercitos" 
                      +"\n5. Mostrar los soldados de ejercitos con mayor vida" 
                      +"\n6. Ordenar los soldados de ejercitos segun la vida" 
                      +"\n7. 1v1 battle"
                      +"\n8. Salir del juego");
    int action = sc.nextInt();

    switch (action){
      case 1 -> { // Crear un nuevo ejercito
        army.clear();
        army1DA.clear();
        army1DB.clear();
        createArmy();
        quickGame();
      }
      case 2 -> { // Mostrar los datos de los ejercitos
        System.out.println("DATOS DE LOS SOLDADOS CREADOS:\n");
        showArmyData(army1DA, 'A');
        showArmyData(army1DB, 'B');
        quickGame();
      }
      case 3 -> { // Mostrar la tabla con los ejercitos
        showArmyTable(army);
        quickGame();
      }
      case 4 -> { // Mostrar el promedio de vida de los ejercitos
        System.out.println("El promedio de vida del Ejercito A es: " + averageHealth(army1DA));
        System.out.println("El promedio de vida del Ejercito B es: " + averageHealth(army1DB));
        quickGame();
      }
      case 5 -> { // Mostrar los soldados de ejercitos con mayor vida
        moreHelath(army1DA, 'A');
        moreHelath(army1DB, 'B');
        quickGame();
      }
      case 6 -> { // Ordenar los soldados de ejercitos segun la vida
        System.out.println("\nEjercitos ordenados (insertionSort) segun la vida: ");
        printArmyHealth(insertionSort(army1DA), 'A');
        printArmyHealth(insertionSort(army1DB), 'B');
        quickGame();
      }
      case 7 -> { // Jugar de 2
        gameIntefaz();
        quickGame();
      }
      case 8 -> { // Salir del juego
        mainInterfaz();
      }
      default -> {
        System.out.println("Selecciona una opcion valida");
        quickGame();
      }
    }

     
  }

  public void createArmy(){
    Mapa m = new Mapa();
    map = m.randomMapa();
    int numSoldiersA = (int) (Math.random() * 10) + 1;
    int numSoldiersB = (int) (Math.random() * 10) + 1;

    String[] reinos = {"Castilla", "Aragon", "Moros", "Sacro Imperio Romano", "Germanico"};

    army1DA = createArmyTeam(numSoldiersA, army1DA, 'A', reinos[(int) (Math.random() * reinos.length)], map);
    army1DB = createArmyTeam(numSoldiersB, army1DB, 'B', reinos[(int) (Math.random() * reinos.length)], map);

  }

  public HashMap <Integer, Soldado> createArmyTeam(int numSoldiers, HashMap <Integer, Soldado> army1D, char t, String r, String mapp){
    String[] typeSoldier = {"Espadachin", "Caballero", "Arquero", "Lancero"};
    for (int i = 0; i < numSoldiers; i++){
      int row, col;
      
      do {
        row = (int) (Math.random() * 10);
        col = (int) (Math.random() * 10);
      } while (army.containsKey(row * 10 + col));

      int typ = (int) (Math.random() * typeSoldier.length);

      switch (typ) {
        case 1 -> {
          Espadachin e = new Espadachin(VideoJuego7.this, "Soldier" + i + "X" + t, row + 1, (char) (col + 'A'), t, 
          (int)(Math.random() * 5) + 1, "Defensiva", true, r);
          if (e.getReino().equals(mapp))
            e.setActualLife(e.getActualLife() + 1);
          army1D.put(i, e);
          army.put(row * 10 + col, e);
        }
        case 2 -> {
          Caballero c = new Caballero(VideoJuego7.this, "Soldier" + i + "X" + t, row + 1, (char) (col + 'A'), t, 
          (int)(Math.random() * 5) + 1, "Defensiva", true, r);
          if (c.getReino().equals(mapp))
            c.setActualLife(c.getActualLife() + 1);
          army1D.put(i, c);
          army.put(row * 10 + col, c);
        }
        case 3 -> {
          Arquero a = new Arquero(VideoJuego7.this, "Soldier" + i + "X" + t, row + 1, (char) (col + 'A'), t, 
          (int)(Math.random() * 5) + 1, "Defensiva", true, r);
          if (a.getReino().equals(mapp))
            a.setActualLife(a.getActualLife() + 1);
          army1D.put(i, a);
          army.put(row * 10 + col, a);
        }
        case 4 -> {
          Lancero l = new Lancero(VideoJuego7.this, "Soldier" + i + "X" + t, row + 1, (char) (col + 'A'), t, 
          (int)(Math.random() * 5) + 1, "Defensiva", true, r);
          if (l.getReino().equals(mapp))
            l.setActualLife(l.getActualLife() + 1);
          army1D.put(i, l);
          army.put(row * 10 + col, l);
        }
      }
    }
    return army1D;
  }

  public void showArmyTable(HashMap <Integer, Soldado> army){
    String colorAzul = "\u001B[34m";
    String colorRojo = "\u001B[31m";
    String resetColor = "\u001B[0m";

    System.out.println("\n                  TABLA CON LAS UBICACIONES DE LOS SOLDADOS CREADOS: \n");
    String linesDown = "   |_______|_______|_______|_______|_______|_______|_______|_______|_______|_______|";
    System.out.println("       A       B       C       D       E       F       G       H       I       J\n"
                      +"    _______________________________________________________________________________");
    
    for (int r = 0; r < 10; r++){
      System.out.print("   |");
      for (int c = 0; c < 10; c++)
        System.out.print(" " + (army.get(r*10+c) != null ? ("\'" + army.get(r*10+c).getTeam() + "\'" 
        + army.get(r*10+c).getType() + army.get(r*10+c).getName().charAt(7) + " |") : "      |"));

      System.out.print("\n" + (r+1) + ((r != 9) ? "  |" : " |"));
      for (int c = 0; c < 10; c++)
        System.out.print(" " + (army.get(r*10+c) != null ? "HP: " + army.get(r*10+c).getActualLife() : "     ") + " |");
        
      System.out.println("\n" + linesDown );
    }
    System.out.println();
  }

  public void showArmyData(HashMap <Integer, Soldado> army1D, char t){
    System.out.println("EJERCITO \"" + t + "\"");
    for (Soldado s : army1D.values())
      System.out.println(s);
  }

  public void moreHelath(HashMap <Integer, Soldado> army1MH, char t){
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

  public double averageHealth(HashMap <Integer, Soldado> army1DAH){
    return sumHealth(army1DAH) / army1DAH.size();
  }

  public int sumHealth(HashMap <Integer, Soldado> army1DSH){
    int sum = 0;
    for (Soldado s : army1DSH.values())
      sum += s.getActualLife();
    return sum;
  }
  public HashMap <Integer, Soldado> insertionSort(HashMap <Integer, Soldado> army1DIS) {
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
  public void printArmyHealth(HashMap <Integer, Soldado> armyPrint, char t){
    System.out.println("EJERCITO " + t + " : ");
    for(int i = 0; i < armyPrint.size(); i++)
      System.out.println((i + 1) + ". " + armyPrint.get(i).getName() + "  Vida: " + armyPrint.get(i).getActualLife());
  }

  public void customGame(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Select army to customize:\n  1. A\n  2. B");
    int actionTeam = sc.nextInt();
    if (actionTeam  == 1) // A
      customGameArmy(army1DA, 'A');
    else if(actionTeam  == 2) // B
      customGameArmy(army1DB, 'B');
    else{
      System.out.println("Invalid army, try again");
      customGame();
    }
  }
  public void customGameArmy(HashMap <Integer, Soldado> armyA, char t){
    Scanner sc = new Scanner(System.in);
    System.out.println("Selected " + t + " army");
    System.out.println(  " 1. Create Soldier" 
                      +"\n 2. Delete Soldier"
                      +"\n 3. Clone Soldier" 
                      +"\n 4. Modify Soldier" 
                      +"\n 5. Compare Soldiers" 
                      +"\n 6. Swap Soldiers" 
                      +"\n 7. View Soldier" 
                      +"\n 8. See Army" 
                      +"\n 9. Add Levels" 
                      +"\n10. Play" 
                      +"\n11. Return");
    int action = sc.nextInt();
    switch (action){
      case 1 -> createSoldier(armyA, t);
      case 2 -> deleteSoldier(armyA, t);
      case 3 -> cloneSoldier(armyA, t);
      case 4 -> modifySoldier(armyA, t);
      case 5 -> compareSoldiers(armyA, t);
      case 6 -> swapSoldiers(armyA, t);
      case 7 -> viewSoldier(armyA, t);
      case 8 -> seeArmy(armyA, t);
      case 9 -> addLevels(armyA, t);
      case 10 -> play();
      case 11 -> mainInterfaz();
      default -> {
        System.out.println("Choose a valid option");
        customGameArmy(armyA, t);
      }
    }
    System.out.println("Returning to the menu");
    customGameArmy(armyA, t);
  }
  public void assignModification(HashMap <Integer, Soldado> armyMod, char t){
    if (t == 'A')
      army1DA = armyMod;
    else
      army1DB = armyMod;
  }
  public void createSoldier(HashMap <Integer, Soldado> armyMod, char t){
    Scanner sc = new Scanner(System.in);
    if (armyMod.size() < 10){
      System.out.print("ENTER THE DATA: ");

      System.out.print("Enter name: ");
      String name = sc.next();
      int position = createPosition(armyMod);
      System.out.print("Enter attack level (1 - 5): ");
      int attackLevel = sc.nextInt();
      System.out.print("Enter level deffense (1 - 5): ");
      int levelDefense = sc.nextInt();
      System.out.print("Enter level life (1 - 5): ");
      int levelLife = sc.nextInt();
      System.out.print("Enter speed: ");
      int speed = sc.nextInt();
      Soldado s = new Soldado(VideoJuego7.this,name, position / 10 + 1, (char)(position % 10 + 'A'), t, attackLevel, levelDefense, levelLife, speed);
      armyMod.put(armyMod.size(), s);
      army.put(position / 10 + position % 10, s);
    }
    else
      System.out.println("The army reached the limit of allowed soldiers");
    assignModification(armyMod, t);
  }
  public int createPosition(HashMap <Integer, Soldado> armyMod){
    Scanner sc = new Scanner(System.in);
    int row;
    char column;
    do{
      System.out.print("Enter row (1 - 10): ");
      row = sc.nextInt();
      System.out.print("Enter column (A - J): ");
      column = sc.next().charAt(0);
    } while(armyMod.get((row-1)*10 + (column - 'A')) != null);
    return (row-1)*10 + (column - 'A');
  }
  public void deleteSoldier(HashMap <Integer, Soldado> armyMod, char t){
    Scanner sc = new Scanner(System.in);
    if (armyMod.size() > 1){
      System.out.println("ARMY \"" + t + "\"");
      for (Soldado s : armyMod.values())
        System.out.println(s.getName());
      
      System.out.println("Enter the name of the soldier to be eliminated");
      String sName = sc.next();
      Soldado soldierToDelete = null;
      for (Soldado s : armyMod.values())
        if (s.getName().equals(sName)){
          soldierToDelete = s;
          break;
        }
      if (soldierToDelete != null) {
        armyMod.remove(Integer.parseInt(soldierToDelete.getName().substring(7,8)));
        army.remove((soldierToDelete.getRow() - 1) * 10 + (soldierToDelete.getColumn() - 'A'));
        System.out.println("Soldier successfully eliminated: " + soldierToDelete.getName());
      } else {
        System.out.println("Soldier not found. Try again.");
        deleteSoldier(armyMod, t);
      }
    } else {
      System.out.println("No soldiers in the " + t + " army.");
    }
    assignModification(armyMod, t);
  }
  public void cloneSoldier(HashMap<Integer, Soldado> armyMod, char t) {
    Scanner sc = new Scanner(System.in);
    if (armyMod.size() < 10) {
      for (Soldado s : armyMod.values())
        System.out.println(s.getName());

      System.out.println("Enter the name of the soldier to clone:");
      String originalSoldierName = sc.next();

      Soldado originalSoldado = null;
      for (Soldado s : armyMod.values())
        if (s.getName().equals(originalSoldierName)) {
          originalSoldado = s;
          break;
        }
      if (originalSoldado != null){
        int row, col;
        do {
          System.out.print("Enter the row (1 - 10) for the cloned soldier: ");
          row = sc.nextInt();
          System.out.print("Enter the column (A - J) for the cloned soldier: ");
          col = Character.toUpperCase(sc.next().charAt(0)) - 'A';
        } while (armyMod.get(row * 10 + col) != null);
        
        Soldado clonedSoldado = new Soldado(originalSoldado.getVideoJuego7(),"Soldier" + armyMod.size() + "X" + t,
                      row + 1, (char) (col + 'A'), t, originalSoldado.getAttackLevel(), originalSoldado.getLevelDefense(),
                      originalSoldado.getLevelLife(), originalSoldado.getSpeed(),"Defensiva",true);
        armyMod.put(armyMod.size(), clonedSoldado);
        army.put(row * 10 + col, clonedSoldado);

        System.out.println("Soldier cloned successfully: " + clonedSoldado.getName());
      } 
      else {
        System.out.println("Soldier not found. Try again.");
        cloneSoldier(armyMod, t);
      }
    } else 
        System.out.println("The army reached the limit of allowed soldiers.");
    assignModification(armyMod, t);
}
  public void modifySoldier(HashMap<Integer, Soldado> armyMod, char t) {
    Scanner sc = new Scanner(System.in);
    System.out.println("ARMY \"" + t + "\"");
    for (Soldado s : armyMod.values())
      System.out.println(s.getName());

    System.out.println("Enter the name of the soldier to modify:");
    String soldierName = sc.next();

    Soldado soldierToModify = null;
    for (Soldado s : armyMod.values()) 
      if (s.getName().equals(soldierName)) {
        soldierToModify = s;
        break;
      }

    if (soldierToModify != null) {
      System.out.println("Modify Soldier - " + soldierToModify.getName());
      System.out.println("1. Modify Attack Level");
      System.out.println("2. Modify Defense Level");
      System.out.println("3. Modify Life Level");
      System.out.println("4. Return");

      int choice = sc.nextInt();

      switch (choice) {
        case 1 -> {
          System.out.print("Enter new Attack Level (1 - 5): ");
          int newAttackLevel = sc.nextInt();
          soldierToModify.setAttackLevel(newAttackLevel);
        }
        case 2 -> {
          System.out.print("Enter new Defense Level (1 - 5): ");
          int newDefenseLevel = sc.nextInt();
          soldierToModify.setLevelDefense(newDefenseLevel);
        }
        case 3 -> {
          System.out.print("Enter new Life Level (1 - 5): ");
          int newLifeLevel = sc.nextInt();
          soldierToModify.setLevelLife(newLifeLevel);
        }
        case 4 -> System.out.println("Returning to the menu");
        default -> {
          System.out.println("Invalid choice. Returning to the menu.");
        }
      }
    } else {
      System.out.println("Soldier not found. Try again.");
      modifySoldier(armyMod, t);
    }
  }
  public void compareSoldiers(HashMap<Integer, Soldado> armyMod, char t){
    Scanner sc = new Scanner(System.in);
    for (Soldado s : armyMod.values())
      System.out.println(s.getName());
    
    System.out.println("Enter the name of the first soldier:");
    String soldierName1 = sc.next();
    System.out.println("Enter the name of the second soldier:");
    String soldierName2 = sc.next();

    Soldado soldier1 = findSoldado(armyMod, soldierName1);
    Soldado soldier2 = findSoldado(armyMod, soldierName2);

    if (soldier1 != null && soldier2 != null){
      if (compareSoldadoAttributes(soldier1, soldier2)) 
        System.out.println("Soldiers are identical.");
      else 
        System.out.println("Soldiers are different.");
    } 
    else{
      System.out.println("Soldier not found. Try again.");
      compareSoldiers(armyMod, t);
    }
  }
  public Soldado findSoldado(HashMap<Integer, Soldado> armyMod, String soldierName) {
    for (Soldado s : armyMod.values()) 
      if (s.getName().equals(soldierName)) 
        return s;
    return null;
  }
  public boolean compareSoldadoAttributes(Soldado s1, Soldado s2) {
    return s1.getName().equals(s2.getName()) &&
          s1.getAttackLevel() == s2.getAttackLevel() &&
          s1.getLevelDefense() == s2.getLevelDefense() &&
          s1.getActualLife() == s2.getActualLife() &&
          s1.getLives() == s2.getLives();
  }
  public void swapSoldiers(HashMap<Integer, Soldado> armyMod, char t) {
    Scanner sc = new Scanner(System.in);

    System.out.println("ARMY \"" + t + "\"");
    for (Soldado soldado : armyMod.values()) 
      System.out.println(soldado.getName());

    System.out.println("Enter the name of the first soldier to swap:");
    String sName1 = sc.next();
    Soldado soldier1 = findSoldado(armyMod, sName1);

    System.out.println("Enter the name of the second soldier to swap:");
    String sName2 = sc.next();
    Soldado soldier2 = findSoldado(armyMod, sName2);

    if (soldier1 != null && soldier2 != null) {
      System.out.println("Swapping Soldiers - " + soldier1.getName() + " and " + soldier2.getName());
      int position1 = (soldier1.getRow() - 1) * 10 + (soldier1.getColumn() - 'A');
      int position2 = (soldier2.getRow() - 1) * 10 + (soldier2.getColumn() - 'A');

      armyMod.remove(position1);
      armyMod.remove(position2);

      armyMod.put(position1, soldier2);
      armyMod.put(position2, soldier1);

      System.out.println("Soldiers swapped successfully.");
    } else {
      System.out.println("One or both soldiers not found. Try again.");
      swapSoldiers(armyMod, t);
    } 
  }
  public void viewSoldier(HashMap<Integer, Soldado> armyMod, char t) {
    Scanner sc = new Scanner(System.in);
    for (Soldado soldado : armyMod.values()) 
      System.out.println(soldado.getName());
    System.out.println("Enter the name of the soldier to view:");
    String soldierName = sc.next();

    Soldado soldierToView = findSoldado(armyMod, soldierName);

    if (soldierToView != null) {
      System.out.println("Soldier Details:");
      System.out.println("Name: " + soldierToView.getName());
      System.out.println("Team: " + soldierToView.getTeam());
      System.out.println("Position: " + soldierToView.getRow() + " " + soldierToView.getColumn());
      System.out.println("Attack Level: " + soldierToView.getAttackLevel());
      System.out.println("Defense Level: " + soldierToView.getLevelDefense());
      System.out.println("Life Level: " + soldierToView.getLevelLife());
      System.out.println("Speed: " + soldierToView.getSpeed());
    } else {
      System.out.println("Soldier not found. Try again.");
      viewSoldier(armyMod, t);
    }
  }
  public void seeArmy(HashMap<Integer, Soldado> armyMod, char t) {
    System.out.println("EJERCITO \"" + t + "\"");
    for (Soldado s : armyMod.values()) {
      System.out.println("Soldier Details:");
      System.out.println("Name: " + s.getName());
      System.out.println("Team: " + s.getTeam());
      System.out.println("Position: " + s.getRow() + " " + s.getColumn());
      System.out.println("Attack Level: " + s.getAttackLevel());
      System.out.println("Defense Level: " + s.getLevelDefense());
      System.out.println("Life Level: " + s.getLevelLife());
      System.out.println("Speed: " + s.getSpeed());
      System.out.println();
    }
    customGameArmy(armyMod, t);
  }  
  public void addLevels(HashMap<Integer, Soldado> armyMod, char t) {
    int totalAttackLevel = 0;
    int totalDefenseLevel = 0;
    int totalLifeLevel = 0;
    int totalSpeed = 0;

    for (Soldado soldier : armyMod.values()) {
        totalAttackLevel += soldier.getAttackLevel();
        totalDefenseLevel += soldier.getLevelDefense();
        totalLifeLevel += soldier.getLevelLife();
        totalSpeed += soldier.getSpeed();
    }
    System.out.println("Sumatoria de niveles del Ejercito " + t + ":");
    System.out.println("Sumatoria de Nivel de Ataque: " + totalAttackLevel);
    System.out.println("Sumatoria de Nivel de Defensa: " + totalDefenseLevel);
    System.out.println("Sumatoria de Nivel de Vida: " + totalLifeLevel);
    System.out.println("Sumatoria de Velocidad: " + totalSpeed);
  }
  public void play(){
    gameIntefaz();
  }
  

  public void armyWinner(){
    if(army1DA.size() > army1DB.size())
      System.out.print("A");
    else
      System.out.print("B");
  }
  
  public void removeSoldier(Soldado s){
    if (s.getTeam() == 'A')
      army1DA.remove(s.getName().charAt(7) - '0');
    else 
      army1DB.remove(s.getName().charAt(7) - '0');
    army.remove((s.getRow()-1)*10 + (s.getColumn() -'A'));
  }
  public void gameIntefaz(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Starting Game...");
    boolean noEnd = true;
    while (noEnd) {
      System.out.println("Team A Turn");
      turn('A');
      if(army1DA.size() == 0)
        break;
      System.out.println("Team B Turn");
      turn('B');
      if(army1DB.size() == 0)
        break;
    }
     
    System.out.println("Winning team: ");
    armyWinner();
  }
  public void turn(char teamT){
    showArmyTable(army);
    Scanner sc = new Scanner(System.in);
    System.out.println("Indicate the coordinates of the soldier to move. Ej: 1 A (put the space in the middle)");
    int row1 = sc.nextInt() - 1;
    char l1 = sc.next().charAt(0);
    int col1 = Character.toUpperCase(l1) - 'A';
    if (checkSoldier1(row1, col1, teamT))
      turn2(row1, col1, teamT);
    else 
      turn(teamT);
     
  }
  public boolean checkSoldier1(int row, int col, char team){
    if(row > 9 || col > 9)
      return false;   
    if (army.get(row*10 + col) != null){
      if(army.get(row*10 + col).getTeam() == team)
        return true;
      else{
        System.out.println("Choose a soldier from your team");
        return false;
      }
    }
    return false;
  }
  public int checkSoldier2(int row, int col, char team){
    if(row > 9 || col > 9)
      return 4;   
    if (army.get(row*10 + col) == null)
      return 1;
    else if (army.get(row*10 + col).getTeam() != team)
      return 3;
    return 2;
  }
  public void turn2(int row1, int col1, char teamT){
    Scanner sc = new Scanner(System.in);
    System.out.println("Indicate the coordinates where you want to move the soldier. Ej: 1 A (put the space in the middle)");
    int row2 = sc.nextInt() - 1;
    char l2 = sc.next().charAt(0);
    int col2 = Character.toUpperCase(l2) - 'A';

    switch(checkSoldier2(row2, col2, teamT)){
      case 1 -> moveSoldier(row1, col1, row2, col2);
      case 2 -> {
        System.out.println("There cannot be two soldiers in the same position, try again");
        turn2(row1, col1, teamT);
      }
      case 3 ->{
        System.out.println("--SOLDIERS FIGHT--");
        System.out.println(army.get(row1*10 + col1).getName() + " vs " + army.get(row2*10 + col2).getName());
        Soldado sW = soldiersFight(army.get(row1*10 + col1), army.get(row2*10 + col2), row2, col2, row1, col1);
      }
      case 4 ->{
        System.out.println("Invalid position, try again");
        turn2(row1, col1, teamT);
      }
    }
     
  }
  public void moveSoldier(int row1, int col1, int row2, int col2){
    army.put(row2*10 + col2, army.get(row1*10 + col1));
    army.remove(row1*10 + col1);
  }
  public void moveSoldier(Soldado s,int row1, int col1, int rowD, int colD){
    army.remove(rowD*10 + colD);
    army.put(row1*10 + col1, s);
  }
  public Soldado soldiersFight(Soldado a, Soldado b, int rowP, int colP, int rowD, int colD){
    double probabilityA = (double) a.getActualLife() / (a.getActualLife() + b.getActualLife()) * 100;
    double probabilityB = (double) b.getActualLife() / (a.getActualLife() + b.getActualLife()) * 100;

    System.out.println("Probability of " + a.getName() + ": " + probabilityA + "%");
    System.out.println("Probability of " + b.getName() + ": " + probabilityB + "%");

    Random random = new Random();
    double probabilityT = probabilityA + probabilityB;
    double randomValue = random.nextDouble() * probabilityT;

    Soldado winner;
    if (randomValue < probabilityA) {
        System.out.println("The winner is: " + a.getName());
        b.die();
        winner = a;
    } else {
        System.out.println("The winner is: " + b.getName());
        a.die();
        winner = b;
    }
    winner.setActualLife(winner.getActualLife() + 1);
    moveSoldier(winner, rowP, colP, rowD, colD);
    return winner;
  }
}