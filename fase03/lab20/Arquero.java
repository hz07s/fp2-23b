public class Arquero extends Soldado{
  private int numFlechas;

  public Arquero(VideoJuego7 VideoJuego7,String name, int row, char column, char team, 
  int speed, String attitude, boolean lives, String reino){
    super(VideoJuego7, name, row, column, team, speed, attitude, lives, reino);
    setAttackLevel(7);
    setLevelDefense(3);
    setLevelLife((int)(Math.random() * 3) + 3);
    setActualLife(getLevelLife());
    setType('A');
  }

  public void disparar(){
    if (numFlechas > 0)
      attack(1);
      numFlechas--;
  }
}
