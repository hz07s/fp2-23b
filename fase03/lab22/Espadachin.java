public class Espadachin extends Soldado{
  private int longEspada;

  //personalizado
  public Espadachin(){
    
  }

  //aleatorio 
  public Espadachin(Mapa map, Ejercito ej, int row, int col, char columnC, int position, 
                    int i, String kingdom, char team) {
    setRow(row);
    setCol(col);
    setColumnC(columnC);
    setPosition(position);
    setName("Soldado" + team + i);
    setkingdom(kingdom);
    setTeam(team);
    setLives(true);
    
    setAttackLevel(10);
    setDefenseLevel(8);
    
    int life = (int) (Math.random() * (10 - 8 + 1) + 8);
    setLifeLevel(life);
    setActualLife(life);
    setType("Espadachin");
    setId(" E" + getActualLife() + (life > 10 ? " ": ""));
  }

  public void setLongEspada(int longEspada){
    this.longEspada = longEspada;
  }

  public int getLongEspada() {
    return longEspada;
  }

  public void crearMuroEscudo(){
    
  }
}