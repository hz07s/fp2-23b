public class Caballero {
  private String arma; 
  private boolean montado;






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
