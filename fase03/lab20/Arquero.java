public class Arquero extends Soldado{
  private int numFlechas;

  public Arquero(){
    setAttackLevel(7);
    setLevelDefense(3);
    setLevelLife((int)(Math.random() * 3) + 3);
    setActualLife(getLevelLife());
  }
}
