public class CaballeroFranco extends Caballero{
  private Lanzas lanzas;
  private byte nivelEvolucion;

  public CaballeroFranco() {
    lanzas = new Lanzas();
    setActualLife(15);
    setLifeLevel(15);
    setType("C+");
  }

  public void evolucion() {
    if (nivelEvolucion < 4){
      if (lanzas.getCantidad() < 4)
        lanzas.setCantidad((byte) (lanzas.getCantidad() + 1));

      if (lanzas.getTamaño() < 5)
      lanzas.setTamaño((byte) (lanzas.getTamaño() + 1));  
      
      if (nivelEvolucion < 3)
        nivelEvolucion++;
    }
  }

  public void lanzarLanzas(int n) { // agregar objetivo
    if (lanzas.getCantidad() > 0) 
      lanzas.setCantidad((byte) (lanzas.getCantidad() - n));;
    //mas
  }
}
