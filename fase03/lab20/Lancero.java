public class Lancero extends Soldado{

  public Lancero(VideoJuego7 VideoJuego7,String name, int row, char column, char team, 
  int speed, String attitude, boolean lives, String reino){
    super(VideoJuego7, name, row, column, team, speed, attitude, lives, reino);
    setAttackLevel(5);
    setLevelDefense(10);
    setLevelLife((int)(Math.random() * 4) + 5);
    setActualLife(getLevelLife());
    setType('L');
  }
}
