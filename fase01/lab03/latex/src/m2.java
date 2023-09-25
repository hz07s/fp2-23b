  //Método para mostrar todas las naves de un nombre que se pide por teclado
  public static void mostrarPorNombre(Nave [] flota){
    Scanner sc = new Scanner(System.in);
    String name = sc.next();

    for (int i = 0; i < flota.length; i++){
      if (flota[i].getNombre().equals(name))
        mostrarNave(flota[i]);
    }
  }