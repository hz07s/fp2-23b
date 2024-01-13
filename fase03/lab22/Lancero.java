public class Lancero extends Soldado{
  private int longLanza;

  public Lancero(VideoJuego8 VideoJuego8,String name, int row, char column, char team, 
  int speed, String attitude, boolean lives, String reino){
    super(VideoJuego8, name, row, column, team, speed, attitude, lives, reino);
    setAttackLevel(5);
    setLevelDefense(10);
    setLevelLife((int)(Math.random() * 4) + 5);
    setActualLife(getLevelLife());
    setType('L');
  }

  public Lancero(Mapa map, Ejercito ej, int row, int col) {
    super();
  }

  public void schiltrom(){
    setLevelDefense(getLevelDefense() + 1);
  }
}