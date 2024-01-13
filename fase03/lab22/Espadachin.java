public class Espadachin extends Soldado{
  private int longitudEspada;

  //personalizado
  public Espadachin(){
    
  }

  //aleatorio 
  public Espadachin(Mapa map, Ejercito ej) {
    switch (ej.getKingdom()) {
      case ("Inglaterra") -> { //Espadachin Real
        new EspadachinReal();
      }
      case ("Castilla-Aragon") -> { //Espadachin Teutonico
        new EspadachinConquistador();
      }
      case ("Sacro Imperio Romano-Germanico") -> { //Espadachin Conquistador
        new EspadachinTeutonico();
      }
      default -> {
        setAttackLevel(10);
        setDefenseLevel(8);
        int life = (int) (Math.random() * (10 - 8 + 1) + 8);
        setLifeLevel(life);
        setActualLife(life);
        setType("E-");
      }
    }
  }

  public void crearMuroEscudo(){
    
  }
}