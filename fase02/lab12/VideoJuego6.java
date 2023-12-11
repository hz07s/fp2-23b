// Laboratorio Nro 12 - Ejercicio01
// Autor : Hernan Andy
// Colaboro : null
// Tiempo : 3 horas
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

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
    System.out.println(  "1. Quick game" 
                      +"\n2. Custom game" 
                      +"\n3. Exit");
    int action = sc.nextInt();
    switch (action){
      case 1 -> quickGame();
      case 2 -> customGame();
      case 3 -> System.out.println("End of the game");
      default -> {
        System.out.println("Choose a valid option");
        mainInterfaz();
      }
    }
  }
  public void customGame(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Select army to customize:\n  1. A\n  2. B");
    int actionTeam = sc.nextInt();
    if (actionTeam  == 1) // A
      customGameArmy(army1DA, "A");
    else if(actionTeam  == 2) // B
      customGameArmy(army1DB, "B");
    else{
      System.out.println("Invalid army, try again");
      customGame();
    }
  }
  public void customGameArmy(HashMap <Integer, Soldado> armyA, String t){
    Scanner sc = new Scanner(System.in);
    System.out.println("Selected " + t + "army");
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
      case 1 -> createSoldier(armyA);
      case 2 -> deleteSoldier(armyA);
      case 3 -> cloneSoldier(armyA);
      case 4 -> modifySoldier(armyA);
      case 5 -> compareSoldiers(armyA);
      case 6 -> swapSoldiers(armyA);
      case 7 -> viewSoldier(armyA);
      case 8 -> seeArmy(armyA);
      case 9 -> addLevels(armyA);
      case 10 -> play(armyA);
      case 11 -> back(armyA);
      default -> {
        System.out.println("Choose a valid option");
        customGameArmy(armyA, t);
      }
    }
    customGameArmy(armyA, t);
  }
  public void createSoldier(HashMap <Integer, Soldado> armyMod){
    Scanner sc = new Scanner(System.in);

  }
  public void deleteSoldier(HashMap <Integer, Soldado> armyMod){
    Scanner sc = new Scanner(System.in);

  }
  public void cloneSoldier(HashMap <Integer, Soldado> armyMod){
    Scanner sc = new Scanner(System.in);

  }
  public void modifySoldier(HashMap <Integer, Soldado> armyMod){
    Scanner sc = new Scanner(System.in);

  }
  public void compareSoldiers(HashMap <Integer, Soldado> armyMod){
    Scanner sc = new Scanner(System.in);

  }
  public void swapSoldiers(HashMap <Integer, Soldado> armyMod){
    Scanner sc = new Scanner(System.in);

  }
  public void viewSoldier(HashMap <Integer, Soldado> armyMod){
    Scanner sc = new Scanner(System.in);

  }
  public void seeArmy(HashMap <Integer, Soldado> armyMod){

  }
  public void addLevels(HashMap <Integer, Soldado> armyMod){

  }
  public void play(HashMap <Integer, Soldado> armyMod){

  }
  public void back(HashMap <Integer, Soldado> armyMod){

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
  public static void printArmyHealth(HashMap <Integer, Soldado> armyPrint, char t){
    System.out.println("EJERCITO " + t + " : ");
    for(int i = 0; i < armyPrint.size(); i++)
      System.out.println((i + 1) + ". " + armyPrint.get(i).getName() + "  Vida: " + armyPrint.get(i).getActualLife());
  }

  public static void armyWinner(){
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