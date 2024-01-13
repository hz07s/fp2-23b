public class CaballeroMoro extends Caballero{
  private Flechas flechas;
  private byte nivelEvolucion;

  public CaballeroMoro() {
    flechas = new Flechas();
    setActualLife(12);
    setLifeLevel(12);
    setType("E+");
  }

  public void evolucion() {
    if (nivelEvolucion < 4){
      if (flechas.getCantidad() < 4)
        flechas.setCantidad(flechas.getCantidad() + 1);

      if (flechas.getTamaño() < 5)
        flechas.setTamaño(flechas.getTamaño() + 1);  
      
      if (nivelEvolucion < 3)
        nivelEvolucion++;
    }
  }

  public void lanzarFlechas(int n) { // agregar objetivo
    if (flechas.getCantidad() > 0) 
      flechas.setCantidad(flechas.getCantidad() - n);;
    //mas
  }
}