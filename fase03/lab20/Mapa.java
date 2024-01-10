public class Mapa {
  private String territory;


  String[] typesTerritory ={"bosque","campoAbierto", "montaña", "desierto", "playa"};

  public Mapa (){
    this.territory =  typesTerritory[(int) (Math.random() * typesTerritory.length)];

  }
  
  public void setTerritory(String territory) {
    this.territory = territory;
  }

  public String getTerritory() {
    return territory;
  }


  
}
