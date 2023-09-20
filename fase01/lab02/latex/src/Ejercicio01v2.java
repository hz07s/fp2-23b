  public static String ingreseLetra(){
    String laLetra;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese letra: ");
    laLetra = sc.next().toUpperCase();
    char c = laLetra.charAt(0);
    while(laLetra.length()!= 1 || (int)c < 65 || (int)c > 90){
      System.out.println("ERROR CARACTER NO ADMITIDO - Ingrese letra: ");
      laLetra = sc.next();
    }
    return laLetra;
  }