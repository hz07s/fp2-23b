public class Espadachin extends Soldado{
  private int longitudEspada;

  public Espadachin(VideoJuego7 VideoJuego7,String name, int row, char column, char team, 
  int speed, String attitude, boolean lives, String reino){
    super(VideoJuego7, name, row, column, team, speed, attitude, lives, reino);
    setAttackLevel(10);
    setLevelDefense(8);
    setLevelLife((int) (Math.random() * 3) + 8);
    setActualLife(getLevelLife());
    setType('E');
  }
  public void crearMuroEscudo(){

  }

}
