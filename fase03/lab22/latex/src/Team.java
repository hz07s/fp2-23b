import java.util.ArrayList;

public class Team {
  private ArrayList<Ejercito> teams = new ArrayList<Ejercito>();
  private int numArmy;
  
  public Team (Mapa map, char name) {
    numArmy = (int) (Math.random() * 10) + 1;
    
    for (int i = 0; i < numArmy; i++) {
      Ejercito t = createArmy(map, name);
      teams.add(t);
      map.addArmy(t, t.getRow(), t.getCol());
    }
  }

  public ArrayList<Ejercito> getTeams(){
    return teams; 
  }

  public Ejercito createArmy (Mapa map, char n) {
    int row, col;
    do {
        row = (int) (Math.random() * 10);
        col = (int) (Math.random() * 10);
    } while (map.checkArmy(row, col));
    
    Ejercito a = new Ejercito(map, n);
    a.setRow(row);
    a.setCol(col);
    a.setPosition(row * 10 + col);
    a.setId(a.getNumSoldiers() + "-" + a.getSumLifeLevel());
    return a;
  }
}
