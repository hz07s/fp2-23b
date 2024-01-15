public class CaballeroFranco extends Caballero{
  private Lanzas lanzas;
  private byte nivelEvolucion;

  public CaballeroFranco(Mapa map, Ejercito ej, int row, int col, char columnC, int position, 
                         int i, String kingdom, char team) {
    setRow(row);
    setCol(col);
    setColumnC(columnC);
    setPosition(position);
    setName("Soldado" + team + i);
    setkingdom(kingdom);
    setTeam(team);
    setLives(true);

    lanzas = new Lanzas();
    setActualLife(15);
    setLifeLevel(15);
    setType("Caballero Franco");
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
