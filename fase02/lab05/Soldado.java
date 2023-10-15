public class Soldado {
  private String name;
  private int row;
  private char column;
  private boolean status;
  private int health;

  public Soldado(String name, int row, char column, boolean status, int health) {
    this.name = name;
    this.row = row;
    this.column = column;
    this.status = status;
    this.health = health;
  }

  public void setName(String n){
    name = n;
  }
  public void setRow(int r){
    row = r;
  }
  public void setColumn(String c){
    column = c;
  }
  public void setStatus(boolean s){
    status = s;
  }
  public void setHealth(int h){
    health = h;
  }

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
  @Override
  public String toString() {  
    return "Data{ \n name: " + name + "\n row: " + row + "\n column: " + column + "\n status: " + status + "\n health: " + health + "\n}";
  }
}