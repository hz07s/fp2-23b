public class Espadachin extends Soldado{
  private int longitudEspada;

  public Espadachin(VideoJuego8 VideoJuego8,String name, int row, char column, char team, 
  int speed, String attitude, boolean lives, String reino){
    super(VideoJuego8, name, row, column, team, speed, attitude, lives, reino);
    setAttackLevel(10);
    setLevelDefense(8);
    setLevelLife((int) (Math.random() * 3) + 8);
    setActualLife(getLevelLife());
    setType('E');
  }
  public Espadachin(Mapa map, Ejercito ej) {
    super();
  }
  public void crearMuroEscudo(){

  }
}