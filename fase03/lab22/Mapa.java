public class Mapa {
  private String territory;
  private String[] typesTerritory ={"bosque","campoAbierto", "montaña", "desierto", "playa"};
  public Soldado[][] board;
  public String randomMapa (){
    this.territory =  typesTerritory[(int) (Math.random() * typesTerritory.length)];
    return territory;
  }
  
  public void setTerritory(String territory) {
    this.territory = territory;
  }

  public String getTerritory() {
    return territory;
  }
}