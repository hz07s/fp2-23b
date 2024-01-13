public class Arquero extends Soldado{
  private int numFlechas;

  public Arquero(VideoJuego8 VideoJuego8,String name, int row, char column, char team, 
  int speed, String attitude, boolean lives, String reino){
    super(VideoJuego8, name, row, column, team, speed, attitude, lives, reino);
    setAttackLevel(7);
    setLevelDefense(3);
    setLevelLife((int)(Math.random() * 3) + 3);
    setActualLife(getLevelLife());
    setType('A');
  }

  public Arquero(Mapa map, Ejercito ej, int row, int col) {
    super();
  }

  public void disparar(){
    if (numFlechas > 0)
      attack(1);
      numFlechas--;
  }
}