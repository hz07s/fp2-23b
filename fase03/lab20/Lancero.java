public class Lancero extends Soldado{
  

  public Lancero(){
    setAttackLevel(5);
    setLevelDefense(10);
    setLevelLife((int)(Math.random() * 4) + 5);
    setActualLife(getLevelLife());
  }
}
