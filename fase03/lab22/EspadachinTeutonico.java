public class EspadachinTeutonico extends Espadachin{
  private Jabalinas jabalinas;
  private byte nivelEvolucion;

  public EspadachinTeutonico() {
    jabalinas = new Jabalinas();
    setActualLife(13);
    setLifeLevel(13);
    setType("E+");
  }

  public void evolucion() {
    if (nivelEvolucion < 4){
      if (jabalinas.getCantidad() < 4)
        jabalinas.setCantidad(jabalinas.getCantidad() + 1);

      if (jabalinas.getTamaño() < 5)
        jabalinas.setTamaño(jabalinas.getTamaño() + 1);  
      
      if (nivelEvolucion < 3)
        nivelEvolucion++;
    }
  }

  public void LanzarJabalinas(int n) { // agregar objetivo
    if (jabalinas.getCantidad() > 0) 
      jabalinas.setCantidad(jabalinas.getCantidad() - n);;
    //mas
  }

  public void modoTortuga(){
    //contenido de habilidad de defensa
  }
}