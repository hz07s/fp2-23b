public class Arquero extends Soldado{
  private Flechas flechas;

  public Arquero(){
    
  }

  public Arquero(Mapa map, Ejercito ej) {
    setAttackLevel(7);
    setDefenseLevel(3);
    int life = (int) (Math.random() * (5 - 3 + 1) + 3);
    setLifeLevel(life);
    setActualLife(life);
    setType("A-");
  }

  public void disparar(){
    if (flechas.getCantidad() > 0)
      //attack(1);
      flechas.setCantidad(flechas.getCantidad() - 1);
  }
}