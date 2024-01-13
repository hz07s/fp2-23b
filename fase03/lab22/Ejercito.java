import java.util.ArrayList;
public class Ejercito {
  private String kingdom;
  private char name;
  private ArrayList<Soldado> army;
  
  public Ejercito(Mapa map){
    String[] reinos = {"Castilla", "Aragon", "Moros", "Sacro Imperio Romano Germanico"};
    kingdom = reinos[(int) (Math.random() * reinos.length)];
    
    int n = (int) (Math.random() * 10) + 1;
    for (int i = 0; i < n; i++) {
      Soldado s = new Soldado(map, this, name);
      army.add(s);
    }
  }

  public Ejercito(int n){
    //Ejercito personalizado
  }

  public void setKingdom(String kingdom){
    this.kingdom = kingdom;
  }

  public String getKingdom(){
    return kingdom;
  }

  public void setName(char name){
    this.name = name;
  }

  public char getName(){
    return name;
  }
}
