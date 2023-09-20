  public static String[] createArmy() {
    int n = (int) (Math.random() * 5) + 1;
    String [] army = new String[n];
    for (int i = 0; i < n; i++) {
      army[i] = "Soldado" + i; 
    }
    return army;
  }