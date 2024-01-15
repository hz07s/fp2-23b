public class Caballero extends Soldado{
  private String arma; 
  private boolean montado;

  public Caballero(){

  }

  public Caballero(Mapa map, Ejercito ej, int row, int col, char columnC, int position, 
                   int i, String kingdom, char team) {
    setRow(row);
    setCol(col);
    setColumnC(columnC);
    setPosition(position);
    setName("Soldado" + team + i);
    setkingdom(kingdom);
    setTeam(team);
    setLives(true);
    
    setAttackLevel(13);
    setDefenseLevel(7);
    int life = (int) (Math.random() * (12 - 10 + 1) + 10);
    setLifeLevel(life);
    setActualLife(life);
    setType("Caballero");
  }
  public void alternarArma(){
    if (arma.equals("espada"))
      arma = "lanza";
    else
      arma = "espada";
  }

  public void desmontar(){
    if (montado){
      montado = false;
      arma = "espada";
    }
  }

  public void montar(){
    if (!montado){
      montado = true;
      arma = "lanza";
    }
  }

  public void envestir(){
    //if(montado)
      //attack(3);
    //else
      //attack(2);
  }
}