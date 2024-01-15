import java.util.Arrays;
import java.util.List;
public class Mapa {
  private static Mapa instanciaSingleton;
  private String[] typesTerritory ={"Bosque","CampoAbierto", "Montaña", "Desierto", "Playa"};
  private String territory;
  private Soldado[][] board = new Soldado[10][10];
  
  private Mapa(){}

  public static Mapa getInstance() {
    if (instanciaSingleton == null) 
      instanciaSingleton = new Mapa();
    return instanciaSingleton;
  }
  
  public void setTerritory(String territory) {
    List<String> typesTerritory2 = Arrays.asList(typesTerritory);
    if (typesTerritory2.contains(territory))
      this.territory = territory;
    else{
      //Mensaje error
    } 
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

  public void addSoldier(Soldado s, int r, int c){
    board[r][c] = s;
  }

  public boolean checkSoldier(int r, int c){
    return board[r][c] != null;
  }
  
  public void editDeleteBoard(int r, int c){
    board[r][c] = null;
  }
}