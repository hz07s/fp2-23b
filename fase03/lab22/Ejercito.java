import java.util.ArrayList;
public class Ejercito {
  private String kingdom;
  private char name;
  private ArrayList<Soldado> army = new ArrayList<Soldado>();
  
  public Ejercito(Mapa map, char name){
    String[] reinos = {"Inglaterra", "Francia","Castilla-Aragon",
                       "Moros", "Sacro Imperio Romano-Germanico"};
    kingdom = reinos[(int) (Math.random() * reinos.length)];
    
    int n = (int) (Math.random() * 10) + 1;
    for (int i = 0; i < n; i++) {
      Soldado s = createSoldier(map, this, name, i);
      army.add(s);
      map.addSoldier(s, s.getRow(), s.getCol());
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

  public void setArmy(ArrayList<Soldado> army){
    this.army = army;
  }

  public ArrayList<Soldado> getArmy(){
    return army;
  }

  public Soldado createSoldier(Mapa map, Ejercito ej, char nameEj, int i ){
    int row, col;
    do {
      row = (int) (Math.random() * 10);
      col = (int) (Math.random() * 10);
    } while (map.checkSoldier(row, col));

    String[] typeSoldier = {"Espadachin", "Caballero", "Arquero", "Lancero"};
    int typ = (int) (Math.random() * typeSoldier.length);
    switch (typ) {
      case 0 -> {
        switch (ej.getKingdom()) {
          case ("Inglaterra") ->{
            return new EspadachinReal(map, ej, row, col, (char) (col + 'A'), 
            row * 10 + col, i, ej.getKingdom(), nameEj);
          }
          case ("Castilla-Aragon") ->{
            return new EspadachinConquistador(map, ej, row, col, (char) (col + 'A'), 
            row * 10 + col, i, ej.getKingdom(), nameEj);
          }
          case ("Sacro Imperio Romano-Germanico") ->{
            return new EspadachinTeutonico(map, ej, row, col, (char) (col + 'A'), 
            row * 10 + col, i, ej.getKingdom(), nameEj);
          }
          default -> {
            return new Espadachin(map, ej, row, col, (char) (col + 'A'), 
            row * 10 + col, i, ej.getKingdom(), nameEj);
          }
        }
      }
      case 1 -> {
        switch (ej.getKingdom()) {
          case ("Francia") ->{
            return new CaballeroFranco(map, ej, row, col, (char) (col + 'A'), 
            row * 10 + col, i, ej.getKingdom(), nameEj);
          }
          case ("Moros") ->{
            return new CaballeroMoro(map, ej, row, col, (char) (col + 'A'), 
            row * 10 + col, i, ej.getKingdom(), nameEj);
          }
          default -> {
            return new Caballero(map, ej, row, col, (char) (col + 'A'), 
            row * 10 + col, i, ej.getKingdom(), nameEj);
          }
        }
      }
      case 2 -> {
        return new Arquero(map, ej, row, col, (char) (col + 'A'), 
          row * 10 + col, i, ej.getKingdom(), nameEj);
      }
      case 3 -> {
        return new Lancero(map, ej, row, col, (char) (col + 'A'), 
        row * 10 + col, i, ej.getKingdom(), nameEj);
      }
    }
    return null;
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