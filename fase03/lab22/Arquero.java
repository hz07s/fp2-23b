public class Arquero extends Soldado{
  private Flechas flechas;

  public Arquero(){
    
  }

  public Arquero(Mapa map, Ejercito ej, int row, int col, char columnC, int position, 
                 int i, String kingdom, char team) {
    setRow(row);
    setCol(col);
    setColumnC(columnC);
    setPosition(position);
    setName("Soldado" + team + i);
    setkingdom(kingdom);
    setTeam(team);
    setLives(true);

    setAttackLevel(7);
    setDefenseLevel(3);
    int life = (int) (Math.random() * (5 - 3 + 1) + 3);
    setLifeLevel(life);
    setActualLife(life);
    setType("Arquero");
    setId(" A"+ getLifeLevel() + " ");
    setId(" A" + getActualLife());
  }

  public void disparar(){
    if (flechas.getCantidad() > 0)
      //attack(1);
      flechas.setCantidad(flechas.getCantidad() - 1);
  }
}