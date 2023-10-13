// Laboratorio Nro 05 - Ejercicio01
// Autor : Hernan Andy
// Colaboro : -
// Tiempo : -

public class DemoBatalla {
  static Soldado[][] army;
  public static void main(String [] args){
  
  
  
  }

  public static void createArmy(Soldado army[][]){
    int numSoldiers = (int) (Math.random() * 10) + 1;
    for (int i = 0; i < numSoldiers; i++){
      Soldado s = new Soldado();
      s.setHealth((int) (Math.random() * 5) + 1);
      
    }
  }
  
  public static void locateSoldier(Soldado s){

  }

}