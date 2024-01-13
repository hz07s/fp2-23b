import java.util.ArrayList;
public class Ejercito {
  private String kingdom;
  private char name;
  private ArrayList<Soldado> army;
  
  public Ejercito(Mapa map){
    String[] reinos = {"Inglaterra", "Francia","Castilla-Aragon",
                       "Moros", "Sacro Imperio Romano-Germanico"};
    kingdom = reinos[(int) (Math.random() * reinos.length)];
    
    int n = (int) (Math.random() * 10) + 1;
    for (int i = 0; i < n; i++) {
      Soldado s = new Soldado(map, this, name);
      army.add(s);
    }
    if (benefits(map)){
      for (Soldado s : army){
        s.setActualLife(s.getActualLife() + 1);
        s.setLifeLevel(s.getLifeLevel() + 1);
      }
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

  public boolean benefits(Mapa m){
    String t = m.getTerritory();
    switch (kingdom) {
      case ("Inglaterra") -> {
        if (t.equals("Bosque"))
          return true;
      }
      case ("Francia") -> {
        if (t.equals("Campo Abierto"))
          return true;
      }
      case ("Castilla-Aragon") -> {
        if (t.equals("Montaña"))
          return true;
      }
      case ("Moros") -> {
        if (t.equals("Desierto"))
          return true;
      }
      case ("Sacro Imperio Romano-Germanico") -> {
        if (t.equals("Bosque") || t.equals("Playa") || 
            t.equals("Campo Abierto"))
          return true;
      }
    }
    return false;
  }
}