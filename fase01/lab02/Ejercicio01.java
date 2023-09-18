// Laboratorio Nro 02 - Ejercicio01
// Autor : Hernan Andy
// Colaboró : -
// Tiempo : -

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
                    "/|\\  |   \n"+
                    "     |   \n"+
                    "     |   \n"+
                    "=========";
//
    String ahor6 =  " +---+   \n"+
                    " |   |   \n"+
                    " O   |   \n"+
                    "/|\\  |   \n"+
                    "/    |   \n"+
                    "     |   \n"+
                    "=========";
//
    String ahor7 =  " +---+   \n"+
                    " |   |   \n"+
                    " O   |   \n"+
                    "/|\\  |   \n"+
                    "/ \\  |   \n"+
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
        if (palSecreta.equals(blancos))
          break;
      }
      else 
        System.out.println(figuras[contador]);
      contador = contador +1;
    }

    if (contador == 7){
      System.out.println("Perdiste");
      System.out.println("La palabra secreta era : " + palSecreta);
    } else {
      System.out.println("Ganaste");
      System.out.println("Nro de intentos : " + contador);
    }
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
      System.out.print(blancos.charAt(i) + " ");
    }
    return blancos;
  }

  public static String ingreseLetra(){
    String laLetra;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese letra: ");
    laLetra = sc.next().toLowerCase();
    char c = laLetra.charAt(0);
    while(laLetra.length()!= 1 || (int)c < 97 || (int)c > 122){
      System.out.println("ERROR - CARACTER NO ADMITIDO - Ingrese letra: ");
      laLetra = sc.next().toLowerCase();
      c = laLetra.charAt(0);
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
    for (int i = 0; i < newBlancos.length(); i++) {
      System.out.print(newBlancos.charAt(i) + " ");
    }
    System.out.println("");
    // retornamos blancos y asi guardarlos para la proxima coincidencia de la palabraSecreta
    return newBlancos;
  }
}
/*
Luego de haber terminado el codigo, siento que el contador del main deberia incluirse dentro del else,
ya que como se presenta ahora es imposible ganar si es que le toca palabras con mas de 6 letras distintas
como lo es programacion y el incluirlo dentro del else ayudaría a ello
 */