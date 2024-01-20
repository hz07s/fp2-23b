public class EspadachinReal extends Espadachin{
  private Cuchillos cuchillos;
  private byte nivelEvolucion;

  public EspadachinReal(Mapa map, Ejercito ej, int row, int col, char columnC, int position, 
                        int i, String kingdom, char team) {
    setRow(row);
    setCol(col);
    setColumnC(columnC);
    setPosition(position);
    setName("Soldado" + team + i);
    setkingdom(kingdom);
    setTeam(team);
    setLives(true);

    cuchillos = new Cuchillos();
    setActualLife(12);
    setLifeLevel(12);
    setType("Espadachin Real");
    setId("ER" + getActualLife());
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