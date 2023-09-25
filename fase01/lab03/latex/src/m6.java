  public static void mostrarNave(Nave nave){
    System.out.println("\n Nave: " + nave.getNombre());
    if (nave.getEstado())
      System.out.println("Estado : Alive");
      else
      System.out.println("Estado : Dead");
    System.out.println("Puntos : " + nave.getPuntos());
    
  }