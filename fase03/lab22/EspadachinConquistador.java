public class EspadachinConquistador extends Espadachin{
  private Hachas hachas;
  private byte nivelEvolucion;

  public EspadachinConquistador() {
    hachas = new Hachas();
    setActualLife(14);
    setLifeLevel(14);
    setType("E+");
  }

  public void evolucion() {
    if (nivelEvolucion < 4){
      if (hachas.getCantidad() < 4)
        hachas.setCantidad(hachas.getCantidad() + 1);

      if (hachas.getTamaño() < 5)
        hachas.setTamaño(hachas.getTamaño() + 1);  
      
      if (nivelEvolucion < 3)
        nivelEvolucion++;
    }
  }

  public void lanzarHachas(int n) { // agregar objetivo
    if (hachas.getCantidad() > 0) 
      hachas.setCantidad(hachas.getCantidad() - n);;
    //mas
  }
}
