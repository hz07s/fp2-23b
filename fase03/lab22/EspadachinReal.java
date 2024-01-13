public class EspadachinReal extends Espadachin{
  private Cuchillos cuchillos;
  private byte nivelEvolucion;

  public EspadachinReal() {
    cuchillos = new Cuchillos();
    setActualLife(12);
    setLifeLevel(12);
    setType("E+");
  }

  public void evolucion() {
    if (nivelEvolucion < 4){
      if (cuchillos.getCantidad() < 4)
        cuchillos.setCantidad(cuchillos.getCantidad() + 1);

      if (cuchillos.getTamaño() < 5)
        cuchillos.setTamaño(cuchillos.getTamaño() + 1);  
      
      if (nivelEvolucion < 3)
        nivelEvolucion++;
    }
  }

  public void lanzarCuchillos(int n) { // agregar objetivo
    if (cuchillos.getCantidad() > 0) 
      cuchillos.setCantidad(cuchillos.getCantidad() - n);;
    //mas
  }
}