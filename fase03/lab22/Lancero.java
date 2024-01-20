public class Lancero extends Soldado{
  private int longLanza;

  public Lancero(){
    
  }

  public Lancero(Mapa map, Ejercito ej, int row, int col, char columnC, int position, 
                 int i, String kingdom, char team) {
    setRow(row);
    setCol(col);
    setColumnC(columnC);
    setPosition(position);
    setName("Soldado" + team + i);
    setkingdom(kingdom);
    setTeam(team);
    setLives(true);

    setAttackLevel(5);
    setDefenseLevel(10);
    int life = (int) (Math.random() * (8 - 5 + 1) + 5);
    setLifeLevel(life);
    setActualLife(life);
    setType("Lancero");
    setId(" L" + getLifeLevel() + " ");
  }

  public void setLongLanza(int longLanza){
    this.longLanza = longLanza;
  }

  public int getLongLanza() {
    return longLanza;
  }

  public void schiltrom(){
    setDefenseLevel(getDefenseLevel() + 1);
  }
}