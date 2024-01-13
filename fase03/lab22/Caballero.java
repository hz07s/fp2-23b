public class Caballero extends Soldado{
  private String arma; 
  private boolean montado;

  public Caballero(){

  }

  public Caballero(Mapa map, Ejercito ej) {
    switch (ej.getKingdom()) {
      case ("Francia") -> { //Caballero Franco
        new CaballeroFranco();
      }
      case ("Moros") -> { //Caballero Moro
        new CaballeroMoro();
      }
      default -> {
        setAttackLevel(13);
        setDefenseLevel(7);
        int life = (int) (Math.random() * (12 - 10 + 1) + 10);
        setLifeLevel(life);
        setActualLife(life);
        setType("C-");
      }
    }
  }
  public void alternarArma(){
    if (arma.equals("espada"))
      arma = "lanza";
    else
      arma = "espada";
  }

  public void desmontar(){
    if (montado){
      montado = false;
      arma = "espada";
    }
  }

  public void montar(){
    if (!montado){
      montado = true;
      arma = "lanza";
    }
  }

  public void envestir(){
    //if(montado)
      //attack(3);
    //else
      //attack(2);
  }
}