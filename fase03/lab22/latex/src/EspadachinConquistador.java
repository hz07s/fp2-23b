public class EspadachinConquistador extends Espadachin{
  private Hachas hachas;
  private byte nivelEvolucion;

  public EspadachinConquistador(Mapa map, Ejercito ej, int row, int col, char columnC, int position, 
                                int i, String kingdom, char team) {
    setRow(row);
    setCol(col);
    setColumnC(columnC);
    setPosition(position);
    setName("Soldado" + team + i);
    setkingdom(kingdom);
    setTeam(team);
    setLives(true);

    hachas = new Hachas();
    setActualLife(14);
    setLifeLevel(14);
    setType("Espadachin Conquistador");
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
