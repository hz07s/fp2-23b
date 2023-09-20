  public static String mostrarBlancosActualizados(String letra, String palabra, String blancos){
    System.out.println("PROCESANDO...");
    // la variable newBlancos sirve para guardar los valores de blancos y no perderlos
    String newBlancos = "";
    char c = letra.charAt(0);
    for(int i = 0; i < palabra.length(); i++) {
      if (palabra.charAt(i) == c)
        newBlancos += c + " ";
      else
        newBlancos += blancos.charAt(i * 2) + " "; // asi usaremos el antiguo blancos
    }
    System.out.println(blancos);
    // retornamos blancos y asi guardarlos para la proxima coincidencia de la palabraSecreta
    return newBlancos;
  }