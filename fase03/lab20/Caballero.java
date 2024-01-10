public class Caballero extends Soldado{
  private String arma; 
  private boolean montado;



  public Caballero(){
    setAttackLevel(13);
    setLevelDefense(7);
    setLevelLife((int)(Math.random() * 3) + 10);
    setActualLife(getLevelLife());
  }


  public void alternarArma(String arma){
    this.arma = arma;
  }

  public void desmontar(){
    if (montado)
      montado = false;

  }

  public void montar(){
    if (!montado)
      montado = true;  
  }

}
