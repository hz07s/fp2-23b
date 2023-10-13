public class Nave {
  private String name;
  private int row;
  private String column;
  private boolean status;
  private int health;

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
  
}