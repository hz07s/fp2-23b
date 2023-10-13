public class Nave {
  private String name;
  private int row;
  private String column;
  private boolean status;
  private int health;

  // Metodos mutadores
  public void setName( String n){
    name = n;
  }
  public void setRow(int f){
    row = f;
  }
  public void setColumn(String c){
    column = c;
  }
  public void setStatus(boolean e){
    status = e;
  }
  public void setHealth(int p){
    health = p;
  }

  // Metodos accesores
  public String getName(){
    return name;
  }
  public int getRow(){
    return row;
  }
  public String getColumn(){
    return column;
  }
  public boolean getStatus(){
    return status;
  }
  public int getHealth(){
    return health;
  }
  
  // Completar con otros métodos necesarios

}