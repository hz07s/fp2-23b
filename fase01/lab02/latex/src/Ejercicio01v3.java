  public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
    for (int i = 0; i < palSecreta.length(); i++) {
      if (palSecreta.charAt(i) == letra.charAt(0))
        return true;
    }
    return false;
  }