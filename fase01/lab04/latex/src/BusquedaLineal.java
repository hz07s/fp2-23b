  //Método para buscar la primera nave con un nombre que se pidió por teclado
  public static int busquedaLinealNombre(Nave[] flota, String s){
    for (int i = 0; i < flota.length; i++){
      if (flota[i].getNombre().equals(s))
        return i;
    }
    System.out.println("No se encontró");
    return -1;
  }