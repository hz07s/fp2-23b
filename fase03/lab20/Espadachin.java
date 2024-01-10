public class Espadachin extends Soldado{
  private int longitudEspada;

  public Espadachin(){
    setAttackLevel(10);
    setLevelDefense(8);
    setLevelLife((int) (Math.random() * 3) + 8);
    setActualLife(getLevelLife());
  }
  public void crearMuroEscudo(){

  }

}
