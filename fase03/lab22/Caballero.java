public class Caballero extends Soldado{
  private String arma; 
  private boolean montado;

  public Caballero(VideoJuego8 VideoJuego8,String name, int row, char column, char team, 
  int speed, String attitude, boolean lives, String reino){
    super(VideoJuego8, name, row, column, team, speed, attitude, lives, reino);
    setAttackLevel(13);
    setLevelDefense(7);
    setLevelLife((int)(Math.random() * 3) + 10);
    setActualLife(getLevelLife());
    setType('C');
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
    if(montado)
      attack(3);
    else
      attack(2);
  }
}