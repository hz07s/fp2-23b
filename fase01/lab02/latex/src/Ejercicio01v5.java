package fase01.lab02;
import java.util.Scanner;
public class Ejercicio01 {
  public static void main(String []args){
    String ahor1 =  " +---+  \n" +
                    " |   |  \n" +
                    "     |  \n" +
                    "     |  \n" +
                    "     |  \n" +
                    "     |  \n" +
                    "========= ";
//
    String ahor2 =  " +---+   \n"+
                    " |   |   \n"+
                    " O   |   \n"+
                    "     |   \n"+
                    "     |   \n"+
                    "     |   \n"+
                    "=========";
//
    String ahor3 =  " +---+   \n"+
                    " |   |   \n"+
                    " O   |   \n"+
                    " |   |   \n"+
                    "     |   \n"+
                    "     |   \n"+
                    "=========";
//
    String ahor4 =  " +---+   \n"+
                    " |   |   \n"+
                    " O   |   \n"+
                    "/|   |   \n"+
                    "     |   \n"+
                    "     |   \n"+
                    "=========";
//
    String ahor5 =  " +---+   \n"+
                    " |   |   \n"+
                    " O   |   \n"+
                    "/|\\ |   \n"+
                    "     |   \n"+
                    "     |   \n"+
                    "=========";
//
    String ahor6 =  " +---+   \n"+
                    " |   |   \n"+
                    " O   |   \n"+
                    "/|\\ |   \n"+
                    "/    |   \n"+
                    "     |   \n"+
                    "=========";
//
    String ahor7 =  " +---+   \n"+
                    " |   |   \n"+
                    " O   |   \n"+
                    "/|\\ |   \n"+
                    "/ \\ |   \n"+
                    "     |   \n"+
                    "=========";
//
    String [] figuras = {ahor1, ahor2, ahor3,ahor4,ahor5,ahor6,ahor7};
    int contador = 1;
    String letra;
// posiblemente en lugar de identacion seria : indentacion;
    String [] palabras = {"programacion", "java", "identacion", "clases",
    "objetos", "desarrollador", "pruebas"};

    String palSecreta = getPalabraSecreta(palabras);
    System.out.println(figuras[0]);
    String blancos = mostrarBlancos(palSecreta);
  
    System.out.println("\n");

    while(contador <= 6){
      letra = ingreseLetra();
      if (letraEnPalabraSecreta(letra, palSecreta)){
        blancos = mostrarBlancosActualizados(letra, palSecreta, blancos);
        if ()
      }
      else
        System.out.println(figuras[contador]);
      contador = contador +1;
    }

    if () {

    }
    //COMPLETAR PARA INDICAR SI GANÓ, PERDIÓ Y CUÁNTOS TURNOS NECESITÓ
    System.out.println("\n");
  }

  public static String getPalabraSecreta(String [] lasPalabras){
    //String palSecreta;
    int ind;
    int indiceMayor = lasPalabras.length -1;
    int indiceMenor = 0;
    ind = (int) (Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor);
    return lasPalabras[ind];
  }

  public static String mostrarBlancos(String palabra){
    String blancos = "";
    for(int i = 0; i < palabra.length(); i++) {
      blancos += "_";
    }
    for (int i = 0; i < blancos.length(); i++) {
      System.out.println(blancos.charAt(i) + " ");
    }
    return blancos;
  }

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
    
  public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
    for (int i = 0; i < palSecreta.length(); i++) {
      if (palSecreta.charAt(i) == letra.charAt(0))
        return true;
    }
    return false;
  }

  public static String mostrarBlancosActualizados(String letra, String palabra, String blancos){
    System.out.println("PROCESANDO...");
    // la variable newBlancos sirve para guardar los valores de blancos y no perderlos
    String newBlancos = "";
    char c = letra.charAt(0);
    for(int i = 0; i < palabra.length(); i++) {
      if (palabra.charAt(i) == c)
        newBlancos += c;
      else
        newBlancos += blancos.charAt(i); // asi usaremos el antiguo blancos
    }
    for (int i = 0; i < blancos.length(); i++) {
      System.out.println(blancos.charAt(i) + " ");
    }
    // retornamos blancos y asi guardarlos para la proxima coincidencia de la palabraSecreta
    return newBlancos;
  }
}