public class Mapa {
  private static Mapa instanciaSingleton;
  private String[] typesTerritory ={"bosque","campoAbierto", "montaña", "desierto", "playa"};
  private String territory;
  private Soldado[][] board;
  
  private Mapa(){}

  public static Mapa getInstance() {
    if (instanciaSingleton == null) 
      instanciaSingleton = new Mapa();
    return instanciaSingleton;
  }
  
  public void setTerritory(String territory) {
    this.territory = territory;
  }
  
  public String getTerritory() {
    return territory;
  }

  public void setBoard(Soldado[][] board){
    this.board = board;
  }

  public Soldado[][] getBoard(){
    return board;
  }

  public void setRandomMapa (){
    this.territory =  typesTerritory[(int) (Math.random() * typesTerritory.length)];
  }
}